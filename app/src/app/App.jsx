import React from "react";
import styled from "@emotion/styled";
import Guess from "../use-case/guess";
import { Switch, Route } from "react-router-dom";
import Home from "../use-case/home";

const Header = styled.header`
  padding: 2rem;
`;

const Heading = styled.h1`
  font-family: "Bebas Neue", cursive;
  color: #05c46b;
  font-size: 5rem;
  text-align: center;
`;

const Layout = styled.div``;

const App = () => {
  return (
    <Layout>
      <Header>
        <Heading>Movie Description Game</Heading>
      </Header>
      <main>
        <Switch>
          <Route path="/play" component={Guess}/>
          <Route exact component={Home} />
        </Switch>
      </main>
    </Layout>
  );
};

export default App;
