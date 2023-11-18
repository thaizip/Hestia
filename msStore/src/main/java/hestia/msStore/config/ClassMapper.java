package hestia.msStore.config;

import hestia.msStore.model.Product;
import hestia.msStore.payload.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    public static final ClassMapper INTANCE = Mappers.getMapper(ClassMapper.class);

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

}