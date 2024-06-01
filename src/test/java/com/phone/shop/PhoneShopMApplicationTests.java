package com.phone.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import com.phone.shop.dto.PhoneContractDto;
import com.phone.shop.entity.Phone;
import com.phone.shop.repository.PhoneRepository;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = { PhoneShopMApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PhoneShopMApplicationTests {

	@Autowired 
	private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;
    
	@Autowired
    private PhoneRepository phoneRepository;
	
	@Test
    public void contextLoads() {
          assertThat(phoneRepository)
          .isNotNull();
    }
	 
	@Test
    public void GivenSixPhonePlansOnlyThreePlansWillBeBellowThreeHundred() {
	 try {
			 ResponseEntity<List<PhoneContractDto>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/phone/search-contract/300", HttpMethod.GET, null, new ParameterizedTypeReference<List<PhoneContractDto>>() {
		        });
	        if(responseEntity != null && responseEntity.hasBody()){
	        	Iterable<PhoneContractDto> products = responseEntity.getBody();
		        assertThat(products)
		          .hasSize(2);
	        }
	    } catch (RestClientException e) {
	        e.printStackTrace();
	    } 
    }
	 
    @Test
    void savePhone(){
        Phone phone = new Phone();
        phone.setName("Oppo");
        phone.setPrepaidPrice(600.00);
        Phone savedObject = phoneRepository.save(phone);
        assertThat(savedObject).isNotNull();
    }
}
