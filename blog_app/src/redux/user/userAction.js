import { USER_LOGGED_IN, USER_LOGGED_OUT, USER_REGISTER } from "./userTypes";

export const registerUser = (user) => {
  return {
    type: USER_REGISTER,
    user
  };
};

export const setLoggedIn = (user) => {
  return {
    type: USER_LOGGED_IN,
    user
  };
};

export const setLoggedOut = () => {
  return {
    type: USER_LOGGED_OUT,
  };
};

