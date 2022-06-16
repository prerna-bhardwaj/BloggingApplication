import {
  FETCH_ALL_TAGS,
  ADD_ALL_TAGS
} from "./tagTypes";

import { useSelector } from "react-redux";

export const addAllTags = (data) =>{
  return {
    type: ADD_ALL_TAGS,
    data
  }
}


export const fetchAllTags = () => {
  return {
    type: FETCH_ALL_TAGS,
  };
};

export const fetchTagsList = async(dispatch) => {
  let data = await (await fetch("http://localhost:8080/tags/fetchAll", {method: 'GET'})).json();
  dispatch(addAllTags(data));
}
