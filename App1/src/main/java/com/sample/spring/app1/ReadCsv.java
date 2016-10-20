package com.sample.spring.app1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author Usman This class reads the csv file and gives back an object
 */
public class ReadCsv {

	private final static AtomicLong counter = new AtomicLong();

	public void readCsv() {
	}

	public static List<CustomerData> readCsvFile(int limit) {
		String csvFileToRead = "src/main/resources/csvFiles/customerData.csv";
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		int count = 0;

		List<CustomerData> customerList = new ArrayList<CustomerData>();

		try {

			// Read the CSV file line by line
			br = new BufferedReader(new FileReader(csvFileToRead));
			// To skip the first line as it has column header
			br.readLine();
			while ((line = br.readLine()) != null && count != limit) {
				// Get the data from file, create customer objects and Add to
				// list
				String[] customers = line.split(splitBy);
				customerList.add(new CustomerData(String.valueOf(counter
						.incrementAndGet()), customers[0], customers[1],
						customers[2]));
				count++;

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done with reading CSV");
		return customerList;
	}
}