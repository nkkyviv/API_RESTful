package com.groupone.controller;

import com.groupone.contract.CreateCustomerRequest;
import com.groupone.contract.UpdateCustomerRequest;
import com.groupone.model.Customer;
import com.groupone.service.CustomerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "resource not found"),
            @ApiResponse(responseCode = "500", description = "Server Error")}
    )
    public List<Customer> getCustomer(){

        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "resource not found"),
            @ApiResponse(responseCode = "500", description = "Server Error")}
    )
    public Customer getACustomer(@Valid @PathVariable int id) {

        return customerService.getCustomer(id);
    }

    @PostMapping("/add")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "resource not found"),
            @ApiResponse(responseCode = "500", description = "Server Error")}
    )
    public ResponseEntity<?> addCustomer(
            @Valid @RequestBody CreateCustomerRequest request){

        if (customerService.createCustomer(request))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Update an existing customer
    @PutMapping("/update/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "resource not found"),
            @ApiResponse(responseCode = "500", description = "Server Error")}
    )
    public ResponseEntity<?> updateCustomer(@Valid @PathVariable int id, @RequestBody UpdateCustomerRequest request) {
        if (customerService.updateCustomer(id, request)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // If the customer doesn't exist
        }
    }

    // Delete a customer @PathVariable is used to extract a variable from the URI (Uniform Resource Identifier) in a RESTful AP
    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "resource not found"),
            @ApiResponse(responseCode = "500", description = "Server Error")}
    )
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        if (customerService.deleteCustomer(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exp){

        Map<String, String> errors = new HashMap<>();
        exp.getBindingResult().getAllErrors().forEach((error)-> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}
