package com.viisland.ViisGarden.service;

import com.viisland.ViisGarden.entity.ArableField;
import com.viisland.ViisGarden.entity.Product;
import com.viisland.ViisGarden.repository.ArableFieldRepository;
import com.viisland.ViisGarden.repository.LocationRepository;
import com.viisland.ViisGarden.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ArableFieldService arableFieldService;
    private final LocationService locationService;


    @Transactional
    public Product addProduct(Product product) throws Exception {
        try {
            if (!checkProductInDb(product.getProductName(), product.getProductYear())) {
                Product newProduct = productRepository.save(product);
                arableFieldService.addArableFieldWithProduct(product.getProductField(), product.getProductId());
                locationService.addLocation(product.getProductField().getFieldLocation());
                return newProduct;
            } else {
                throw new Exception("Can not save product data because this product has already added.");
            }

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public Product updateProduct(String productId, Product product) throws Exception {
        try {
            Optional<Product> findProduct = findRelevantProduct(productId);
            if (findProduct.isPresent()) {
                findProduct.get().setProductName(product.getProductName());
                findProduct.get().setProductField(product.getProductField());
                findProduct.get().setProductYear(product.getProductYear());
                findProduct.get().setProductType(product.getProductType());
                findProduct.get().setProductYield(product.getProductYield());
                findProduct.get().setProductTotalPrice(product.getProductTotalPrice());
                arableFieldService.updateArableField(product.getProductField().getFieldId(), product.getProductField());
                locationService.updateLocation(product.getProductField().getFieldLocation().getLocationId(),product.getProductField().getFieldLocation());
                return productRepository.save(findProduct.get());
            } else {
                throw new Exception("Can not find relevant product data.");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public Product deleteProduct(String productId) throws Exception {
        try {
            Optional<Product> findProduct = findRelevantProduct(productId);
            if (findProduct.isPresent()) {
                 productRepository.deleteById(productId);
                 return findProduct.get();
            } else {
                throw new Exception("Can not delete product id: "+productId);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Product getProduct(String productId) throws Exception {
        Optional<Product> findProduct = findRelevantProduct(productId);
        if (findProduct.isPresent()) {
            return  findProduct.get();
        } else {
            throw new Exception("Can not find the product: " + productId);
        }
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    private Optional<Product> findRelevantProduct(String productId) throws Exception {
        try {
            if (!productId.isBlank()) {
                return productRepository.findById(productId);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private boolean checkProductInDb(String productName, String productYear) throws Exception {
        try {
           Product product = productRepository.findByProductNameAndProductYear(productName,productYear);
           if (product != null) {
               return true;
           } else {
               return false;
           }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
