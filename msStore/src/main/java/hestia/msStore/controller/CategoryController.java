package hestia.msStore.controller;

import hestia.msStore.payload.CategoryDto;
import hestia.msStore.payload.CategoryResponse;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.service.CategoryServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceIMPL serviceIMPL;

    @GetMapping
    public CategoryResponse getAllCategory(
            @RequestParam(value = "page", defaultValue = "0" ,required = false) int page,
            @RequestParam(value = "linesPerPage", defaultValue = "10", required = false) int linesPerPage,
            @RequestParam(value = "orderBy",  defaultValue = "id",required = false) String orderBy,
            @RequestParam(value = "direction",  defaultValue = "asc",required = false) String direction
    ){
        return new ResponseEntity<>(serviceIMPL.getAllCategory ( page,linesPerPage,orderBy,direction), HttpStatus.OK).getBody();
    }


    @GetMapping
    public List<CategoryDto> findAllCategories(@RequestBody @Valid CategoryDto categoryDto){
        return serviceIMPL.findAllCategories(categoryDto);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CategoryDto categoryDto){
        return new ResponseEntity<>(serviceIMPL.createCategory(categoryDto), HttpStatus.CREATED);
    }




}