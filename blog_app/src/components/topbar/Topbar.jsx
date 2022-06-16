import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import "./topbar.css";
import { setLoggedOut } from "../../redux/user/userAction";

export default function Topbar() {
  const isAuthenticatedUser = useSelector(state => state.users.isAuthenticated);
  console.log(isAuthenticatedUser);
  const dispatch = useDispatch();
  const name = useSelector((state) => state.users.user.name)

  const logoutUser = () => {
    dispatch(setLoggedOut());
    alert("You have been logged out !")
  }

  return (
    <div className="top">
      <div className="topLeft">
        <span className="headerTitle">BLOGPOST</span>
      </div>
      <div className="topCenter">
        <ul className="topList">
          <li className="topListItem">
            <Link className="link" to="/">
              HOME
            </Link>
          </li>
          <li className="topListItem">ABOUT</li>
          <li className="topListItem">CONTACT</li>
          <li className="topListItem">
            <Link className="link" to="/write">
              WRITE
            </Link>
          </li>
          {isAuthenticatedUser && <li onClick={ logoutUser } className="topListItem">LOGOUT</li>}
        </ul>
      </div>
      <div className="topRight">
        {isAuthenticatedUser ? (
          <>
            <Link className="link" to="/profile">
              <img
                className="topImg"
                src="https://images.pexels.com/photos/1858175/pexels-photo-1858175.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                alt=""
              />
            </Link>  
            <span className="nameText">{ name }</span>
          </>
        ) : (
          <ul className="topList">
            <li className="topListItem">
              <Link className="link" to="/login">
                LOGIN
              </Link>
            </li>
            <li className="topListItem">
              <Link className="link" to="/register">
                REGISTER
              </Link>
            </li>
          </ul>
        )}
      </div>
    </div>
  );
}
