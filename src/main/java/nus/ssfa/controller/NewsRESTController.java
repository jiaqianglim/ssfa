package nus.ssfa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/news")
public class NewsRESTController {
    
    @GetMapping(path={"id"}, produces="application/json")
    public ResponseEntity<String> getMethodName(@PathVariable String id) {
    }
    
}