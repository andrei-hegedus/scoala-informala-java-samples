package ro.siit.java;

/**
 * Created by andrei on 9/4/17.
 */
public class Client {

    private String name;
    private String address;
    private String userId;


    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    void setUserId(String userId) {
        this.userId = userId;
    }
}
