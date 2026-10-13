package com.viisland.ViisGarden.repository;

import com.viisland.ViisGarden.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    Product findByProductNameAndProductYear(String productName, String productYear);
}
