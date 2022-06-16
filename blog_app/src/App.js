import Topbar from "./components/topbar/Topbar";
import Homepage from "./pages/homepage/Homepage";
import Login from "./pages/login/Login";
import Register from "./pages/register/Register";
import Single from "./pages/single/Single";
import Write from "./pages/write/Write";
import Category from "./pages/category/Category";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { useEffect } from "react";
import { Provider, useDispatch, useSelector } from "react-redux";
import { fetchBlogList } from "./redux/blog/blogAction";
import { fetchTagsList } from "./redux/tag/tagAction";
import store from "./redux/store";
import BlogList from "./pages/userProfile/BlogList";


const AppWrapper = () => {
  return (
    <Provider store={store}> 
      <App /> 
    </Provider>
  )
}

function App() {
  const dispatch = useDispatch();

  useEffect(() => {
    fetchBlogList(dispatch);
    fetchTagsList(dispatch);
  });

  const currentUser = useSelector(state => state.users.isAuthenticated);
  console.log(currentUser);
  return (
      <Router>
        <Topbar />
        <Routes>
          <Route exact path="/" element={<Homepage/>} />
          <Route path="/posts" element={<Homepage/>} />
          <Route path="/register" element={currentUser ? <Homepage /> : <Register />} />
          <Route path="/login" element={currentUser ? <Homepage /> : <Login />} />
          <Route path="/post/:id" element={<Single/>} />
          <Route path="/category/:id" element={<Category />} />
          <Route path="/write" element={currentUser ? <Write /> : <Login />} />
          <Route path="/profile" element={currentUser ? <BlogList /> : <Login />} />
        </Routes>
      </Router>
  );
}

export default AppWrapper;