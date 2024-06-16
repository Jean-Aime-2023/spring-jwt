import * as React from 'react'
export default function Buttons(props){
    return(
        <div>
            <button onClick={props.login}>Login</button>
            <button onClick={props.logout}>Logout</button>
        </div>
    )
    
}