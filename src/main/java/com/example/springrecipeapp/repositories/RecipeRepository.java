package com.example.springrecipeapp.repositories;

import com.example.springrecipeapp.domains.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long>
{
}
