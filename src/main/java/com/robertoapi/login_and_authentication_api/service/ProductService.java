package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.dtos.ProductRequestDTO;
import com.robertoapi.login_and_authentication_api.dtos.ProductResponseDTO;
import com.robertoapi.login_and_authentication_api.model.Product;
import com.robertoapi.login_and_authentication_api.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

//---------------------------------------------------------------------------------------

    public void createProduct(ProductRequestDTO productDTO){
        Product product = toEntity(productDTO);
        productRepository.save(product);
    }


    public List<ProductResponseDTO> findAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    public Optional<ProductResponseDTO> findProductById(Long id){
        return productRepository.findById(id)
                .map(this::toResponseDTO);
    }


    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


    public void updateProductById(Long id, ProductRequestDTO updateProductDTO){
        Optional<Product> productDB = productRepository.findById(id);

        if(productDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        else{
            Product editProduct = productDB.get();

            editProduct.setName(updateProductDTO.getName());
      //      editProduct.setCategory(updateProduct.getCategory());

            productRepository.save(editProduct);
        }
    }

//------------------------------------------------------------------------------------------
//DTOs

    private Product toEntity(ProductRequestDTO productDTO){
        Product product = new Product();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(product.getCategory());
        product.setInventory(productDTO.getInventory());

        return product;
    }


        private ProductResponseDTO toResponseDTO(Product product){
            ProductResponseDTO respDTO = new ProductResponseDTO();
            respDTO.setId(product.getId());
            respDTO.setName(product.getName());
            respDTO.setDescription(product.getDescription());
            respDTO.setPrice(product.getPrice());

            return respDTO;
        }


}
