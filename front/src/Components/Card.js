import React from 'react'
import Delete from './Delete'
import Update from './Update'
import { useHistory } from 'react-router-dom';


export default function Card( {id, name } ) {

    const history = useHistory();

    return (
        <div>
            <div className="card" style={{ width: "200px", marginLeft: "10px", marginTop: "10px" }}>
                <div className="card-body">
                    <p className="card-text">{name}</p>
                    <Delete id={id} />
                    <button onClick={() => history.push(`/update/${id}`)} type="button" class="btn btn-info btn-sm mt-2">Update</button>
                </div>
            </div>
        </div>
    )
}