package com.restorant.Restorant.Controller;

import com.restorant.Restorant.Service.ProductService;
import com.restorant.Restorant.pyload.ReqProduct;
import com.restorant.Restorant.pyload.ResProduct;
import com.restorant.Restorant.pyload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("dashboard/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/0009792:2006:30:11/shahrizod")
    public String getProduct() {
        return "Product";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<ResProduct> getProductList() {
        return productService.getProductList();
    }

    @GetMapping("/0009792:2006:30:11/shahrizod/{id}")
    @ResponseBody
    public List<ResProduct> getProductOfOneCategory(@PathVariable Integer id) {
        return productService.getOneCategoryOfProduct(id);
    }

    @GetMapping("/0009792:2006:30:11/shahrizod/page/{id}")
    public String getProductOfOneCategoryPage() {
        return "UserProduct";
    }

    @PostMapping
    @ResponseBody
    public Result addProduct(@RequestBody ReqProduct reqProduct) {
        return productService.addProduct(reqProduct);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Result editProduct(@PathVariable Integer id, @RequestBody ReqProduct reqProduct) {
        return productService.editProduct(id, reqProduct);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }



}

