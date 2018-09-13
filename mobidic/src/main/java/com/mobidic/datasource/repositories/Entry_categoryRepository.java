package com.mobidic.datasource.repositories;

import com.mobidic.datasource.models.Entry_category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Entry_categoryRepository extends CrudRepository<Entry_category,Long>{

} 