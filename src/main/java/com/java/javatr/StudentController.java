package com.java.javatr;


import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@EnableAsync
public class StudentController {
    List<Student> studentStream = Arrays.asList( "samet,ahmet,mahmut".split( "," ) ).stream()
                                        .map( name -> new Student( name, new Random().nextInt() ) ).collect( Collectors.toList() );

    @GetMapping("students")
    public Student getStudent( @RequestParam(required = true) String name ) throws StudentNotFoundException {

        return studentStream.stream().filter( Objects::nonNull )
                            .filter( e -> name.equalsIgnoreCase( e.getName() ) )
                            .findFirst().orElseThrow( () -> {
                    return new StudentNotFoundException( name );
                } );

    }
}
