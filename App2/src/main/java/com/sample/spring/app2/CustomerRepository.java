package com.sample.spring.app2;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends MongoRepository<Customer, String> {

	List<Customer> findByLastName(@Param("name") String name);

	List<Customer> findByFirstName(@Param("name") String name);

	Customer findById(@Param("id") String id);

}
