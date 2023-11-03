package com.tech.info.services;

import java.util.List;

import com.tech.info.entities.dtos.ProductDto;

public interface ProductService {
	
	// CREATE PRODUCT
	ProductDto createProduct(ProductDto productDto);
	
	//UPDATE PRODUCT
	ProductDto updateProduct(long productId, ProductDto productDto);
	
	//FIND PRODUCT
	List<ProductDto> getProductList();
	
	//GET PRODUCT BY ID
	ProductDto findProductById(long productId);
	
	//DELETE PRODUCT
	void deleteProduct(long productId);
	
	//SEARCH EMPLOYEE WITH PRODUCT
	

}
