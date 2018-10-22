package com.mobidic.datasource.repositories;

import com.mobidic.datasource.models.Supervisor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SupervisorRepository extends CrudRepository<Supervisor,Long>{

} 