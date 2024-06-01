package com.phone.shop.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.phone.shop.entity.PhoneContract;
import com.phone.shop.repository.PhoneContractRepository;
import com.phone.shop.service.PhoneContractService;

@Service
@Transactional
public class PhoneContractImplementation implements PhoneContractService{
	@Autowired
	private PhoneContractRepository phoneContractRepository;

	@Override
	public PhoneContract save(PhoneContract phoneContract) {
        return phoneContractRepository.save(phoneContract);
	}

	public List<PhoneContract> searchContract(double amount) {
		return phoneContractRepository.searchContract(amount);
	}
}
