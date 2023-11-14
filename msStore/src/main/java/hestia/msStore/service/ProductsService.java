package hestia.msStore.service;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.payload.CategoryDto;
import hestia.msStore.payload.ProductDto;

import java.util.List;
import java.util.Set;


public interface ProductsService {


//    public ProductResponse getAllProducts(int pageNo, int pageSize, String orderBy, String direction);
//
    public List<ProductDto> findAllProducts();

    public ProductDto findProductByName(ProductDto productDto);

    public ProductDto createProduct(ProductDto productDto);

//    public ProductDto updateProduct(int productId, ProductDto productDto);

    public void deleteProductById(int productId);

    public Category getCategoryById(Category category);
}