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
    public ProductDto getProductByName(String productName) {

        if (productName != null && !productName.isEmpty()) {
            Product product = productRepository.findByProductName(productName);

            if (product != null) {
                // Map the Product entity to a ProductDto using your mapper
                return ClassProductMapper.INTANCE.productToDto(product);
            } else {
                throw new ProductAPIException(HttpStatus.NOT_FOUND, "Product Not Found");
            }
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Product Name is Null or Empty");
        }


        // For illustration purposes, let's assume there's a method like getProductByName in your service


        //        if (product != null) {
//            Product existingProduct = productRepository.findByProductName(product.getProductName());
//            if (existingProduct.isPresent()) {
//                return existingProduct.get();
//            } else {
//                // If the product does not exist, you might want to throw an exception or handle it accordingly
//                throw new ProductAPIException(HttpStatus.NOT_FOUND, "Product not found");
//            }
//        } else {
//            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Product is Null");
//        }


//        var existingProduct = productRepository.findByProductName(productName);
//        if (existingProduct != null){
//            throw new ProductAPIException(HttpStatus.BAD_REQUEST,"This product name is already registered");
//        }
//
//        if (existingProduct.isPresent) {
//            Product product = existingProduct.get();
//            return ClassProductMapper.INTANCE.productToDto(product);
//        } else {
//            throw new EntityNotFoundException("Person with ID " + productId + " not found");
//        }
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var product = ClassProductMapper.INTANCE.dtoToProduct(productDto);
        var categories = getCategoryById(productDto.getCategories());
        product.setCategory(categories);
        productRepository.save(product);
        return ClassProductMapper.INTANCE.productToDto(product);
    }


//    public ProductDto updateProduct(int productId, ProductDto productDto) {
//        Optional<Product> productOptional = productRepository.findById(productId);
//
//        if (productOptional.isPresent()) {
//            Product product = productOptional.get();
//            mapper.map(productDto, product);
//            productRepository.save(product);
//            return mapper.map(product, ProductDto.class);
//        } else {
//            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Product not found");
//        }
//    }


    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
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