package com.tech.info.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tech.info.entities.ProductDetails;
import com.tech.info.entities.dtos.ProductDto;
import com.tech.info.exceptions.ResourceNotFoundException;
import com.tech.info.repositories.ProductRepo;
import com.tech.info.services.ProductService;

@Service
public class ProductServiceImple implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		ProductDetails productDetails = this.modelMapper.map(productDto, ProductDetails.class);
		 ProductDetails saveProduct = this.productRepo.save(productDetails);
		return this.modelMapper.map(saveProduct, ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(long productId, ProductDto productDto) {
		 ProductDetails productDetails = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", String.valueOf(productId)));
		productDetails.setProductName(productDto.getProductName());
		productDetails.setProductDescription(productDto.getProductDescription());
		 ProductDetails save = this.productRepo.save(productDetails);
		return this.modelMapper.map(save, ProductDto.class);

	}

	@Override
	public List<ProductDto> getProductList() {
		 List<ProductDetails> findAll = this.productRepo.findAll();
		 List<ProductDto> collect = findAll.stream()
				.map((product) -> this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public ProductDto findProductById(long productId) {
		ProductDetails productDetails = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", String.valueOf(productId)));
		return this.modelMapper.map(productDetails, ProductDto.class);

	}

	@Override
	public void deleteProduct(long productId) {
		ProductDetails productDetails = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", String.valueOf(productId)));
		this.productRepo.delete(productDetails);

	}

}
