package com.sample.spring.app1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerDataController {

	// private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/customerData")
	public List<CustomerData> getCustomerDate(
			@RequestParam(value = "limit", defaultValue = "20") int limit)

	{
		// Read Data from CSV file and return to application.
		return ReadCsv.readCsvFile(limit);

	}
}