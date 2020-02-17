package com.java.javatr;


public class StudentNotFoundException extends Exception {

    public final String message = "student not found";
    public String studentname;

    StudentNotFoundException( String studentname ) {
        this.studentname = studentname;

    }

}
