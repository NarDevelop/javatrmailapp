package com.java.javatr;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class StudentError {
    private String message;
    private Date date;
    private String studentname;
}


