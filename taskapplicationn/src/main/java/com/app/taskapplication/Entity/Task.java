package com.app.taskapplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalTime;


@ToString
// constructor
@NoArgsConstructor
@AllArgsConstructor
// getter and setter
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;
    private String description;
    private LocalDate dateCreation;
    private LocalTime Hour;
    private  String state;
}
