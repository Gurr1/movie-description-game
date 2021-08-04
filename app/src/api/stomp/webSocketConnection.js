import createStompClient from "./websocketStompConfig";

const connectToWebsocket = function () {
    const client = createStompClient();
    client.onStompError = function (frame) {
        console.log("failed to connect to stomp client");
    }
    client.activate();
    return client;
}

export default connectToWebsocket;
