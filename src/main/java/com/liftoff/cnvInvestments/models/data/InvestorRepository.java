package com.liftoff.cnvInvestments.models.data;

import com.liftoff.cnvInvestments.models.Investor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends CrudRepository<Investor, Integer> {
}
