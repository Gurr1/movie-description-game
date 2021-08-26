import axios from "axios";

const requestNextMovie = function (gameId) {
    const path = "/game/next/" + gameId;
    const url = "http://localhost:8080" + path;
    axios.get(url)
        .then(response => {
            console.log(response);
        }).catch(err => {
            console.log(err);
    });
}

export default requestNextMovie;