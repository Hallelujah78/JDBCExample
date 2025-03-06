/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbcexample;

/**
 *
 * @author gavan
 */
public class Task {

    int id;
    String name;

    public Task() {
    }

    public Task(String name) {
        super();
        this.name = name;
    }

    public Task(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

}
