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

const guessMovie = function (movieName) {
    const path = "/app/guess/";
    const socketConnection = getWebSocketConnection();
    socketConnection.publish({
        destination: path,
        body: JSON.stringify({
            movieName: movieName
        }),
        skipContentLengthHeader: true
        });
}
export default requestNextMovie