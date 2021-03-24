package com.example.springrecipeapp.repositories;

import com.example.springrecipeapp.domains.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe,Long>
{
    Optional<Recipe> findByDescription(String description);
}
