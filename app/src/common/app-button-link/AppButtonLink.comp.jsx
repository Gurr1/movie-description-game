import styled from "@emotion/styled";
import AppButton from "../app-button";
import { Link } from "react-router-dom";

const NonStyledLink = styled(Link)`
  text-decoration: none;
`;

const AppButtonLink = ({ link, children, onClick }) => {
  return (
    <NonStyledLink to={link}>
      <AppButton onClick={onClick}>{children}</AppButton>
    </NonStyledLink>
  );
};

export default AppButtonLink;
