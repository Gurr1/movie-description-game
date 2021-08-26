import styled from "@emotion/styled";
import { Card, CardTitle } from "../../common/styling";
import AppButtonLink from "../../common/app-button-link";
import { startNewGame } from "../../api/gameCommunication/websocketGameSetup";

const Info = styled(Card)`
  display: grid;
  grid-auto-rows: min-content;
  grid-template-columns: 1fr;
  grid-gap: 2rem;
  justify-items: center;
`;

const Home = () => {
  return (
    <Info>
      <CardTitle>Play play play</CardTitle>
      <AppButtonLink link={"play"} onClick={startNewGame} >Start a game</AppButtonLink>
    </Info>
  );
};

export default Home;
