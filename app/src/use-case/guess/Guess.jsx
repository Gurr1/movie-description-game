import React, { useState } from "react";
import styled from "@emotion/styled";
import MovieAutocomplete from "./movie-autocomplete";
import AppButton from "../../common/app-button";
import Divider from "@material-ui/core/Divider";
import { Card, CardTitle } from "../../common/styling";

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

const Guess = () => {
  const [movieSelected, setMovieSelected] = useState(null);

  return (
    <Movie>
      <CardTitle>What's the movie?</CardTitle>
      <MovieDescription>
        Eight years after the Joker's reign of anarchy, Batman, with the help of
        the enigmatic Catwoman, is forced from his exile to save Gotham City
        from the brutal guerrilla terrorist Bane.
      </MovieDescription>
      <Divider />
      <MovieAutocomplete
        movie={movieSelected}
        onMovieChanged={(movie) => setMovieSelected(movie)}
      />
      <AppButton disabled={movieSelected == null}>
        {movieSelected == null
          ? "Select movie to answer"
          : "Answer " + movieSelected.name}
      </AppButton>
    </Movie>
  );
};

export default Guess;
