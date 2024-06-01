package com.phone.shop.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.constraints.NotNull;
import com.phone.shop.dto.PhoneContractDto;
import com.phone.shop.entity.Phone;
import com.phone.shop.entity.PhoneContract;
import com.phone.shop.service.IPhoneService;
import com.phone.shop.service.Impl.PhoneContractImplementation;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {
	Logger logger = LoggerFactory.getLogger(PhoneController.class);
	@Autowired
	private IPhoneService phoneService;
	
	@Autowired
    private PhoneContractImplementation phoneContractService;
	
    public PhoneController(IPhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Phone> getPhones() {
    	logger.info("PhoneController.getPhones for contract phones amount ");
        return phoneService.getAllPhones();
    }
    
    @GetMapping(value ="/search-contract/{amount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhoneContractDto>> SearchForContracts(@PathVariable(value = "amount") double amount) {
    	logger.info("PhoneController.SearchForContracts for contract phones amount {} ",amount);
    	
    	List<PhoneContract> phoneContracts = phoneContractService.searchContract(amount);
    	List<PhoneContractDto> phoneContractsDtoList = new ArrayList<>();
        for (PhoneContract phct : phoneContracts) {
        	phoneContractsDtoList.add(new PhoneContractDto(phct));
        }
    	return new ResponseEntity<List<PhoneContractDto>>(phoneContractsDtoList, HttpStatus.OK);
    } 
}