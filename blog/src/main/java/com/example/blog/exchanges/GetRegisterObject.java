package com.example.blog.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRegisterObject {

    @NonNull
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String password;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public GetRegisterObject() {}

    public GetRegisterObject(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

}
