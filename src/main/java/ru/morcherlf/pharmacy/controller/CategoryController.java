package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.morcherlf.pharmacy.entity.Category;
import ru.morcherlf.pharmacy.repository.CategoryRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;

//  Get All Category
    @GetMapping("/category")
    List<Category> getCategory(){
        return categoryRepository.findAll();
    }

//  Get Category By ID
    @GetMapping("/category/{id}")
    Optional<Category> getCategory(@PathVariable("id") long id){
        return categoryRepository.findById(id);
    }

//  Add New Category
    @PostMapping("/category")
    Category newCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

//  Edit Category By ID
    @PutMapping("/category/{id}")
    Category updateCategory(@PathVariable("id") long id, @RequestBody Category category){
        Optional<Category> categoryData = categoryRepository.findById(id);
        if (categoryData.isPresent()) {
            Category _category = categoryData.get();
            _category.setName(category.getName());
            return categoryRepository.save(_category);
        }else {
            return null;
        }
    }


}
