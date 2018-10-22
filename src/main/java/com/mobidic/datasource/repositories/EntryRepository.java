package com.mobidic.datasource.repositories;

import com.mobidic.datasource.models.Entry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EntryRepository extends CrudRepository<Entry,Long>{

} 