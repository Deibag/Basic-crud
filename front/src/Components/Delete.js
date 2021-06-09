import React from 'react'
import axios from 'axios'


export default function Delete( { id } ) {

    const deleteBox = () => {
    axios.delete(`http://localhost:8081/api/boxs/${id}`)
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
            <button type="button" onClick={deleteBox} className="btn btn-danger btn-sm">Delete</button>
        </div>
    )
}