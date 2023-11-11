package hestia.msStore.controller;

import hestia.msStore.payload.ProductDto;
import hestia.msStore.payload.ProductResponse;
import hestia.msStore.service.ProductServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductServiceIMPL serviceIMPL;

    @GetMapping
    public ProductResponse getAllProducts(
            @RequestParam(value = "page", defaultValue = "0" ,required = false) int page,
            @RequestParam(value = "linesPerPage", defaultValue = "10", required = false) int linesPerPage,
            @RequestParam(value = "orderBy",  defaultValue = "id",required = false) String orderBy,
            @RequestParam(value = "direction",  defaultValue = "asc",required = false) String direction
    ){
        return new ResponseEntity<>(serviceIMPL.getAllProducts( page,linesPerPage,orderBy,direction), HttpStatus.OK).getBody();
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto productDto, Integer categoryId){
        return new ResponseEntity<>(serviceIMPL.createProduct(productDto, categoryId), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(value = "id") int productId){
        return new ResponseEntity<>(serviceIMPL.getProductById(productId),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable(value = "id") int productId){
        serviceIMPL.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted Successfully",HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "id") int productId, @RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(serviceIMPL.updateProduct(productId,productDto),HttpStatus.OK);
    }



}