package com.example.secondspringproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Student {
    @GeneratedValue
    @Id
    private int id;

    private String username;
    private String fullname;
    private String pwd;



}
