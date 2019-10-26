package trabalhocompmovel.data.user;

public class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private User user;

    public User(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
       return user.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
    }

    public User getUser() {
        return this.user;
    }
}
