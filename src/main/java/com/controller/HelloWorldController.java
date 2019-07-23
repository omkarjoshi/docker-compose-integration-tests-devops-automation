package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWorldDAOImpl helloWorldDAO;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(String personId){
        return new ResponseEntity<Person>(new Person("Omkar","Dahisar",1), HttpStatus.OK);
    }

    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(String personId){

        HelloWorldController.Person person = new Person("Omkar","Dahisar",1);

        helloWorldDAO.addPerson(person);

        return new ResponseEntity<Person>(HttpStatus.OK);
    }


    public static class Person{
        private String name;
        private String address;
        private int age;

        public Person(){

        }

        public Person(String name, String address, int age) {
            this.name = name;
            this.address = address;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
