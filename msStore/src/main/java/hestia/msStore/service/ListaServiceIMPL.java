package hestia.msStore.service;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.exeptions.ProductAPIException;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ListaDto;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.repository.ListaRepository;
import hestia.msStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaServiceIMPL implements ListaService{

    private final ListaRepository listaRepository;

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final ClassMapper mapper;


    @Autowired
    public ListaServiceIMPL(ListaRepository listaRepository, ProductRepository productRepository, CategoryRepository categoryRepository, ClassMapper mapper) {
        this.listaRepository = listaRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public ListaDto findAllListas() {
        return null;
    }

    @Override
    public ListaDto createLista(ListaDto listaDto) {
        var lista = ClassMapper.INTANCE.dtoToLista(listaDto);
        var products = getProductById(listaDto.getProducts());
        lista.setProducts(products);
        listaRepository.save(lista);
        return ClassMapper.INTANCE.listaToDto(lista);
    }

    @Override
    public ListaDto updateLista(int listaId, ListaDto listaDto) {
        return null;
    }

    @Override
    public void deleteListaById(int listaId) {

    }


    public List<Product> getProductById(List<ProductDto> productDtos) {
        var existingProducts = productRepository.findAllById(productIds);

        if (!existingProducts.isEmpty()) {
            return existingProducts;
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "No products found for the specified IDs");
        }
    }



}