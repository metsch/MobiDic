package com.mobidic.datasource.repositories;

import com.mobidic.datasource.models.Client_entry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Client_entryRepository extends CrudRepository<Client_entry,Long>{

} 