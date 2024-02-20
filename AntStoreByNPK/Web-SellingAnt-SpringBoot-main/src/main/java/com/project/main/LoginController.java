package com.project.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.main.entity.Customer;
import com.project.main.service.CustomerService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")
public class LoginController {
    CustomerService customerService;

    LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping
    public String showForm(HttpSession session) {
        if (session.getAttribute("loginCustomer") != null) {
            return "redirect:/store";
        }
        return "login";
    }

    @PostMapping
    public String processLogin(HttpSession session,@RequestParam String username, @RequestParam String password ) {
        if (session.getAttribute("loginCustomer") != null) {
            return "redirect:/store";
        }
        Customer customer = customerService.getCustomerByUsername(username);
        if (customer == null) {
            return "login";
        }
        System.out.println(customer.getUsername()+","+customer.getPassword());

        if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
            session.setAttribute("loginCustomer", customer);
            return "redirect:/store";
        } else {

            return "login";
        }
    }
}
