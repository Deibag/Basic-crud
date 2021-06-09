import React, { useState, useEffect } from 'react'
import axios from 'axios'
import Card from './Card';

export default function List() {

    const API_URL = "http://localhost:8081";
    const [boxes, setBoxes] = useState([]);

    useEffect(() => {
        axios.get(API_URL + "/api/boxs")
            .then(response => {
                setBoxes(response.data);
            })
            .catch(err => {
                console.log(err);
            })
    }, [])


    return(
        <div className="row">
            {boxes.map(box => 
                (<div className="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-3 mt-4 d-flex">
                    <Card id={box.id} name={box.name} />
                </div>)
            )}
        </div>
    )
}