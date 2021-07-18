package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document
public class user {
    // Imp
    @Id
    private String id;
    private String name;
    private String email;
    private String title;
    private String team;
    private List<String> technologies;
    private List<Map<String, String>> exp;

    public user(String name,
                String email,
                String title,
                String team,
                List<Map<String, String>> exp,
                List<String> technologies) {

        this.name = name;
        this.title = title;
        this.email = email;
        this.team = team;
        this.technologies = technologies;
        this.exp = exp;
    }
}
