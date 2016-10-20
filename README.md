# MongoDB Sample

Aplication1 Version 0.2 21/10/2016

The application reads a csv file named customerData.csv stored at src/main/resources/csvFiles/.
The application provides Restful API to access customer data
URI: http://localhost:9090/customerData?limit
Limit is used to control number for records returned default value is 20.


Aplication2 Version 0.2 21/10/2016
The application provides the below mentioned functionality through Restful API's

The application requires a local installation on MonogoDB. 


1. Save customer Data to MonogoDB
The application retrieves data by calling Application1 REST API and storing it in a MongoDB collection.
URI: http://localhost:8080/savecustomerdata?limit100

2. List all Customer in database
This URI will provide a list of all the customers in the database.
URI: http://localhost:8080/customer

3. Insert Orders for customers
This REST API allows orders to be added for a given customer.

URI http://localhost:8080/saveOrderdata?customerId&orderDesc&orderQty&orderPrice

Parameters:
customerId (Id of the customer)
orderDesc (Description of the Order)
orderQty (Quantatiy of the Order)
orderPrice (Price of the Order

4. Search for Customer using First and Last name.
This URI will list the available search options
URI: http://localhost:8080/customer/search

To find customer by First Name
URI: http://localhost:8080/customer/search/findByFirstName?name

To find customer by Last Name
URI: http://localhost:8080/customer/search/findByLastName?name

To find customer by Id
URI: http://localhost:8080/customer/search/findById?id
