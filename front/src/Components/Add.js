import React, { useState } from 'react'
import axios from 'axios'


export default function Add( { id } ) {

    const [name, setName] = useState("");

    const addBox = () => {
    axios.post(`http://localhost:8081/api/boxs`,
        {
            name
        }
        )
        .then(response => {
            console.log(response.data)
        })
        .catch(err => {
            console.log(err);
        })
        setTimeout(() => window.location.reload(), 100);
    }
    return (
        <div>
            <button type="button" onClick={addBox} class="btn btn-info btn-sm">Add</button>
            <div className="col">
                <input onChange={e => setName(e.target.value)} type="text" class="form-control-2 my-2" placeholder="Name"/>
            </div>
        </div>
    )
}