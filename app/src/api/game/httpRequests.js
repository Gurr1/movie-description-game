import axios from "axios";

const requestNextMovie = function (gameId) {
    const baseUrl = process.env.REACT_APP_BACKEND_IP;
    const path = "/game/next/" + gameId;
    const base_url = url + path;
    axios.get(url)
        .then(response => {
            console.log(response);
        }).catch(err => {
            console.log(err);
    });
}

export default requestNextMovie;