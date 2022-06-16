import { useState } from "react";
import "./write.css";

export default function Write() {

  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [body, setBody] = useState("");
  
  const createBlog = (event) => {
    event.preventDefault();
    blog = {"title": title, "description": description, "body": body}
  }

  return (
    <div className="write">
      <img
        className="writeImg"
        src="https://images.pexels.com/photos/6685428/pexels-photo-6685428.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
        alt=""
      />
      <form className="writeForm" onSubmit={ createBlog } >
        <div className="writeFormGroup">
          <label htmlFor="fileInput">
            <i className="writeIcon fas fa-plus"></i>
          </label>
          <input id="fileInput" type="file" style={{ display: "none" }} />
          <input
            className="writeInput"
            placeholder="Title"
            type="text"
            value={title}
            onChange={(e) => {setTitle(e.target.value)}}
            autoFocus={true}
          />
        </div>
        <div className="writeFormDescription">
          <textarea
            className="writeInput writeText"
            placeholder="Description"
            type="text"
            autoFocus={true}
            value={description}
            onChange={(e) => {setDescription(e.target.value)}}
          />
        </div>
        <div className="writeFormGroup">
          <textarea
            className="writeInput writeText"
            placeholder="Tell your story..."
            type="text"
            value={body}
            onChange={(e) => {setBody(e.target.value)}}
            autoFocus={true}
          />
        </div>
        <button className="writeSubmit" type="submit">
          Publish
        </button>
      </form>
    </div>
  );
}
