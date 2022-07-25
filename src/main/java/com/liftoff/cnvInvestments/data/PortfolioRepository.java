package com.liftoff.cnvInvestments.data;

import com.liftoff.cnvInvestments.models.Portfolio;
import com.liftoff.cnvInvestments.models.Security;
import com.liftoff.cnvInvestments.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends CrudRepository<Portfolio, Integer> {
    Portfolio findBySecurity(Security security);

}
