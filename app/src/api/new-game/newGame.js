import connectToWebsocket from "../stomp/webSocketConnection";

let stompClient;

const startNewGame = function (sessionKey) {
    stompClient = connectToWebsocket();
    stompClient.onConnect = (frame) => {
        stompClient.subscribe("/topic/game", handleCallback);
        stompClient.publish({
           destination: "/app/next_description",
            body: "hej",
            skipContentLengthHeader: true
        });
    }
    console.log(stompClient);
}

const handleCallback = function (message) {
    console.log("received message");
    console.log(message)
    if (message.body) {
        console.log(message.body);
    }
}

export default startNewGame;