package com.tech.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.info.entities.dtos.ProductDto;
import com.tech.info.services.ProductService;
import com.tech.info.utils.ResponceApi;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/web/api/product/")
public class ProductController {

	private ProductService productService;

	//Constructor injection
	ProductController(ProductService productService) {
		this.productService = productService;
	}

	// CREATE PRODUCT
	@PostMapping("create-product")
	ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
		ProductDto createProduct = this.productService.createProduct(productDto);
		return new ResponseEntity<ProductDto>(createProduct, HttpStatus.CREATED);

	}

	// UPDATE PRODUCT
	@PutMapping("update-product/{id}")
	ResponseEntity<ProductDto> updateProduct(@PathVariable(name = "id") long productId,
			@Valid @RequestBody ProductDto productDto) {
		ProductDto updateProduct = this.productService.updateProduct(productId, productDto);
		return new ResponseEntity<ProductDto>(updateProduct, HttpStatus.OK);
	}

	// DELETE PRODUCT
	@DeleteMapping("delete-product/{id}")
	ResponseEntity<?> deleteProductById(@PathVariable(name = "id") long productId) {
		this.productService.deleteProduct(productId);
		return new ResponseEntity<>(new ResponceApi("Product deleted successfull", true), HttpStatus.OK);
	}

	// GET PRODUCT LIST
	@GetMapping("get-all-product")
	ResponseEntity<?> getProductList() {
		List<ProductDto> productList = this.productService.getProductList();
		return ResponseEntity.ok(productList);
	}

	// FIND PRODUCT
	@GetMapping("product/{id}")
	ResponseEntity<?> getProductById(@PathVariable(name = "id") long productId) {
		ProductDto findProductById = this.productService.findProductById(productId);
		return ResponseEntity.ok(findProductById);
	}

}
