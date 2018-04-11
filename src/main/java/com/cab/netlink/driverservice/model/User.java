package com.cab.netlink.driverservice.model;

import java.math.BigDecimal;

public class User {


    private Integer id;


    private String userName ;


    private String firstName ;

    private String lastName;


    private BigDecimal user_latitude ;

    private BigDecimal user_longitude ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getUser_latitude() {
        return user_latitude;
    }

    public void setUser_latitude(BigDecimal user_latitude) {
        this.user_latitude = user_latitude;
    }

    public BigDecimal getUser_longitude() {
        return user_longitude;
    }

    public void setUser_longitude(BigDecimal user_longitude) {
        this.user_longitude = user_longitude;
    }
}
