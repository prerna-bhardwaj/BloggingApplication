import {
  ADD_ALL_BLOGS,
  CREATE_BLOG,
  UPDATE_BLOG,
  DELETE_BLOG,
  FETCH_BLOG_BY_TAG_ID
} from "./blogTypes";

export const addAllBlogs = (blogList) => {
  return {
    type: ADD_ALL_BLOGS,
    blogList
  }
}

export const createBlog = (blog) => {
  return {
    type: CREATE_BLOG,
    blog,
  };
};

export const updateBlog = (blog) => {
  return {
    type: UPDATE_BLOG,
    blog
  };
};

export const deleteBlog = (blogId) => {
  return {
    type: DELETE_BLOG,
    blogId
  };
};

export const fetchBlogByTag = (tagId) => {
  return {
    type: FETCH_BLOG_BY_TAG_ID,
    tagId
  };
};

export const fetchBlogList = async(dispatch) => {
  let data = await (await fetch("http://localhost:8080/blogs/fetch", {method: 'GET'})).json();
  dispatch(addAllBlogs(data));
}
