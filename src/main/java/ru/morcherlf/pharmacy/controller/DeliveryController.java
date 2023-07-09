package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class DeliveryController{
    private final DeliveryRepository deliveryRepository;

//  Add New Delivery
    @PostMapping("/delivery")
    Delivery addDelivery(@RequestBody Delivery delivery) {
        return(deliveryRepository.save(delivery));
    }

//  Edit Delivery
    @PostMapping("/delivery/edit")
    Delivery editDelivery(@RequestBody Delivery delivery) {
        if (delivery.id) {
            return(deliveryRepository.save(ddeliveryeliverer));
        }
        return("ID shouldn't be empty");
    }
}