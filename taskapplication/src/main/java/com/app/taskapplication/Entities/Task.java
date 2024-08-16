package com.app.taskapplication.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
// llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name =  "name", nullable = false)
    private String name;
    @Column(name="description")
    private String description;
    private LocalDate dateCreation;
    private LocalTime hour;
    private String status;




}
