import * as StompJs from "@stomp/stompjs"

const createStompClient = function() {
    const backendUrl = process.env.REACT_APP_BACKEND_IP;
    return new StompJs.Client({
        brokerURL: `ws://${backendUrl}/gs-guide-websockets`
    });
}

export default createStompClient;