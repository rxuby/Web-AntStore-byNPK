package com.project.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.main.entity.Address;
import com.project.main.entity.Customer;
import com.project.main.service.AddressService;
import com.project.main.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/editcustomer")
public class editCustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService AddressService;
    @Autowired
    private CustomerService CustomerService;
    @GetMapping
    public String showForm(HttpSession session , Model model) {
        Customer loginCustomer = (Customer) session.getAttribute("loginCustomer");

        if (loginCustomer.getAddress() == null){
            Address newAddress = new Address();
            newAddress.setDetail("some where");
            newAddress.setPostalCode("2323");
            loginCustomer.setAddress(newAddress);
            AddressService.saveAddress(newAddress);
            CustomerService.saveCustomer(loginCustomer);
            
            model.addAttribute("address", newAddress);
        } else {
            model.addAttribute("address", loginCustomer.getAddress());
        }
;
        model.addAttribute("customer", loginCustomer);
        



        return "editcustomer";
    }

    

    @PostMapping
    public String edit(HttpSession session , Model model,@ModelAttribute("customer") Customer customer, @ModelAttribute("address") Address address) {
    
        System.out.println(address);
        System.out.println(customer);

        Customer loginCustomer = (Customer) session.getAttribute("loginCustomer");
        loginCustomer.setFirstName(customer.getFirstName());
        loginCustomer.setLastName(customer.getLastName());
        loginCustomer.setPhoneNumber(customer.getPhoneNumber());
        loginCustomer.setEmail(customer.getEmail());;
        Address editaddress = loginCustomer.getAddress();
        editaddress.setDetail(address.getDetail());
        AddressService.saveAddress(editaddress);
        customerService.saveCustomer(loginCustomer);
        
        return "editcustomer";
    }

}
