package com.venkat.sciencebay.repository;

import org.springframework.data.repository.CrudRepository;
import com.venkat.sciencebay.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
