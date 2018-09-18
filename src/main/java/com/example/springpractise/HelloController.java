package com.example.springpractise;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api")
@RestController
public class HelloController {

    @GetMapping("/greeting")
    public ResponseEntity Greeting(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }

    @GetMapping("/map")
    public Map GetMap(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("key", "value");

        return hashMap;
    }

    @GetMapping("/list")
    public List GetList(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("list");

        return list;
    }
}
