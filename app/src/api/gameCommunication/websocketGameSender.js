import { getWebSocketConnection } from "../stomp/webSocketConnection"

const requestNextMovie = function (gameId) {
    const path = "/app/next/";
    const socketConnection = getWebSocketConnection();
    socketConnection.publish({
        destination: path,
        body: JSON.stringify({
            gameId: gameId
        }),
        skipContentLengthHeader: true
    })
}
export default requestNextMovie