package hestia.msStore.service;

import hestia.msStore.exeptions.ProductAPIException;
import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.payload.ProductResponse;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceIMPL implements ProductsService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    @Autowired
    public ProductServiceIMPL(ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductResponse getAllProducts(int pageNo, int pageSize, String orderBy, String direction) {

        var pageable = PageRequest.of(pageNo,pageSize,
                Sort.by(Sort.Direction.fromString(direction.toLowerCase()),
                        orderBy));

        Page<Product> productPage = productRepository.findAll(pageable);

        List<ProductDto> content = productPage
                .stream().map(product -> mapper.map(product,ProductDto.class))
                .collect(Collectors.toList());

        return new ProductResponse(content,productPage.getNumber(),productPage.getSize(),
                productPage.getTotalElements(),productPage.getTotalPages(),productPage.isLast());
    }

    @Override
    public ProductDto getProductById(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return mapper.map(product, ProductDto.class);
        } else {
            throw new EntityNotFoundException("Person with ID " + productId + " not found");
        }
    }

    @Override
    public ProductDto createProduct(ProductDto productDto, Integer categoryId) {

        var categories = getCategoryById(productDto.getCategories());

        var newProduct = mapper.map(productDto, Product.class);
        newProduct.setCategory(categories.stream().map(category -> (Category) category).collect(Collectors.toSet()));

        newProduct = productRepository.save(newProduct);
        return mapper.map(newProduct, ProductDto.class);

    }


    @Override
    public ProductDto updateProduct(int productId, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            mapper.map(productDto, product);
            productRepository.save(product);
            return mapper.map(product, ProductDto.class);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Product not found");
        }
    }

    @Override
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }


    @Override
    public Set<Category> getCategoryById(Set<Category> categories) {
        if (categories != null) {
            return categories.stream()
                    .filter(category -> category.getCategoryId() == category.getCategoryId())
                    .collect(Collectors.toSet());
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Category is Null");
        }
    }

}