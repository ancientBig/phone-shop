package com.phone.shop.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.phone.shop.entity.Phone;
import com.phone.shop.repository.PhoneRepository;
import com.phone.shop.service.IPhoneService;
import com.phone.shop.service.exception.ResourceNotFoundException;

@Service
@Transactional
public class PhoneImplemementation implements IPhoneService {
	@Autowired
    private PhoneRepository phoneRepository;

    public PhoneImplemementation(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public Iterable<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getPhone(long id) {
        return phoneRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Phone not found"));
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }
}
