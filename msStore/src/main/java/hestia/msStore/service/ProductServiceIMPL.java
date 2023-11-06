package hestia.msStore.service;

import hestia.msStore.exeptions.ProductAPIException;
import hestia.msStore.exeptions.ResourceNotFoundException;
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
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper mapper;

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
    public ProductDto createProduct(ProductDto productDto) {
        var existingProduct = productRepository.findByName(productDto.getProductName());
        if (existingProduct != null){
            throw new ProductAPIException(HttpStatus.BAD_REQUEST,"This product name is already registered");
        }

        var categories = getCategoriesByIds(productDto.getCategories());

        var newProduct = mapper.map(productDto, Product.class);
        newProduct.setCategories(categories.stream().map(category -> (Category) category).collect(Collectors.toSet()));

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
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Set<Category> getCategoriesByIds(Set<Category> categories) {
        Set<Category> result = new HashSet<>();

        for (Category category : categories) {
            Category foundCategory = categoryRepository.findById(category.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category", "id", category.getCategoryId()));
            result.add(foundCategory);
        }
        return result;
    }


}