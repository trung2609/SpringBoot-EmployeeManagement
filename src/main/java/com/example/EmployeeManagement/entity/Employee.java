package com.example.EmployeeManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    //@NotBlank(message = "first name is mandatory")
    private String firstName;
    @Column(name = "last_name")
    //@NotBlank(message = "last name is mandatory")
    private String lastName;
    @Column(name = "email_id")
    //@NotBlank(message = "email is mandatory")
     //@Email
    private String emailId;
    @Column(name = "password")
    //@Size(min = 8, max = 50)
    //@NotBlank(message = "password is mandatory")
    private String password;
    @Column(name = "address1")
    //@NotBlank(message = "address1 is mandatory")
    private String address1;
    @Column(name = "address2")
    //@NotBlank(message = "address2 is mandatory")
    private String address2;
    @Column(name = "province")
    //@NotBlank(message = "province is mandatory")
    private String province;
    @Column(name = "district")
    //@NotBlank(message = "district is mandatory")
    private String district;
    @Column(name = "ward")
   // @NotBlank(message = "ward is mandatory")
    private String ward;

    public Employee(){}

    public Employee(long id, String firstName, String lastName, String emailId, String password,
                    String address1, String address2,String province,String district,String ward) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.province = province;
        this.district = district;
        this.ward = ward;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}
