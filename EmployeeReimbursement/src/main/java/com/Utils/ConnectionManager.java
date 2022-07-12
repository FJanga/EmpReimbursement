package com.Utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {

//    this is a singleton - meaning when we call this instance
//     always referring to the same instance of this connectionManager class
    public static ConnectionManager connectionManager;

// this is my connection instance
    public static Connection connection;

//    this is a private constructor
    private ConnectionManager(){

    }

    private ConnectionManager getConnectionManager() {

        if(connectionManager == null){
            connectionManager = new ConnectionManager();

        }
        return connectionManager;

    }


    public static Connection getConnection(){
        if(connection == null){
            connection = connect();
        }

        return connection;
    }

    private static Connection connect(){

        try {
//            this creates a new property with no value
            Properties props = new Properties();

// using a file reader and it takes a property file
            FileReader fileReader = new FileReader("/Users/fatma/Documents/EmpReimbursement/EmployeeReimbursement/src/main/resources/jdbc.properties");
//            +"/src/main/resources/jdbc.properties
//            by loading the contents of the file into the properties,
//            it enables us to access the value at the keys that have been set in
//            the properies list.

            props.load(fileReader);

//            the database url = an address pointing to the database to be used

            StringBuilder sb = new StringBuilder();
            sb.append("jdbc:postgresql://");
            sb.append(props.get("hostname"));
            sb.append(":");
            sb.append(props.get("port"));
            sb.append("/");
            sb.append(props.get("database"));

//            have to call the string method on the sb inorder for us to use the string we have created
//          assign
            String connectionURL = sb.toString();

            String user = String.valueOf(props.get("user"));
            String password = String.valueOf(props.get("password"));
            Class.forName("org.postgresql.Driver");




            connection = DriverManager.getConnection(connectionURL,user,password);

            System.out.println(connectionURL.toString());
            System.out.println(connection.toString());





        }catch(Exception e){
            System.out.println(e.getMessage());

        }






        return connection;

    }

}
