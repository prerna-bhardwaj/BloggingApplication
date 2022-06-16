import Header from "../../components/header/Header";
import Posts from "../../components/posts/Posts";
import Sidebar from "../../components/sidebar/Sidebar";
import "./homepage.css";
import { useSelector } from "react-redux";

export default function Homepage() {
  const blogs = useSelector(state => state.blogs.blogList);

  return (
    <>
      <Header />
      <div className="home">
        <Posts blogs={ blogs }/>
        <Sidebar />
      </div>
    </>
  );
}
