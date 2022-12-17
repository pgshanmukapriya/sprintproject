package com.abc.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.LifeInsurance;

@Repository
public interface LifeInsuranceRepository extends JpaRepository<LifeInsurance, Integer>,LifeInsuranceCustomRepository
{


}
