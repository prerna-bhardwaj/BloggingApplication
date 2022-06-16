import { USER_LOGGED_IN, USER_LOGGED_OUT, USER_REGISTER } from "./userTypes";

const initialState = {
  isAuthenticated: false,
  user: {}
};

const userReducer = (state = initialState, action) => {
  switch (action.type) {
    case USER_REGISTER:
      console.log("action", action)
      return {
        ...state,
        user: action.user,
        isAuthenticated: true,
      };

    case USER_LOGGED_IN:
      return {
        ...state,
        user: action.user,
        isAuthenticated: true,
      };

    case USER_LOGGED_OUT:
      return {
        ...state,
        isAuthenticated: false,
        user: {}
      };

    default:
      return state;
  }
};

export default userReducer;
