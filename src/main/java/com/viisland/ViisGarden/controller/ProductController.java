package com.viisland.ViisGarden.controller;

import com.viisland.ViisGarden.commons.PathConstant;
import com.viisland.ViisGarden.entity.Product;
import com.viisland.ViisGarden.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstant.ProductPath.PRODUCT_MAP)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(PathConstant.ProductPath.ADD_PRODUCT)
    public ResponseEntity<Product> addProduct(@RequestBody @Validated Product product) throws Exception {
        Product response = productService.addProduct(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(PathConstant.ProductPath.UPDATE_PRODUCT)
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody @Validated Product product) throws Exception {
        Product response = productService.updateProduct(productId,product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(PathConstant.ProductPath.DELETE_PRODUCT)
    public ResponseEntity<Product> deleteProduct(@PathVariable String productId) throws Exception {
        Product response = productService.deleteProduct(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(PathConstant.ProductPath.GET_PRODUCT)
    public ResponseEntity<Product> getProduct(@PathVariable String productId) throws Exception {
        Product response = productService.getProduct(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(PathConstant.ProductPath.GET_ALL_PRODUCT)
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> response = productService.getAllProduct();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
