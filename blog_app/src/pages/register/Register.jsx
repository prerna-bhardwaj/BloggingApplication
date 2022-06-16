import { useState } from "react"
import "./register.css"
import { registerUser } from "../../redux/user/userAction";
import { useDispatch, useSelector } from "react-redux";

export default function Register() {

  const [name, setName] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const dispatch = useDispatch();

  const registerUserApi = async(event) => {
    event.preventDefault();
    let data = await fetch(`http://localhost:8080/users/register/${name}/${username}/${password}`, {
                                  method: 'POST',
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
    dispatch(registerUser(user));
    alert("Congrats " + name + "! You have been registered successfully !")
  }

  return (
    <div className="register">
      <span className="registerTitle">Register</span>
      <form className="registerForm" onSubmit={ registerUserApi }>
        <label>Name</label>
        <input value={name} onChange={(e) => setName(e.target.value)} className="registerInput" type="text" placeholder="Enter your name.." />
        <label>Username</label>
        <input value={username} onChange={(e) => setUsername(e.target.value)}  className="registerInput" type="text" placeholder="Enter your username.." />
        <label>Password</label>
        <input value={password} onChange={(e) => setPassword(e.target.value)} className="registerInput" type="password" placeholder="Enter your password.." />
        <button className="registerButton" >Register</button>
      </form>
    </div>
  )
}
