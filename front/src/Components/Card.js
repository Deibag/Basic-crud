import React from 'react'
import Delete from './Delete'
import Update from './Update'


export default function Card( {id, name } ) {

    return (
        <div>
            <div className="card" style={{ width: "200px", marginLeft: "10px", marginTop: "10px" }}>
                <div className="card-body">
                    <p className="card-text">{name}</p>
                    <Delete id={id} />
                    <Update id={id} />
                </div>
            </div>
        </div>
    )
}