import { Link } from "react-router-dom";
import "./post.css";

export default function Post({id, title, tags, date, description}) {

  return (
    <div className="post">
      <img
        className="postImg"
        src="https://images.pexels.com/photos/6685428/pexels-photo-6685428.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
        alt=""
      />
      <div className="postInfo">
        <div className="postCats">
          { tags.map(tag => 
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
        <span className="postTitle">
            <Link className="link" to={{
                  pathname: `/post/${ id }`, 
                }} >
                  { title }
            </Link>
        </span>
        <hr />
        <span className="postDate">{ date }</span>
      </div>
      <p className="postDesc">
        { description }
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda
        officia architecto deserunt deleniti? Labore ipsum aspernatur magnam
        fugiat, reprehenderit praesentium blanditiis quos cupiditate ratione
        atque, exercitationem quibusdam, reiciendis odio laboriosam?
      </p>
    </div>
  );
}
