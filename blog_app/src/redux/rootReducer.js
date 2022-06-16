import { combineReducers } from "redux";
import userReducer from './user/userReducer';
import blogReducer from "./blog/blogReducer";
import tagReducer from "./tag/tagReducer";

const rootReducer = combineReducers({
    users: userReducer,
    blogs: blogReducer,
    tags: tagReducer,
});

export default rootReducer;
