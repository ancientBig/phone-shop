package com.phone.shop.service;

import com.phone.shop.entity.Phone;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.NotNull;

@Validated
public interface  IPhoneService {
	@NotNull Iterable<Phone> getAllPhones();
	Phone getPhone(@Min(value = 1L, message = "Invalid phone ID.") long id);
	Phone save(Phone product);
}
