package com.sample.spring.app2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping("/savecustomerdata")
	public void saveCustomerDataToMonogoDB(
			@RequestParam(value = "limit", defaultValue = "20") int limit)

	{
		// Call the customerDate service provided by App1
		String url = "http://localhost:9090/customerData?limit=" + limit;
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(mediaTypes);
		HttpEntity<Customer> httpEntity = new HttpEntity<Customer>(null,
				headers);
		RestTemplate restTemplate = new RestTemplate();
		try {
			// Remove all existing values in Customer Table
			customerRepository.deleteAll();
			// Get the customer data from App1 and Save to mongoDB
			ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(
					url, HttpMethod.GET, httpEntity, Customer[].class);
			Customer[] customers = responseEntity.getBody();

			for (int i = 0; i < customers.length; i++) {
				customerRepository.save(customers[i]);
			}
			System.out.println("Saved all to MongoDB");

		} catch (RestClientException exception) {
			exception.printStackTrace();
		}

	}

	@RequestMapping("/saveOrderdata")
	public void saveOrderDataToMonogoDB(
			@RequestParam(value = "orderDesc") String orderDesc,
			@RequestParam(value = "orderQty") String orderQty,
			@RequestParam(value = "orderPrice") String orderPrice,
			@RequestParam(value = "customerId") String customerId)

	{

		try {
			// Create a new order for customer and save to orderList
			Order order = new Order();
			order.setOrderDesc(orderDesc);
			order.setOrderQty(orderQty);
			order.setOrderPrice(orderPrice);
			// find customer using Customer Id
			Customer customer = customerRepository.findById(customerId);
			if (customer.getOrders() == null) {
				ArrayList<Order> orders = new ArrayList<Order>();
				orders.add(order);
				customer.setOrders(orders);
			} else {
				customer.getOrders().add(order);
			}
			customerRepository.save(customer);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		System.out.println("Saved orders to MongoDB");
	}
}
