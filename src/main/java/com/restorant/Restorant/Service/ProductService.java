package com.restorant.Restorant.Service;

import com.restorant.Restorant.Entity.Category;
import com.restorant.Restorant.Entity.Product;
import com.restorant.Restorant.Repository.CategoryRepository;
import com.restorant.Restorant.Repository.ProductRepository;
import com.restorant.Restorant.pyload.ReqCategory;
import com.restorant.Restorant.pyload.ReqProduct;
import com.restorant.Restorant.pyload.ResProduct;
import com.restorant.Restorant.pyload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    public Result addProduct(ReqProduct reqProduct) {
        if (reqProduct.getName().trim().length() != 0) {
            if (reqProduct.getPrice() != 0) {
                if (reqProduct.getDescription().trim().length() != 0) {
                    Optional<Category> byId = categoryRepository.findById(reqProduct.getCategoryId());
                    if (byId.isPresent()) {
                        Category category = byId.get();
                        Product product = new Product(reqProduct.getName(), reqProduct.getPhoto(), reqProduct.getPrice(), reqProduct.getDescription());
                        category.getProduct().add(product);
                        productRepository.save(product);
                        return new Result("mahsulot saqlandi", true);
                    }
                    return new Result("bunday idlik category topilmadi", false);
                }
                return new Result("mahsulotning tavsilotini kiritimadingiz", false);
            }
            return new Result("mahsulotning narxini kritimadingiz", false);
        }
        return new Result("mahsulotning nomini kiritimadingiz", false);
    }

    public List<ResProduct> getProductList() {
        List<ResProduct> resProducts = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            ResProduct resProduct = new ResProduct(
                    product.getId(),
                    product.getName(),
                    product.getPhoto(),
                    product.getPrice(),
                    product.getDescription()
            );
            resProducts.add(resProduct);
        }
        return resProducts;
    }

    public Result editProduct(Integer id, ReqProduct reqProduct) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            product.setName(reqProduct.getName());
            product.setDescription(reqProduct.getDescription());
            product.setPhoto(reqProduct.getPhoto());
            product.setPrice(reqProduct.getPrice());
            productRepository.save(product);
            return new Result("Taxrirlandi", true);
        }
        return new Result("bunday product mavjud emas", false);
    }

    public Result deleteProduct(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        for (Category category : categoryRepository.findAll()) {
            if (byId.isPresent()) {
                Product product = byId.get();
                category.getProduct().remove(product);
                productRepository.delete(product);
                categoryRepository.save(category);
                return new Result("O'chirildi", true);
            }
        }


        return new Result("Product topilmadi", false);
    }

    public List<ResProduct> getOneCategoryOfProduct(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        List<ResProduct> resProducts = new ArrayList<>();
        if (byId.isPresent()) {
            Category category = byId.get();
            for (Product product : category.getProduct()) {
                ResProduct resProduct = new ResProduct(
                        product.getId(),
                        product.getName(),
                        product.getPhoto(),
                        product.getPrice(),
                        product.getDescription()
                );
                resProducts.add(resProduct);
            }
            return resProducts;
        }
        return null;
    }
}
