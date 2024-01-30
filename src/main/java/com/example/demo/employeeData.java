package com.example.demo;
import java.sql.Date;


public class employeeData {

    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNum;
    private String address;

    private String email;
    private String image;
    private String date;
    private Double salary;

    public employeeData(Integer employeeId, String firstName, String lastName, String gender, String phoneNum, String  address,String email, String image, String date){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.address = address;
        this.email= email;
        this.image = image;
        this.date = date;
    }
    public employeeData(Integer employeeId, String firstName, String lastName,String phoneNum, Double salary){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.salary = salary;
    }

    public Integer getEmployeeId(){
        return employeeId;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getGender(){
        return gender;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }
    public String getImage(){
        return image;
    }
    public String getDate(){
        return date;
    }
    public Double getSalary(){
        return salary;
    }


}
