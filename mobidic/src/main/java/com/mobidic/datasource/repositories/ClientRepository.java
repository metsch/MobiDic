package com.mobidic.datasource.repositories;

import com.mobidic.datasource.models.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends CrudRepository<Client,Long>{

} 