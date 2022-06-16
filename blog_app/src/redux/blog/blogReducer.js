import {
  ADD_ALL_BLOGS,
  CREATE_BLOG,
  UPDATE_BLOG,
  DELETE_BLOG,
  FETCH_BLOG_BY_TAG_ID
} from "./blogTypes";


const initialState = {
  blogList: []
};

const blogReducer = (state = initialState, action) => {
  switch (action.type) {
    case ADD_ALL_BLOGS:
      return {
        ...state,
        blogList: action.blogList
      }
    case CREATE_BLOG:
      return {
        ...state,
        blogList: state.blogs.concat(action.blog)
      }
    case UPDATE_BLOG:
      return {
        ...state,
        itemList: state.outlets.filter((ele) => {
          console.log(ele.username === action.username);
          return ele.username === action.username
        })
      };
    case DELETE_BLOG:
      return {
        ...state,
        blogList: state.blogList.filter((blog) => blog.id !== action.blogId)
      };
    case CREATE_BLOG:
      return {
        ...state,
        outlets: state.outlets.map((ele) => {
          if(ele.username === action.username) {
            ele.items.push(action.item)
          }
          return ele;
        })
      };
    case CREATE_BLOG:
      return {
        ...state,
      };

    default:
      return state;
  }
};
export default blogReducer;
