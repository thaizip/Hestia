package hestia.msStore.config;

import hestia.msStore.model.Category;
import hestia.msStore.model.Product;
import hestia.msStore.payload.CategoryDto;
import hestia.msStore.payload.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassProductMapper {

    public static final ClassProductMapper INTANCE = Mappers.getMapper(ClassProductMapper.class);

    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imgUrl", target = "imgUrl")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "category", target = "categories")
    ProductDto productToDto(Product product);

    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imgUrl", target = "imgUrl")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "categories", target = "category")
    Product dtoToProduct(ProductDto productDto);

    Category dtoToCategory(CategoryDto categoryDto);
}