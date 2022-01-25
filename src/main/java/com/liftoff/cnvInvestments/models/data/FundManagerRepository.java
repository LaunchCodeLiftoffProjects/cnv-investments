package com.liftoff.cnvInvestments.models.data;

import com.liftoff.cnvInvestments.models.FundManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundManagerRepository extends CrudRepository<FundManager, Integer> {
}
