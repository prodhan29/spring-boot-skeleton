package com.nahid.simpleboot.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class Question {

    @GetMapping("/info")
    public ResponseEntity<List> getTest() throws Exception {
        List<String> names = Arrays.asList("nahid", "hasan");
        return ResponseEntity.ok(names);
    }

    @GetMapping("/about")
    public ResponseEntity<List> getAbout(){
        List<String> names = Arrays.asList("simple", "spring boot");
        return new ResponseEntity<>(names, HttpStatus.OK);
    }
}
