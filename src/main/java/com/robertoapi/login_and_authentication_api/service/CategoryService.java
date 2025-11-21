package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.dtos.CategoryRequestDTO;
import com.robertoapi.login_and_authentication_api.dtos.CategoryResponseDTO;
import com.robertoapi.login_and_authentication_api.mappers.ProductMapper;
import com.robertoapi.login_and_authentication_api.model.Category;
import com.robertoapi.login_and_authentication_api.model.Product;
import com.robertoapi.login_and_authentication_api.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public CategoryService(CategoryRepository categoryRepository, ProductMapper productMapper){
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

//------------------------------------------------------------------------------------------

    public void createCategory(CategoryRequestDTO categoryDTO){
        Category category = toEntity(categoryDTO);
        categoryRepository.save(category);
    }


    public List<CategoryResponseDTO> findAllCategorys(){
        return categoryRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    public Optional<CategoryResponseDTO> findCategoryById(Long id){
        return categoryRepository.findById(id).map(this::toResponseDTO);
    }


    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }


    public void updateCategoryById(Long id, CategoryRequestDTO updateCategoryDTO){
        Optional<Category> categoryDB = categoryRepository.findById(id);

        if(categoryDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
        else{
            Category editCategory = categoryDB.get();

            editCategory.setName(updateCategoryDTO.getName());

            categoryRepository.save(editCategory);

        }

    }

//------------------------------------------------------------------------------------------
//DTOs

    private Category toEntity(CategoryRequestDTO categoryDTO){
        Category category = new Category();

        category.setName(categoryDTO.getName());

        return category;
    }


    private CategoryResponseDTO toResponseDTO(Category category){
        CategoryResponseDTO respDTO = new CategoryResponseDTO();

        respDTO.setName(category.getName());
        respDTO.setProducts(category.getProducts().stream().map(productMapper::toResponseDTO).collect(Collectors.toList()));

        return respDTO;
    }



}
