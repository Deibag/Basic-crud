import React, { useState } from 'react'
import axios from 'axios'
import { useHistory } from 'react-router-dom';
import {useParams} from "react-router-dom";


export default function Update() {

    const history = useHistory();

    let { id } = useParams();

    const [name, setName] = useState("");

    const updateBox = () => {
        console.log(id)
        console.log(name)
    axios.put(`http://localhost:8081/api/boxs/${id}`,
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
        history.push(`/`)
        setTimeout(() => window.location.reload(), 0);
    }
    return (
        <div>
            <button type="button" onClick={updateBox} class="btn btn-info btn-sm mt-2">Update</button>
            <div className="form-group row">
                <div className="col-xs-2 my-2 mx-5">
                    <input onChange={e => setName(e.target.value)} type="text" className="form-control-1" placeholder="Name to update"/>
                </div>
            </div>
        </div>
        
    )
}