/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbcexample;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


/*
    - should NOT be creating a connection everytime we want to query a database
    - Takes resources to create and maintain a connection.
    - Typically, we create a pool of connections.
        - Take a connection from the pool and give it back to the pool when done
        - called Connection Pooling
        - almost all frameworks use HikariCP for connection pooling
            - add to pom from mvnrepo
            - running the project ensures pom stuff is pulled down from repos
 */
/**
 * This is a class that manages our database connections and has methods to
 * perform CRUD operations.
 *
 * @author gavan
 */
public class TaskRepository {

    /**
     * Create and return a data source with the URL of our database.
     *
     * @return a HikariDataSource instance.
     */
    private static DataSource getDataSource() {
        // Create a data source
        HikariDataSource dataSource = new HikariDataSource();

        // Set the database url
        dataSource.setJdbcUrl("jdbc:h2:~/todo;AUTO_SERVER=TRUE");
        // Return the data source.
        return dataSource;
    }

    /**
     * Uses a Task instance to create
     *
     * @param task a Task instance.
     * @throws SQLException
     */
    public static void create(Task task) throws SQLException { // allows exception to bubble up to caller
        /* The try here closes the connection regardless of whether there is an
        exception or not.
         */
        try (Connection connection = getDataSource().getConnection()) {

        }
    }

    /**
     * Uses a Task instance to create
     *
     * @param task a Task instance.
     * @return
     * @throws SQLException
     */
    public static List<Task> findAll(Task task) throws SQLException { // allows exception to bubble up to caller

        List<Task> tasks = new ArrayList();
        try (Connection connection = getDataSource().getConnection()) {

        }
        return tasks;
    }

    /**
     * Uses a Task instance to create
     *
     * @param task a Task instance.
     * @throws SQLException
     */
    public static void update(Task task) throws SQLException { // allows exception to bubble up to caller
        /* The try here closes the connection regardless of whether there is an
        exception or not.
         */
        try (Connection connection = getDataSource().getConnection()) {

        }
    }

    /**
     * Uses a Task instance to create
     *
     * @param task a Task instance.
     * @throws SQLException
     */
    public static void deleteAll(Task task) throws SQLException { // allows exception to bubble up to caller
        /* The try here closes the connection regardless of whether there is an
        exception or not.
         */
        try (Connection connection = getDataSource().getConnection()) {

        }
    }

    // For testing purposes.
    public static void main(String[] args) {

    }

}
