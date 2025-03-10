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
        - issue with url: https://chatgpt.com/c/67c8d33c-6fe8-8006-993f-a48a310c6f1c
     */
 /* Should use try-catch on 'var connection' (good solution) or use throws (worse solution)
    - As a quick fix, we just use throws exception
     */
    public static void main(String[] args) throws Exception {
// Get the connection to the database from DriverManager
        var connection = DriverManager.getConnection("jdbc:h2:~/todo;AUTO_SERVER=TRUE");

        // set autocommit to true - troubleshooting issue with table not showing
        connection.setAutoCommit(true);

        /* We can run the h2 console to see what is going on
        1. Runtime Deps>org.h2.tools>Console.class
        2. Run the above as java application
        3. To run Console.class in netbeans must run in terminal:
            - java -cp "C:\Users\gavan\.m2\repository\com\h2database\h2\2.3.232\h2-2.3.232.jar" org.h2.tools.Console
            - leave terminal running!
            - browser opens
            - put "jdbc:h2:~/todo;AUTO_SERVER=TRUE" into jdbc url field, clear pw and user and connect!
         */
        // Create a table with sql string
        var createTableSql = "CREATE TABLE IF NOT EXISTS TASK (id IDENTITY PRIMARY KEY, name VARCHAR)";
        /*
        Insert string for task, ID is auto created since it is the primary key
        - We generally don't want to hard code queries like this.
        - We would use a PreparedStatement (interface)
         */
        String insertQuery = "insert into TASK (name) values ('Learn Java')";

        /*
        How do we create the table?
        1. We use the connection object (represents our conn to dbs)
        2. Get statement object from connection object
            - used to execute statements
         */
        // Get statement object from connection's createStatement() method
        var statement = connection.createStatement();

        // Execute our createTableSql using statement's execute method
        statement.execute(createTableSql);

        // Execute query to insert task
        statement.execute(insertQuery);

        /**
         * *************** PREPARED STATEMENT *******************
         */
        // PreparedStatement example - note the ?
        String insertStatement = "insert into TASK (name) values(?)";
        // prepareStatement returns a prepared statement!
        var preparedStatement = connection.prepareStatement(insertStatement);

        // Set the value of the first ? in the insert statement
        preparedStatement.setString(1, "Learn Spring!");

        // Execute the statement
        preparedStatement.execute();

        /**
         * *************** END OF PREPARED STATEMENT *******************
         */
        /**
         * *************** UPDATE *******************
         */
        // Update query - update TASK where name is Learn Java
        String updateCommand = "update TASK set name = ? where name = 'Learn Java'";

        // prep statement
        var ps = connection.prepareStatement(updateCommand);

        // set the value in the prep statement
        ps.setString(1, "Learn Jakarta EE!");
        // execute the prep statement
        ps.execute();

        /**
         * *************** END UPDATE *******************
         */
        /**
         * *************** DELETE *******************
         */
        String deleteQuery = "delete from TASK where name = 'Learn Jakarta EE!'";

//        statement.execute(deleteQuery); // commented out to avoid too many deletes
        /**
         * *************** END DELETE *******************
         */
        /**
         * *************** FIND - SELECT *******************
         */
        String selectAllQuery = "select * from TASK";
        // We get the entire table.
        var resultSet = statement.executeQuery(selectAllQuery);
        // iterate over the result set
        while (resultSet.next()) {
            // getString("name") - get the "name" column
            System.out.println("To Do Item: " + resultSet.getString("name"));
        }

        /**
         * *************** END FIND - SELECT *******************
         */
        // Close statement and connection to remove issues with console not updating
        statement.close();
        connection.close();
        // print statement to show we ran the right file!
        System.out.println("Running jdbctodolist.java");

    }
    // current position: https://youtu.be/03rDqI6lxdI?t=950

}
