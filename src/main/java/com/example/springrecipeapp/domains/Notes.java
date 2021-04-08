package com.example.springrecipeapp.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne()
    Recipe recipe;

    @Lob
    String recipeNotes;
}
