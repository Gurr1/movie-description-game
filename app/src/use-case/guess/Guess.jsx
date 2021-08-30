import React, { useState } from "react";
import styled from "@emotion/styled";
import MovieAutocomplete from "./movie-autocomplete";
import AppButton from "../../common/app-button";
import Divider from "@material-ui/core/Divider";
import { Card, CardTitle } from "../../common/styling";
import { subscribeToGameUpdates } from "../../api/gameCommunication/websocketGameSetup";

const Movie = styled(Card)`
  display: grid;
  grid-auto-rows: min-content;
  grid-template-columns: 1fr;
  justify-items: auto;
  grid-gap: 2rem;
`;

const MovieDescription = styled.p`
  font-family: "Roboto", sans-serif;
  font-size: 2rem;
  color: white;
  border-left: 10px solid white;
  padding-left: 1.5rem;
`;

class Guess extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            movieDescription: "Placeholder description"
        };
    }

    componentDidMount() {
        subscribeToGameUpdates(this.updateOnGameChange);
    }

    updateOnGameChange = (response) => {
        const responseObject = JSON.parse(response)
        this.setState({
            movieDescription: responseObject.description
        });
    }

    render() {
        return (
            <Movie>
                <CardTitle>What's the movie?</CardTitle>
                <MovieDescription>
                    {this.state.movieDescription}
                </MovieDescription>
                <Divider/>
                <MovieAutocomplete
                />
                <AppButton>
                    {"Select movie to answer"}
                </AppButton>
            </Movie>
        );
    }
};

export default Guess;
