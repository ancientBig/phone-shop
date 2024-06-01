package com.phone.shop.service;

import org.springframework.validation.annotation.Validated;
import com.phone.shop.entity.PhoneContract;

@Validated
public interface PhoneContractService {
	PhoneContract save(PhoneContract phoneContract);
}
