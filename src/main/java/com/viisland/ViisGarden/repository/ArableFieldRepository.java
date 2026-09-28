package com.viisland.ViisGarden.repository;

import com.viisland.ViisGarden.entity.ArableField;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArableFieldRepository extends MongoRepository<ArableField, String> {
}
