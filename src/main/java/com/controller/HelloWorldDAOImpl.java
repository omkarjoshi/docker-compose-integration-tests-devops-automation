package com.controller;

import com.controller.HelloWorldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class HelloWorldDAOImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void addPerson(HelloWorldController.Person person){

        jdbcTemplate.execute("INSERT INTO PERSON(id,name) VALUES ("+ new Random().nextInt() +",'" +person.getName()+"')");


    }


}
