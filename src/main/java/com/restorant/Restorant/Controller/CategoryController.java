package com.restorant.Restorant.Controller;

import com.restorant.Restorant.Service.CategoryService;
import com.restorant.Restorant.pyload.ReqCategory;
import com.restorant.Restorant.pyload.ResCategory;
import com.restorant.Restorant.pyload.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dashboard/category")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/any")
    public String AnyCategory(){
        return "AnyCategory";
    }

    @GetMapping("/categoryList/0009792:2006:30:11/shahrizod")
    public String getCategory() {
        return "CategoryAdd";
    }
    @GetMapping("/admindashboard/0009792:2006:30:11/shahrizod")
    public String dashboard(){
        return "Adminpanel";
    }
    @GetMapping("/list")
    @ResponseBody
    public List<ResCategory> resCategoryList() {
        return categoryService.getCategories();
    }

    @PostMapping
    @ResponseBody
    public Result addCategory(@RequestBody ReqCategory reqCategory) {
        return categoryService.addCategory(reqCategory);
    }

    @PutMapping("/edit/{id}")
    @ResponseBody
    public Result editCategory(@PathVariable Integer id, @RequestBody ReqCategory reqCategory) {
        return categoryService.editCategory(id, reqCategory);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteCategory(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }
}
