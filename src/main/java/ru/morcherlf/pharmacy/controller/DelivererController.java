package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class DelivererController{
    private final DelivererRepository delivererRepository;

//  Add New Deliverer
    @PostMapping("/deliverer")
    Deliverer addDeliverer(@RequestBody Deliverer deliverer) {
        if (delivery.id) {
            return("ID should be empty");
        }
        return(delivererRepository.save(deliverer));
    }

//  Edit Deliverer
    @PostMapping("/deliverer/edit")
    Deliverer editDeliverer(@RequestBody Deliverer deliverer) {
        if (delivery.id) {
            return(delivererRepository.save(deliverer));
        }
        return("ID shouldn't be empty");
    }

//  Get Deliverer By ID
    @GetMapping("/deliverer/{id}")
    Optional<Deliverer> getDeliverer(@PathVariable("id") long id){
        return delivererRepository.findById(id);
    }

//  Get DelivererList
    @GetMapping("/deliverer")
    List<Deliverer> getAddressList(){ return delivererRepository.findAll(); }

//  Delete Deliverer (Hidden)
    @TODO

//  Show Delivery By Deliverer
    @TODO
}