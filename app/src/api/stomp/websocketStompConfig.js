import * as StompJs from "@stomp/stompjs"

const createStompClient = function() {
    return new StompJs.Client({
        brokerURL: "ws://localhost:8080/gs-guide-websockets"
    });
}

export default createStompClient;