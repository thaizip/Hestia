package hestia.msStore.service;

import hestia.msStore.model.Category;
import hestia.msStore.payload.CategoryDto;
import hestia.msStore.payload.CategoryResponse;
import hestia.msStore.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceIMPL implements CategoryService{

    private CategoryRepository categoryRepository;

    private ModelMapper mapper;

    @Autowired
    public CategoryServiceIMPL(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public CategoryResponse getAllCategory(int pageNo, int pageSize, String orderBy, String direction) {
        var pageable = PageRequest.of(pageNo,pageSize,
                Sort.by(Sort.Direction.fromString(direction.toLowerCase()),
                        orderBy));

        Page<Category> categoryPage = categoryRepository.findAll(pageable);

        List<CategoryDto> content = categoryPage
                .stream().map(category -> mapper.map(category,CategoryDto.class))
                .collect(Collectors.toList());

        return new CategoryResponse(content,categoryPage.getNumber(),categoryPage.getSize(),
                categoryPage.getTotalElements(),categoryPage.getTotalPages(),categoryPage.isLast());
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto){
        var category = mapper.map(categoryDto, Category.class);
        var newCategory = categoryRepository.save(category);
        return mapper.map(newCategory,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> findAllCategories(CategoryDto categoryDto){
        return categoryRepository.findAll()
                .stream()
                .map(category -> mapper.map(category,CategoryDto.class))
                .collect(Collectors.toList());
    }


}