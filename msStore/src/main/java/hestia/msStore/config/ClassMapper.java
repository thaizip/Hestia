package hestia.msStore.config;

import hestia.msStore.model.Lista;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ListaDto;
import hestia.msStore.payload.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassMapper {


    ClassMapper INTANCE = Mappers.getMapper(ClassMapper.class);

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

    List<ProductDto> productListToDtoList(List<Product> products);

    List<Product> dtoProductListToEntityList(List<ProductDto> productDtos);

    ListaDto listaToDto(Lista lista);

    Lista dtoToLista(ListaDto listaDto);

}