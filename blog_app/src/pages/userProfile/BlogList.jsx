import Posts from "../../components/posts/Posts";
import Sidebar from "../../components/sidebar/Sidebar";
import "./blogList.css";
import { useSelector } from "react-redux";

export default function BlogList() {

  const blogList = useSelector(state => state.users.user.blogs)  

  return (
    <>
      <div className="home">
        <Posts blogs={ blogList } />
        <Sidebar />
      </div>
    </>
  );
}
