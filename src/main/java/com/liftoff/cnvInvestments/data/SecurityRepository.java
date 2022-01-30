package com.liftoff.cnvInvestments.data;

import com.liftoff.cnvInvestments.models.Security;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends CrudRepository<Security, Integer> {
    Security findBySecurityName(String securityName);
}
