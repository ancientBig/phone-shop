package com.phone.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.phone.shop.entity.Phone;
import com.phone.shop.entity.PhoneContract;
import com.phone.shop.entity.Role;
import com.phone.shop.service.IPhoneService;
import com.phone.shop.service.Impl.PhoneContractImplementation;
import com.phone.shop.service.Impl.UserRoleService;

@SpringBootApplication
public class PhoneShopMApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneShopMApplication.class, args);
	}

	@Bean
    CommandLineRunner runner(IPhoneService productService, PhoneContractImplementation phoneContractService,
    		UserRoleService userRoleService) {
        return args -> {
            Phone a34 = productService.save(new Phone(1L, "Samsung Galaxy A34", 7000.00));
            //contact
            phoneContractService.save(new PhoneContract(1L, "12 Months", 750.00, a34));
            phoneContractService.save(new PhoneContract(2L, "24 Months", 550.00, a34));
            phoneContractService.save(new PhoneContract(3L, "36 Months", 350.00, a34));
            
            Phone a33 = productService.save(new Phone(2L, "Samsung Galaxy A33", 6000.00));
            //contact
            phoneContractService.save(new PhoneContract(4L, "12 Months", 650.00, a33));
            phoneContractService.save(new PhoneContract(5L, "24 Months", 510.00, a33));
            phoneContractService.save(new PhoneContract(6L, "36 Months", 250.00, a33));
            
            
            Phone x7b = productService.save(new Phone(3L, "Honor X7B", 6400.00));
          //contact
            phoneContractService.save(new PhoneContract(7L, "12 Months", 450.00, x7b));
            phoneContractService.save(new PhoneContract(8L, "24 Months", 320.00, x7b));
            phoneContractService.save(new PhoneContract(9L, "36 Months", 110.00, x7b));
            
            //role
            userRoleService.save(new Role(1L,"ROLE_ADMIN" ));
        };
    }
}