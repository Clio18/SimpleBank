package entity;

public class Client {
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String type;
    private int id;
    public final static String ADMIN = "admin";
    public final static String USER = "user";

    public Client(String name, String lastName, String login, String password, String type, int id) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.type = type;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client: " +
                "name is " + name + '\'' +
                ", last name is " + lastName + '\'' +
                ", login - " + login + '\'' +
                ", password - " + password + '\'' +
                ", type: " + type + '\''  +
                ", id: " + id + '\'';
    }
}
