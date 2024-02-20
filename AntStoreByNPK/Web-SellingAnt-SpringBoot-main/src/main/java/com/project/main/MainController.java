package com.project.main;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.main.entity.Customer;

import jakarta.servlet.http.HttpSession;


@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        model.addAttribute("islogin", false);

        Customer loginCustomer = (Customer) session.getAttribute("loginCustomer");
        if (loginCustomer != null){
            model.addAttribute("islogin", true);
            System.out.println("session by this customer: " + loginCustomer.getCustomerID());
            return "index";
        }
        return "index"; 
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginCustomer");
        return "redirect:/";
    }
}

