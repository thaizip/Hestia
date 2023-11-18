package hestia.msStore.controller;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.service.CategoryServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryServiceIMPL serviceIMPL;
    private CategoryRepository categoryRepository;

    private ClassMapper classMapper;

    @Autowired
    public CategoryController(CategoryServiceIMPL serviceIMPL, CategoryRepository categoryRepository, ClassMapper classMapper) {
        this.serviceIMPL = serviceIMPL;
        this.categoryRepository = categoryRepository;
        this.classMapper = classMapper;
    }

    @GetMapping("/{categoryName}")
    public List<ProductDto> findAllCategoryByName(@PathVariable String categoryName) {
        return serviceIMPL.findAllCategoryByName(categoryName);
    }

}