import {
  ADD_ALL_TAGS,
  FETCH_ALL_TAGS
} from "./tagTypes";


const initialState = {
  tagList: [],
};

const tagReducer = (state = initialState, action) => {
  switch (action.type) {
    case ADD_ALL_TAGS:
      return {
        ...state,
        tagList: action.data
      }
    case FETCH_ALL_TAGS:
      return {
        ...state,
      };
    default:
      return state;
  }
};
export default tagReducer;
