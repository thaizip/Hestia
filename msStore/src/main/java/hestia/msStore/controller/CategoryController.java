package hestia.msStore.controller;

import hestia.msStore.model.Category;
import hestia.msStore.payload.CategoryDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.service.CategoryServiceIMPL;
import jakarta.validation.Valid;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
//    private CategoryServiceIMPL serviceIMPL;
//    private CategoryRepository categoryRepository;
//
//    private ModelMapper mapper;
//
//    @Autowired
//    public CategoryController(CategoryServiceIMPL serviceIMPL, CategoryRepository categoryRepository, ModelMapper mapper) {
//        this.serviceIMPL = serviceIMPL;
//        this.categoryRepository = categoryRepository;
//        this.mapper = mapper;
//    }
//
////  localhost:8082/category/list?page=0&size=10&orderBy=categoryId&direction=asc
//    @GetMapping("/list")
//    public ResponseEntity<Map<String, Object>> getAllCategory(
//            @RequestParam(value = "page", defaultValue = "0" ,required = false) int page,
//            @RequestParam(value = "linesPerPage", defaultValue = "10", required = false) int linesPerPage,
//            @RequestParam(value = "orderBy",  defaultValue = "categoryId",required = false) String orderBy,
//            @RequestParam(value = "direction",  defaultValue = "asc",required = false) String direction
//    ){
//        Page<Category> categoryPage = categoryRepository.findAll(PageRequest.of(page, linesPerPage, Sort.by(Sort.Direction.fromString(direction.toLowerCase()), orderBy)));
//        List<CategoryDto> content = categoryPage.getContent().stream().map(category -> mapper.map(category, CategoryDto.class)).collect(Collectors.toList());
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("categoryDtos", content);
//        return ResponseEntity.ok(response);
//    }
//
////    localhost:8082/category/find
//    @GetMapping("/find")
//    public List<CategoryDto> findAllCategories(){
//        return serviceIMPL.findAllCategories();
//    }
//
//   // localhost:8082/category/create
//    @PostMapping("/create")
//    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CategoryDto categoryDto){
//        return new ResponseEntity<>(serviceIMPL.createCategory(categoryDto), HttpStatus.CREATED);
//    }
//



}