import connectToWebsocket from "../stomp/webSocketConnection";
import { useState } from "react"
import axios from "axios";

let stompClient;

const startNewGame = function () {
    stompClient = connectToWebsocket();
    stompClient.onConnect = (frame) => {
        axios.get("http://localhost:8080/game/new")
            .then((response) => {
                let gameId = response.data.gameId;
                stompClient.subscribe(`/topic/game/${gameId}`, handleCallback);
            })
    }
    console.log(stompClient);
}

const handleCallback = function (message) {
    console.log("received message");
    console.log(message);
    if (message.body) {
        console.log(message.body);
    }
}

export default startNewGame;