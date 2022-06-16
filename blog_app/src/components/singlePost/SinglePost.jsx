import { Link } from "react-router-dom";
import { deleteBlog } from "../../redux/blog/blogAction";
import "./singlePost.css";

export default function SinglePost({ blog, user }) {

  const deleteBlogApi = async() => {
    console.log("delete");
    let data = await fetch(`http://localhost:8080/blogs/delete/${blog.id}`, 
                          {method: 'DELETE'});
    console.log(data);
    deleteBlog(blog.id);
    window.location.href = "http://localhost:3000/";
    alert("Blog has been deleted successfully !");
  }

  return (
    <div className="singlePost">
      <div className="singlePostWrapper">
        <img
          className="singlePostImg"
          src="https://images.pexels.com/photos/6685428/pexels-photo-6685428.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
          alt=""
        />
        <div className="postCats">
          { blog['tags'].map(tag => 
              <span className="postCat">
                <Link className="link" to={{
                  pathname: `/category/${ tag.id }`, 
                }} >
                { tag.tagName }
              </Link>
            </span>
            ) 
          }
        </div>
        <h1 className="singlePostTitle">
          { blog['title'] }
          <div className="singlePostEdit">
            <i className="singlePostIcon far fa-edit"></i>
            <i onClick={ deleteBlogApi } className="singlePostIcon far fa-trash-alt"></i>
          </div>
        </h1>
        <div className="singlePostInfo">
          <span>
            Author:
            <b className="singlePostAuthor">
              <Link className="link" to={{
                    pathname: `/user/${user['id']}`, 
                  }} >
                { user['name'] }
              </Link>
            </b>
          </span>
          <span>{ blog['postedAt'] }</span>
        </div>
        <p className="singlePostDesc">
          { blog['description'] }
        </p>
      </div>
    </div>
  );
}
