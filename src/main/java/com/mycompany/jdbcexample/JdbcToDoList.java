/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbcexample;

import java.sql.DriverManager;

/**
 *
 * @author gavan
 */
public class JdbcToDoList {

    /*
    1. To use jdbc, must connect to database
    2. To connect, have to
        - go driver manager
        - ask for to connection
        - provide jdbc url when asking for connection
     */
 /* Should use try-catch on 'var connection' (good solution) or use throws (worse solution)
    - As a quick fix, we just use throws exception
     */
    public static void main(String[] args) throws Exception {
// Get the connection to the database from DriverManager
        var connection = DriverManager.getConnection("jdbc:h2:./todo;AUTO_SERVER=TRUE");

        /* We can run the h2 console to see what is going on
        1. Runtime Deps>org.h2.tools>Console.class
        2. Run the above as java application
        3. To run Console.class in netbeans must run in terminal:
            - java -cp "C:\Users\gavan\.m2\repository\com\h2database\h2\2.3.232\h2-2.3.232.jar" org.h2.tools.Console
            - leave terminal running!
            - browser opens
            - put "jdbc:h2:./todo;AUTO_SERVER=TRUE" into jdbc url field, clear pw and user and connect!
         */
    }
    // current position: https://youtu.be/03rDqI6lxdI?t=950

}
