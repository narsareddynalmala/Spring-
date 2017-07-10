package edu.aspire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.aspire.data.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerResource{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@RequestMapping(method=RequestMethod.POST, headers={"Content-Type=application/xml, application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void insertCustomer(@RequestBody Customer customer) throws Exception {
		hibernateTemplate.save(customer);
	}
	
	@RequestMapping(method=RequestMethod.GET, headers={"Accept=application/xml, application/json"}, value="/{id}")
	public @ResponseBody Customer readCustomer(@PathVariable("id") int id){
		Customer cust = hibernateTemplate.get(Customer.class, id);
		return cust;
	}
}
