package com.project.main;

import com.project.main.entity.Ant;
import com.project.main.entity.Cart;
import com.project.main.entity.CartItem;
import com.project.main.entity.Customer;
import com.project.main.service.AntService;
import com.project.main.service.CartItemService;
import com.project.main.service.CustomerService;
import com.project.main.service.CartService;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {

    private final AntService antService;
    private final CartItemService cartItemService;
    private final CartService cartService;
    public StoreController(AntService antService, CustomerService customerService, CartItemService cartItemService, CartService cartService) {
        this.antService = antService;
        this.cartItemService = cartItemService;
        this.cartService = cartService;
    }

    @GetMapping
    public String store(HttpSession session, Model model) {
        List<Ant> ants = antService.getAllAnts();
        model.addAttribute("ants", ants);
        
        Customer loginCustomer = (Customer) session.getAttribute("loginCustomer");
        //System.out.println("session by this customer: " + loginCustomer.toString());

        List<Cart> c = cartService.findByCustomer(loginCustomer);
        if (c.size()-1 == -1){
             Cart newCart = new Cart();
            newCart.setCustomer(loginCustomer);
            newCart.setCartStatus("open");
            newCart.setTotalPrice(0);
            cartService.saveCart(newCart);
            c = cartService.findByCustomer(loginCustomer);
            
        }
        c = cartService.findByCustomer(loginCustomer);
        if (c.get(c.size()-1).getCartStatus().equals("closed") || c.isEmpty() ){
            Cart newCart = new Cart();
            newCart.setCustomer(loginCustomer);
            newCart.setCartStatus("open");
            newCart.setTotalPrice(0);
            cartService.saveCart(newCart);
            c = cartService.findByCustomer(loginCustomer);
            System.out.println("new cart created");
        } 
        c = cartService.findByCustomer(loginCustomer);
        Cart cart = c.get(c.size()-1);
        List<CartItem> cartItems = cartItemService.findByCart(cart);
        model.addAttribute("cartItems", cartItems);


        return "store";
    }

    @PostMapping("/addToCart")
    public String AddToCart(HttpSession session, Model model, @RequestParam("antId") int antId) {

        Customer loginCustomer = (Customer) session.getAttribute("loginCustomer");
        //System.out.println("session by this customer: " + loginCustomer.toString());


        Ant ant = antService.getAntById(antId);


        List<Cart> c = cartService.findByCustomer(loginCustomer);
        Cart cart = c.get(c.size()-1);


        CartItem cartItem = new CartItem();
        cartItem.setAnt(ant);
        cartItem.setCart(cart);
        cartItem.setQuantity(1);
        cartItem.setSubtotalPrice(ant.getPrice());
        cartItemService.saveCartItem(cartItem);


        return "redirect:/store";
    }

    @PostMapping("/removeFromCart")
    public String RemoveFromCart(HttpSession session, Model model, @RequestParam("cartItemID") int cartItemID) {
        CartItem cartItem = cartItemService.getCartItemById(cartItemID);
        
        //System.out.println("cartItemID: " + cartItem);
        //System.out.println("cartItem: " + cartItem);
        cartItemService.deleteCartItem(cartItem);

        return "redirect:/store";
    }
}
