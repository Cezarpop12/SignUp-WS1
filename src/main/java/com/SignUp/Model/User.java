package com.SignUp.Model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userinfo")
public class User {
    @Id
    private String userID;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 10, message = "Name must be between 3 and 10 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Name can only contain alphanumeric characters and underscores")
    private String name;
    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 10, message = "Username must be between 3 and 10 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contain alphanumeric characters and underscores")
    private String username;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 3, max = 10, message = "Password must be between 3 and 10 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Password can only contain alphanumeric characters and underscores")
    private String password;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    public User() {
        // Default constructor
    }

    public User(String UserID, String Name, String Username, String Password, String Email) {
        this.userID = UserID;
        this.name = Name;
        this.username = Username;
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
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
