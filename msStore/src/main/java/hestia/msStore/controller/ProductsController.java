package hestia.msStore.controller;

import hestia.msStore.payload.CategoryDto;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.payload.ProductResponse;
import hestia.msStore.service.ProductServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductServiceIMPL serviceIMPL;

//    @GetMapping
//    public ProductResponse getAllProducts(
//            @RequestParam(value = "page", defaultValue = "0" ,required = false) int page,
//            @RequestParam(value = "linesPerPage", defaultValue = "10", required = false) int linesPerPage,
//            @RequestParam(value = "orderBy",  defaultValue = "id",required = false) String orderBy,
//            @RequestParam(value = "direction",  defaultValue = "asc",required = false) String direction
//    ){
//        return new ResponseEntity<>(serviceIMPL.getAllProducts( page,linesPerPage,orderBy,direction), HttpStatus.OK).getBody();
//    }

    @PostMapping("/creating")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(serviceIMPL.createProduct(productDto), HttpStatus.CREATED);
    }


    @GetMapping("/{productName}")
    public ResponseEntity<ProductDto> findProductByName(ProductDto productDto){
        return new ResponseEntity<>(serviceIMPL.findProductByName(productDto), HttpStatus.OK);
    }

    //    localhost:8082/products/pera
    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return new ResponseEntity<>(serviceIMPL.findAllProducts(), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable(value = "productId") int productId){
        serviceIMPL.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted Successfully",HttpStatus.OK);
    }


//    localhost:8082/products/10
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "productId") int productId, @RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(serviceIMPL.updateProduct(productId,productDto),HttpStatus.OK);
    }



}