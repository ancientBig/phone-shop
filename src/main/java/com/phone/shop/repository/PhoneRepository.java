package com.phone.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phone.shop.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone,Long> {

}