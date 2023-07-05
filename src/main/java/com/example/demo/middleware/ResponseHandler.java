package com.example.demo.middleware;

import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(
            String message,
            HttpStatus status,
            Object responseObj
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, status);
    }
}
