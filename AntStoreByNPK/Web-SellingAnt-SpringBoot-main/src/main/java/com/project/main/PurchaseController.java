package com.project.main;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.main.entity.Cart;
import com.project.main.entity.CartItem;
import com.project.main.entity.Customer;
import com.project.main.entity.Transaction;
import com.project.main.service.CartItemService;
import com.project.main.service.CartService;
import com.project.main.service.TransactionService;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartService cartService;
    @Autowired
    private TransactionService transactionService;
    @GetMapping
    public String showForm(Model model, HttpSession session) {
        Customer loginCustomer = (Customer) session.getAttribute("loginCustomer");
        model.addAttribute("customer", loginCustomer);
        List<Cart> c;

        model.addAttribute("address", loginCustomer.getAddress());

        c = cartService.findByCustomer(loginCustomer);
        Cart cart = c.get(c.size()-1);
        System.out.println("cart size in view: " + c.size());
        List<CartItem> cartItems = cartItemService.findByCart(cart);
        System.out.println("cart items size in view: " + cartItems.size());
        if(cartItems.isEmpty()){
            return "redirect:/store";
        }
        model.addAttribute("cartItems", cartItems);

        Transaction existingTransaction = transactionService.getByCart(cart);
        if(existingTransaction != null){
            model.addAttribute("transaction", existingTransaction);
            return "purchase";
        } else {
            Transaction newTransaction = new Transaction();
            newTransaction.setCart(cart);
            newTransaction.setTotalAmount(cart.calculateTotalPrice());
            newTransaction.setTransactionStatus("pending");
            newTransaction.setTransactionDate(new Date());
            newTransaction.setTransactionID(cart.getCartID());
            transactionService.saveTransaction(newTransaction);
            model.addAttribute("transaction", newTransaction);
            System.out.println("new transaction created");
            return "purchase";
        }
    }


    @GetMapping("/confirm")
    public String confirm(Model model, HttpSession session){
        System.out.println("\n\n");

        Customer loginCustomer = (Customer) session.getAttribute("loginCustomer");
        System.out.println("cart size in confirm: " + loginCustomer.getCart().size());

        List<Cart> c;
        c = cartService.findByCustomer(loginCustomer);
        Cart cart = c.get(c.size()-1);

        Transaction transaction = transactionService.getByCart(cart);

        
        transaction.setTransactionStatus("confirmed");
        transactionService.saveTransaction(transaction);
        
        cart.setCartStatus("closed");
        cartService.saveCart(cart);
        
        //System.out.println("transaction: " + transaction.toString());
        //System.out.println("cart: " + cart.toString());
        //System.out.println("customer: " + loginCustomer.toString());

        System.out.println("\n\n");
        return "redirect:/store";
    }

    
}
