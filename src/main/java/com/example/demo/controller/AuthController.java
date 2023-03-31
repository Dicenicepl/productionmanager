package com.example.demo.controller;

import com.example.demo.entity.AppOrder;
import com.example.demo.entity.AppUser;
import com.example.demo.service.AppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/authcontroller")
public class AuthController {
    //autoryzowani użytkownicy mają dostęp do tych kontrolerów
    private final AppService appService;
    public AuthController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/user/listusers")
    public List<AppUser> listUsers(){
        return appService.listAllUsers();
    }
    @GetMapping("/user/finduserbyemail")
    public AppUser findUserByEmail(String email){
        return appService.findUserByEmail(email);
    }
    @DeleteMapping("/user/deleteuser/{id}")
    public boolean deleteUser(@PathVariable("id") Long id){
        return appService.deleteUser(id);
    }

    @GetMapping("/order/listorders")
    public List<AppOrder> listOrders(){
        return appService.listAllOrders();
    }

    @GetMapping("/order/getorderbyname")
    public AppOrder getOrderById(String name){
        return appService.findOrderByName(name);
    }

    // TODO: 28.03.2023 wyciąganie zalogowanego użytkownika i wklejanie go jako productOwner
    @PostMapping("/order/createorder")
    public void createOrder(@RequestBody AppOrder appOrderRequest){
        AppOrder appOrder = new AppOrder(
                appOrderRequest.getProductName(),
                appOrderRequest.getDescription(),
                appOrderRequest.getProductOwner()
        );
        appService.orderProduct(appOrder);
    }
    @DeleteMapping("/order/deleteorder/{id}")
    public boolean deleteOrder(@PathVariable("id") Long id){
        return appService.deleteOrder(id);
    }


}
