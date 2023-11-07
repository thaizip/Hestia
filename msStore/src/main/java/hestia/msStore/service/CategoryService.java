package hestia.msStore.service;

import hestia.msStore.payload.CategoryDto;
import hestia.msStore.payload.CategoryResponse;
import hestia.msStore.payload.ProductResponse;

import java.util.List;

public interface CategoryService {


    public CategoryResponse getAllCategory(int pageNo, int pageSize, String orderBy, String direction);

    public CategoryDto createCategory(CategoryDto categoryDto);

    public List<CategoryDto> findAllCategories();

}