package com.mobidic.datasource.repositories;

import com.mobidic.datasource.models.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category,Long>{

} 