package hestia.msStore.service;

import hestia.msStore.model.Category;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.payload.ProductResponse;

import java.util.Set;


public interface ProductsService {


    public ProductResponse getAllProducts(int pageNo, int pageSize, String orderBy, String direction);

    public ProductDto getProductById(int productId);

    public ProductDto createProduct(ProductDto productDto);

    public ProductDto updateProduct(int productId, ProductDto productDto);

    public void deleteProductById(int productId);

    public Set<Category> getCategoriesByIds(Set<Category> categories);
}