import "./login.css";
import { useState } from "react"
import { useDispatch, useSelector } from "react-redux";
import { setLoggedIn } from "../../redux/user/userAction";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const dispatch = useDispatch();

  const loginUserApi = async(event) => {
    event.preventDefault();
    let data = await fetch(`http://localhost:8080/users/login/${username}/${password}`, {
                                  method: 'GET',
                                  headers: {'Content-Type': 'application/json', 
                                              'charset': 'utf-8',
                                              'Access-Control-Allow-Origin': '*',
                                              "Access-Control-Allow-Methods": "GET,POST,OPTIONS,DELETE",
                                              "Access-Control-Allow-Headers": "X-Requested-With, Access-Control-Allow-Headers, Content-Type, Authorization, Origin, Accept",
                                              'Access-Control-Allow-Credentials': true
                                            },
                                });
    console.log(data)
    let user = await (await fetch(`http://localhost:8080/users/${username}`, {method: 'GET'})).json();
    console.log(user)
    dispatch(setLoggedIn(user));
    alert("Congrats " + user.name + "! You have been logged in.")
  }

  return (
    <div className="login">
      <span className="loginTitle">Login</span>
      <form className="loginForm" onSubmit={ loginUserApi }>
        <label>Username</label>
        <input value={username} onChange={(e) => setUsername(e.target.value)} className="loginInput" type="text" placeholder="Enter your username..." />
        <label>Password</label>
        <input value={password} onChange={(e) => setPassword(e.target.value)} className="loginInput" type="password" placeholder="Enter your password..." />
        <button className="loginButton">Login</button>
      </form>
    </div>
  );
}
