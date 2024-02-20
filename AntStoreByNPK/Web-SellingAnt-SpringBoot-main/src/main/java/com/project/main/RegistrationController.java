package com.project.main;


import com.project.main.entity.Address;
import com.project.main.entity.Customer;
import com.project.main.service.AddressService;
import com.project.main.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService AddressService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("address", new Address());
        return "registration";
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute("customer") Customer customer,@ModelAttribute("address") Address address) {
        
        // You can perform validation and save the customer in your database here
        Customer newcustomer = customerService.getCustomerByUsername(customer.getUsername());
        if (newcustomer == null || !newcustomer.getPassword().equals(customer.getPassword()) ) {
            AddressService.saveAddress(address);
            customer.setAddress(address);
            System.out.println(address);
            customerService.saveCustomer(customer);
            return "redirect:/login";
        }

        return "redirect:/register"; // Redirect to the login page after registration
    }
}

