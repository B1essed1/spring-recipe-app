package com.springrecipeapp.repositories;

import com.springrecipeapp.domains.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long>
{
}
