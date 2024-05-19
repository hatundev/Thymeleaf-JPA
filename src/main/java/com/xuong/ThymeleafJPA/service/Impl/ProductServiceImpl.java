package com.xuong.ThymeleafJPA.service.Impl;

import com.xuong.ThymeleafJPA.entity.Brand;
import com.xuong.ThymeleafJPA.entity.Product;
import com.xuong.ThymeleafJPA.entity.Status;
import com.xuong.ThymeleafJPA.entity.SubCategory;
import com.xuong.ThymeleafJPA.repository.ProductRepository;
import com.xuong.ThymeleafJPA.repository.StatusRepository;
import com.xuong.ThymeleafJPA.request.ProductRequest;
import com.xuong.ThymeleafJPA.service.BrandService;
import com.xuong.ThymeleafJPA.service.ProductService;
import com.xuong.ThymeleafJPA.service.StatusService;
import com.xuong.ThymeleafJPA.service.SubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandService brandService;
    @Autowired
    private SubCateService subCateService;
    @Autowired
    private StatusService statusService;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(ProductRequest productRequest) {
        Product product = new Product();
        long statusId = 1;
        Status status = statusService.findById(statusId);
        Brand brand = brandService.findById(productRequest.getBrandId());
        List<Brand> brandList = new ArrayList<>();
        brandList.add(brand);
        SubCategory subCategory = subCateService.findById(productRequest.getSubCateId());
        product.setProductName(productRequest.getProductName());
        product.setColor(productRequest.getColor());
        product.setQuantity(productRequest.getQuantity());
        product.setSellPrice(productRequest.getSellPrice());
        product.setOriginPrice(productRequest.getOriginPrice());
        product.setSubCategory(subCategory);
        product.setBrand(brandList);
        product.setStatus(status);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductRequest productRequest) {
        List<Brand> brandList = new ArrayList<>();
        Product productFindById = productRepository.findById(productRequest.getId()).get();
        Brand brand = brandService.findById(productRequest.getBrandId());
        brandList.add(brand);
        productFindById.setProductName(productRequest.getProductName());
        productFindById.setColor(productRequest.getColor());
        productFindById.setQuantity(productRequest.getQuantity());
        productFindById.setSellPrice(productRequest.getSellPrice());
        productFindById.setOriginPrice(productRequest.getOriginPrice());
        productFindById.setBrand(brandList);
        productFindById.setStatus(statusService.findById(productRequest.getStatusId()));
        productFindById.setSubCategory(subCateService.findById(productRequest.getSubCateId()));
        return productRepository.save(productFindById);
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Thành công";
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductRequest convertProductToProductRequest(Product product) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(product.getId());
        productRequest.setProductName(product.getProductName());
        productRequest.setColor(product.getColor());
        productRequest.setQuantity(product.getQuantity());
        productRequest.setSellPrice(product.getSellPrice());
        productRequest.setOriginPrice(product.getOriginPrice());
        productRequest.setBrandId(product.getBrand().get(0).getId());
        productRequest.setSubCateId(product.getSubCategory().getId());
        productRequest.setStatusId(product.getStatus().getId());
        return productRequest;
    }
}
