package com.liftoff.cnvInvestments.data;

import com.liftoff.cnvInvestments.models.Investor;
import org.springframework.data.repository.CrudRepository;

public interface InvestorRepository extends CrudRepository<Investor, Integer> {

    Investor findByUsername (String username);

}

