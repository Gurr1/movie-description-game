import createStompClient from "./websocketStompConfig";

let client;

const getWebSocketConnection = function () {
    return client;
}

const connectToWebsocket = function () {
    client = createStompClient();
    client.onStompError = function (frame) {
        console.log("failed to connect to stomp server");
    }
    client.activate();

    return client;
}

export {connectToWebsocket, getWebSocketConnection};
