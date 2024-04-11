package com.SignUp.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userinfo")
public class User {
    @Id
    private String userID;
    private String name;
    private String userName;
    private String password;
    private String email;

    public User() {
        // Default constructor
    }

    public User(String UserID, String Name, String UserName, String Password, String Email) {
        this.userID = UserID;
        this.name = Name;
        this.userName = UserName;
        this.password = Password;
        this.email = Email;
    }

    // Getter and setter methods for userID
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    // Getter and setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for username
    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    // Getter and setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
