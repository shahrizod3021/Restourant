package com.restorant.Restorant.Service;

import com.restorant.Restorant.Entity.Category;
import com.restorant.Restorant.Repository.CategoryRepository;
import com.restorant.Restorant.pyload.ReqCategory;
import com.restorant.Restorant.pyload.ResCategory;
import com.restorant.Restorant.pyload.Result;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    public List<ResCategory> getCategories() {
        List<Category> all = categoryRepository.findAll();
        List<ResCategory> categories = new ArrayList<>();
        for (Category category : all) {
            ResCategory resCategory = new ResCategory(
                    category.getId(),
                    category.getName(),
                    category.isActive(),
                    category.getPhoto(),
                    category.getProduct()
            );
            categories.add(resCategory);
        }
        return categories;
    }

    public Result addCategory(ReqCategory reqCategory) {
        if (reqCategory.getName().trim().length() != 0) {
                Category category = new Category(reqCategory.getName(), true, reqCategory.getPhoto());
                categoryRepository.save(category);
                return new Result("categoriya saqlandi", true);
        }
        return new Result("categoriya nomini kiriting", false);
    }

    public Result editCategory(Integer id, ReqCategory reqCategory) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(reqCategory.getName());
            category.setActive(true);
            category.setPhoto(reqCategory.getPhoto());
            categoryRepository.save(category);
            return new Result("taxrirlandi oka", true);
        }
        return new Result("bunday id lik category mavjud emas", false);
    }

    public Result deleteCategory(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            categoryRepository.delete(category);
            return new Result("Category o'chirildi", true);
        }
        return new Result("bunday idlik category topilmadi", false);
    }
}
