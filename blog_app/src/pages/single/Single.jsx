import { useState } from "react";
import { useEffect } from "react";
import { useSelector } from "react-redux";
import { useLocation } from "react-router";
import Sidebar from "../../components/sidebar/Sidebar";
import SinglePost from "../../components/singlePost/SinglePost";
import "./single.css";

export default function Single() {
  const pathname = useLocation().pathname;
  const blogId = parseInt(pathname.split('/')[2])

  const blogs = useSelector(state => state.blogs.blogList)
  const blog = blogs.find(isValidBlog)
  const [user, setUser] = useState({})

  function isValidBlog(blog) {
    return blog.id === blogId;
  }

  const fetchAuthorById = async() => {
    let data = await (await fetch(`http://localhost:8080/blogs/author/${blog.id}`, {method: 'GET'})).json();
    console.log(data);
    setUser(data);
  }

  useEffect(() => {
    fetchAuthorById();
  }, []);

  return (
    <div className="single">
      <SinglePost blog={blog} user={user} />
      <Sidebar />
    </div>
  );
}
