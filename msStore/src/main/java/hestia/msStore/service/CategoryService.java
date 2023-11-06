package hestia.msStore.service;

import hestia.msStore.model.Category;
import hestia.msStore.payload.CategoryDto;
import hestia.msStore.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    private ModelMapper mapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public CategoryDto createCategory(CategoryDto categoryDto){
        var category = mapper.map(categoryDto, Category.class);
        var newCategory = categoryRepository.save(category);
        return mapper.map(newCategory,CategoryDto.class);
    }

    public List<CategoryDto> findAllCategories(){
        return categoryRepository.findAll()
                .stream()
                .map(category -> mapper.map(category,CategoryDto.class))
                .collect(Collectors.toList());
    }





}