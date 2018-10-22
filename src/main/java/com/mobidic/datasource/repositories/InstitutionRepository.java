package com.mobidic.datasource.repositories;

import com.mobidic.datasource.models.Institution;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InstitutionRepository extends CrudRepository<Institution,Long>{

} 