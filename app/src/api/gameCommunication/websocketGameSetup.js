import { connectToWebsocket } from "../stomp/webSocketConnection";
import requestNextMovie from "./websocketGameSender"
import axios from "axios";

let stompClient;
let gameSubsribers = [];
let gameId = null;

const startNewGame = function () {
    stompClient = connectToWebsocket();
    stompClient.onConnect = (frame) => {
        axios.get("http://localhost:8080/game/new")
            .then((response) => {
                gameId = response.data.gameId;
                stompClient.subscribe(`/topic/game/${gameId}`, handleGameUpdate);
                console.log(stompClient);
                requestNextMovie(gameId);
            });
    }
}

const handleGameUpdate = function (message) {
    console.log("handling next movie");
    if (message.body != null) {
        gameSubsribers.forEach((sub) => {
            console.log(message);
            sub.updateFunction(message.body);
        });
    }
}

const subscribeToGameUpdates = function (updateFunction) {
    gameSubsribers.push({
        updateFunction: updateFunction,
    });
}

export {startNewGame, subscribeToGameUpdates, gameId};