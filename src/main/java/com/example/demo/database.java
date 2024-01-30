package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;


public class database {
    public static  Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection databaseLink = DriverManager.getConnection("jdbc:mysql://localhost/projetjava", "root", "");
            return databaseLink;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
//    public Connection databaseLink;
//    public Connection getConnection(){
//        String databaseName = "projetjava";
//        String databaseUser = "root";
//        String databasePassword = "";
//        String url = "jdbc:mysql://127.0.0.1/"+databaseName;

//        try{
//            // Load the MySQL JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//            // Establish the connection
//            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return databaseLink;
//    }
}
