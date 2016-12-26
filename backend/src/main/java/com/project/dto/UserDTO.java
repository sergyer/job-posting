package com.project.dto;

import javax.annotation.PostConstruct;
import java.time.*;
import java.util.Date;

/**
 * Created by sergeyy on 12/14/16.
 */


public class UserDTO {

    private Long id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Integer status;
    private Integer role;
    private Date registeredDate;
    private String address;
    private String displayName;
    private String companyName;
    private String aboutYou;
    private Integer mobile;
    private byte[] image;

    private Date lastVisitedDate;

    /*for testing purposes*/
    private String lastVisit;

   /* @PostConstruct
    public void prepareLastVisit() {
        Instant instant = lastVisitedDate.toInstant();
        ZonedDateTime zd = instant.atZone(ZoneId.systemDefault());

        LocalDate lastVisited = zd.toLocalDate();
        LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());

        Period period = Period.between(lastVisited, currentDate);

        String result=period.getDays()+"ago";

        if (period.getMonths() != 0 && period.getYears() != 0) {
            result = period.getDays() + "days " + period.getMonths() + "months " +
                    period.getYears() + "years ago";
        }
        this.lastVisit = result;
        System.out.println(this.lastVisit);
    }*/

    public Date getLastVisitedDate() {
        return lastVisitedDate;
    }

    public void setLastVisitedDate(Date lastVisitedDate) {
        this.lastVisitedDate = lastVisitedDate;
    }



    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
