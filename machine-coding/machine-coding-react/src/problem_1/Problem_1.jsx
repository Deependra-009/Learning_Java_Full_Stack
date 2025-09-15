import React, { useEffect, useRef, useState } from 'react'

export const Problem1=()=>{

    const [count,updateCount]=useState(0);
    let interval=useRef(null);
    const [inc,setInc]=useState(null);
    const [dec,setDec]=useState(null);

    function increment(){
        interval.current = setInterval(()=>{
            updateCount(count => count+1);

        },1000);
    }

    function decrement(){
        clearTimerInterval();
        interval.current=setInterval(()=>{
            updateCount(count => count-1);
        },1000);
    }

    function clearTimerInterval(){
        clearInterval(interval.current);
        interval.current = null;
    }

    useEffect(()=>{
        if(count==10) decrement();
        else if(count==0){
            reset();
        }
    },[count]);

    function reset(){
        updateCount(0);
        clearTimerInterval()
    }


    return (
        <>
            <h1>{count}</h1>

            <div>
                <button
                onClick={increment}
                >Increment</button>
                <br></br><br></br>
                <button
                onClick={decrement}
                >Decrement</button>
                <br></br><br></br>
                <button
                onClick={reset}
                >Reset</button>
            </div>
        </>
    )
}