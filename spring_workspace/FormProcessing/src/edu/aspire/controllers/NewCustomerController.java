//CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
//CREATE SEQUENCE CUSTOMER_SEQ;
package edu.aspire.controllers;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.aspire.data.Customer;

@Controller
@RequestMapping("/customers")
public class NewCustomerController{ //controller class means business comp
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@RequestMapping(method=RequestMethod.GET, params="new")
	public String createCustomerProfile(Map<String, Object> m){
		m.put("customer", new Customer());
		return "NewCustomer";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String insertCustomer(@Valid Customer customer, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){ //In case of validation errors
			return "NewCustomer"; //redirected back to request page
		}

		Integer cid = (Integer)hibernateTemplate.save(customer);
		customer.setCid(cid);
		
		return "success";
	}
}
