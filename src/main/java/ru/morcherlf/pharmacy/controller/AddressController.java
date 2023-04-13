package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.morcherlf.pharmacy.entity.Address;
import ru.morcherlf.pharmacy.entity.User;
import ru.morcherlf.pharmacy.repository.AddressRepository;
import ru.morcherlf.pharmacy.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AddressController {
    final AddressRepository addressRepository;
    final UserRepository userRepository;


//  Get Address By ID
    @GetMapping("/address/{id}")
    Optional<Address> getAddress(@PathVariable("id") long id){
    return addressRepository.findById(id);
}

//  Get Address List By User
    @GetMapping("/address/{UserID}")
    List<Address> getAddressListByUser(@PathVariable("UserID") long userID){
        User user = userRepository.getReferenceById(userID);
        return addressRepository.findByUser(user);
    }

//  Add New Address
    @PostMapping("/address")
    Address addAddress(@RequestBody Address address) {return addressRepository.save(address);}

}
