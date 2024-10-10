# RealEstate API: Customer Management
Project Overview
This project is part of a larger real estate management API infrastructure designed to manage key resources such as customers, land listings, apartments, invoices, and payments. The API enables a real estate company to manage its day-to-day operations efficiently. This specific part of the API focuses on Customer Management—allowing the company to perform CRUD operations (Create, Read, Update, Delete) on customer records and retrieve relevant information.
1. Create a New Customer
Endpoint: POST /api/customers/add
Description: Adds a new customer to the system.
2. Retrieve a List of All Customers
Endpoint: GET /api/customers/
Description: Retrieves a list of all customers
3. Retrieve a Specific Customer by ID
Endpoint: GET /api/customers/{id}
Description: Retrieves detailed information about a specific customer.
4. Update a Customer Record
Endpoint: PUT /api/customers/update/{id}
Description: Updates the information of an existing customer.
5. Delete a Customer
Endpoint: DELETE /api/customers/{id}
Description: Deletes an existing customer.
