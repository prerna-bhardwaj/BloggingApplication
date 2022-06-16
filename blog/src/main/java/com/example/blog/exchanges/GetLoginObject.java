package com.example.blog.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetLoginObject {
    
    @NonNull
    private String username;
    @NonNull
    private String password;
    
    public GetLoginObject() {}

    public GetLoginObject(String username, String password) {
        this.username = username;
        this.password = password;
    }   

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
