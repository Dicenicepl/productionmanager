package com.example.demo.service;

import com.example.demo.entity.AppOrder;
import com.example.demo.entity.AppUser;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public void registration(AppUser appUser){
            userRepository.save(appUser);
    }
    public AppUser findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    public void orderProduct(AppOrder appOrder){
        orderRepository.save(appOrder);
    }
    public List<AppOrder> listAllOrders(){
        return orderRepository.findAll();
    }
    public AppOrder findOrderByName(String name){
        return orderRepository.findAppOrderByProductName(name);
    }

    //DeleteMapping
    public boolean deleteOrder(Long id){
        if (orderRepository.findById(id).isPresent()){
            orderRepository.deleteById(id);
            return true;
        }else return false;
    }
}
