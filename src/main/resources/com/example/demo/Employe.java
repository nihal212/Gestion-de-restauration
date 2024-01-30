package com.example.demo;

public class Employe {
    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private String address;
    private String dateofbirth;
    private String phone;
    private String email;
    private String photo;
    private String password;

//    setters
    public void setId(int id){
        this.id=id;
    }

    public void setFirstName(String firstname){
        this.firstname=firstname;
    }
    public void setlastname(String lastname){
        this.lastname=lastname;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setDateofbirth(String dateofbirth){
        this.dateofbirth=dateofbirth;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhoto(String photo){
        this.photo=photo;
    }
    public void setPassword(String password){
        this.password=password;
    }
//    getters
    public int getId(){
        return id;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastName(){
        return lastname;
    }
    public String getGender(){
        return gender;
    }
    public String getAddress(){
        return address;
    }
    public String getDateofbirth(){
        return dateofbirth;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoto(){
        return photo;
    }
    public String getPassword(){
        return password;
    }

}
