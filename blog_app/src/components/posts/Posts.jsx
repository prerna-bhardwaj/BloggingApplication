import { useDispatch, useSelector } from "react-redux";
import Post from "../post/Post";
import "./posts.css";

export default function Posts({blogs}) {
  return (
    <div className="posts">
      {
        blogs.map(blog => <Post  id={blog.id} title={blog.title} tags={blog.tags} 
                                date={blog.date} description={blog.description} />)
      }      
    </div>
  );
}
