package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.morcherlf.pharmacy.entity.Shop;
import ru.morcherlf.pharmacy.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final ShopRepository shopRepository;

//  Get All Shop
    @GetMapping("/shop")
    List<Shop> getShop(){
        return shopRepository.findAll();
    }

//  Get Shop by ID
    @GetMapping("/shop/{id}")
    Optional<Shop> getCategory(@PathVariable("id") long id){
        return shopRepository.findById(id);
    }

//  Add New Shop For SystemAdmin
    @PostMapping("/shop")
    Shop newShop(@RequestBody Shop shop){return shopRepository.save(shop);}

//  Edit Shop For Manager & SystemAdmin
    @PostMapping("/shop/edit")
    Shop edit(@RequestBody Shop shop){return shopRepository.save(shop);}

}
