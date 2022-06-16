import Posts from "../../components/posts/Posts";
import Sidebar from "../../components/sidebar/Sidebar";
import "./category.css";
import { useSelector } from "react-redux";
import { useEffect } from "react";
import { useDispatch } from "react-redux";
import { useState } from "react";
import { useLocation } from "react-router";

export default function Category() {

  const [blogList, setBlogList] = useState([]);
  const pathname = useLocation().pathname;
  const id = pathname.split('/')[2]

  const fetchBlogsByTagId = async() => {
    let data = await (await fetch(`http://localhost:8080/blogs/search/${id}`, {method: 'GET'})).json();
    setBlogList(data)
    console.log(blogList);
  }

  useEffect(() => {
    console.log("UseEffect", id);
    fetchBlogsByTagId();
  }, []);

  return (
    <>
      <div className="home">
        <Posts blogs={ blogList } />
        <Sidebar />
      </div>
    </>
  );
}
