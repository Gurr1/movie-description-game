import React from "react";
import Button from "@material-ui/core/Button";

const AppButton = ({ disabled, onClick, children }) => {
  return (
    <Button
      disabled={disabled}
      variant={"outlined"}
      onClick={onClick}
      color="primary"
    >
      {children}
    </Button>
  );
};

export default AppButton;
