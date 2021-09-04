package by.teachmeskills.model;

import java.util.Objects;

public class User {

    private int id;
    private String login;
    private String password;
    private String FirstName;
    private String LastName;
    private int age;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(FirstName, user.FirstName) && Objects.equals(LastName, user.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, FirstName, LastName, age);
    }
}
