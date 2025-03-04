/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jdbcexample;

/**
 *
 * @author gavan
 */
public class JDBCExample {

    /*
    1. Need a jdbc (database) driver - allows you to connect to a database using java
    2. Available through maven central - must have driver on class path
    3. Components to work with:
        - java program talks to
        - driver manager talks to
            - provided a jdbc url - text string
            - describes:
                - protocol (jdbc here)
                - name of database vendor/type (postgres, mysql, h2, db2)
                - name of the actual database/schema
            - driver manager returns a connection to the database
                - from here you can perform CRUD using the connection

        - jdbc driver talks to
        - database
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
