package com.liftoff.cnvInvestments.models.data;

import com.liftoff.cnvInvestments.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
