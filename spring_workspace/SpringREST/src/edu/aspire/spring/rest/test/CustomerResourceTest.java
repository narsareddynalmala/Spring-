package edu.aspire.spring.rest.test;

import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.aspire.data.Customer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerResourceTest{
   @Test
   public void testInsertCustomer() throws Exception{
      System.out.println("*** Create a new Customer ***");
	  Customer cust = new Customer();
	  cust.setCname("Ramesh");
	  cust.setEmail("ramesh@java2aspire.com");
	  cust.setMobile("7799108899");
	  
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	  //headers.setContentType(MediaType.APPLICATION_JSON);
	  HttpEntity<Customer> entity = new HttpEntity<Customer>(cust, headers);
	  new RestTemplate().postForLocation("http://localhost:9090/SpringREST/customers", entity);
   }

   @Test
   public void testReadCustomer() throws Exception{
	   //The exchange() method is used to set headers on the request sent to the server.
	   HttpHeaders headers = new HttpHeaders();
	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	   //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	   HttpEntity<String> entity = new HttpEntity<String>(headers);

	   ResponseEntity<Customer> response = new RestTemplate().exchange("http://localhost:9090/SpringREST/customers/{cid}", HttpMethod.GET, entity, Customer.class, 1);
	   Customer c = response.getBody();
	  
       System.out.println(c.getCid()+"\t"+c.getCname()+"\t"+c.getEmail()+"\t"+c.getMobile());
   }
}
