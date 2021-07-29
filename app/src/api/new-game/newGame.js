import * as SockJs from "sockjs-client";

const startNewGame = function (sessionKey) {
    const socket = new SockJs("http://localhost:8080/gs-guide-websockets")
    console.log(socket);
}

export default startNewGame;