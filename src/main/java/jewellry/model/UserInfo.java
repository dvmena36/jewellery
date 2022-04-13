package jewellry.model;

import javax.persistence.*;

@Entity
public class UserInfo {

    @Id
    @Column(name = "id")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String address;

    private String city;

    private String country;

    private String phoneNumber;

    public UserInfo(){}

    public UserInfo(User user, String address, String city, String country, String phoneNumber) {
        this.user = user;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
