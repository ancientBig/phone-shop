package com.phone.shop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.phone.shop.entity.PhoneContract;

public interface PhoneContractRepository extends CrudRepository<PhoneContract, Long> {
	@Query(value="SELECT * FROM phonecontract a WHERE a.price <=:amount ", nativeQuery = true)
	public List<PhoneContract> searchContract(@Param("amount")  double amount);
}