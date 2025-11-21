package com.robertoapi.login_and_authentication_api.controller;

import com.robertoapi.login_and_authentication_api.dtos.CategoryRequestDTO;
import com.robertoapi.login_and_authentication_api.dtos.CategoryResponseDTO;
import com.robertoapi.login_and_authentication_api.model.Category;
import com.robertoapi.login_and_authentication_api.repository.CategoryRepository;
import com.robertoapi.login_and_authentication_api.service.CategoryService;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

//------------------------------------------------------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody CategoryRequestDTO categoryDTO){
        categoryService.createCategory(categoryDTO);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponseDTO> findAllCategorys(){
        return categoryService.findAllCategorys();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CategoryResponseDTO> findCategoryById(@PathVariable Long id){
        return categoryService.findCategoryById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategoryById(@PathVariable Long id, @RequestBody CategoryRequestDTO updateCategoryDTO){
        categoryService.updateCategoryById(id, updateCategoryDTO);
    }



}
