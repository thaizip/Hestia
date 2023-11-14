package hestia.msStore.service;

import hestia.msStore.exeptions.ProductAPIException;
import hestia.msStore.model.Category;
import hestia.msStore.config.ClassProductMapper;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceIMPL implements ProductsService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ClassProductMapper mapper;

    @Autowired
    public ProductServiceIMPL(ProductRepository productRepository, CategoryRepository categoryRepository, ClassProductMapper mapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

//    public ProductResponse getAllProducts(int pageNo, int pageSize, String orderBy, String direction) {
//
//        var pageable = PageRequest.of(pageNo,pageSize,
//                Sort.by(Sort.Direction.fromString(direction.toLowerCase()),
//                        orderBy));
//
//        Page<Product> productPage = productRepository.findAll(pageable);
//
//        List<ProductDto> content = productPage
//                .stream().map(product -> mapper.map(product,ProductDto.class))
//                .collect(Collectors.toList());
//
//        return new ProductResponse(content,productPage.getNumber(),productPage.getSize(),
//                productPage.getTotalElements(),productPage.getTotalPages(),productPage.isLast());
//    }

    @Override
    public List<ProductDto> findAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> ClassProductMapper.INTANCE.productToDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findProductByName(ProductDto productDto) {
        var product = ClassProductMapper.INTANCE.dtoToProduct(productDto);
        productRepository.findByProductName(product.getProductName());

        if (product != null){
            return ClassProductMapper.INTANCE.productToDto(product);
        }else {
            throw new ProductAPIException(HttpStatus.NOT_FOUND, "Product not Found");
        }

    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var product = ClassProductMapper.INTANCE.dtoToProduct(productDto);
        var categories = getCategoryById(productDto.getCategories());
        product.setCategory(categories);
        productRepository.save(product);
        return ClassProductMapper.INTANCE.productToDto(product);
    }


    public ProductDto updateProduct(int productId, ProductDto productDto) {
        var search = productRepository.findById(productId);

        if (search.isPresent()) {
            var product = ClassProductMapper.INTANCE.dtoToProduct(productDto);
            var categories = getCategoryById(productDto.getCategories());
            product.setCategory(categories);
            productRepository.save(product);
            return ClassProductMapper.INTANCE.productToDto(product);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Product not found");
        }
    }


    public void deleteProductById(int productId) {
        var search = productRepository.findById(productId);

        if (search.isPresent()){
            productRepository.deleteById(productId);
        }else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Product not Exist");
        }

    }


    @Override
    public Category getCategoryById(Category category) {
        if (category != null) {
            Optional<Category> existingCategory = categoryRepository.findByCategoryName(category.getCategoryName());
            if (existingCategory.isPresent()) {
                return existingCategory.get();
            } else {
                return categoryRepository.save(category);
            }
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Category is Null");
        }
    }

}