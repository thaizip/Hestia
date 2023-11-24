package hestia.msStore.service;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.exeptions.ProductAPIException;
import hestia.msStore.exeptions.ResourceNotFoundException;
import hestia.msStore.model.Lista;
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
    public List<ListaDto> findAllListas() {
        return listaRepository.findAll()
                .stream()
                .map(ClassMapper.INTANCE::listaToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListaDto> findAllListaByName(String listaName) {
        List<Lista> lista = listaRepository.findAllByListaName(listaName);

        if (lista.isEmpty()) {
            throw new ResourceNotFoundException("No Lista found with name: " + listaName);
        }

        return lista.stream()
                .map(ClassMapper.INTANCE::listaToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ListaDto createLista(ListaDto listaDto) {
        var lista = ClassMapper.INTANCE.dtoToLista(listaDto);
        listaRepository.save(lista);
        return ClassMapper.INTANCE.listaToDto(lista);
    }

    @Override
    public ListaDto updateLista(int listaId, ListaDto listaDto) {
        var search = listaRepository.findById(listaId);

        if (search.isPresent()) {
            var lista = ClassMapper.INTANCE.dtoToLista(listaDto);
            listaRepository.save(lista);
            return ClassMapper.INTANCE.listaToDto(lista);
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Lista not found");
        }
    }

    @Override
    public ListaDto addProductsInLista(int listaId, ListaDto listaDto) {
//        var search = listaRepository.findById(listaId);
//
//        if (search.isPresent()) {
//            var lista = ClassMapper.INTANCE.dtoToLista(listaDto);
//            var product = getProductById(listaDto.getProducts());
//            product.setCategory(categories);
//            productRepository.save(product);
//            return ClassMapper.INTANCE.listaToDto(lista);
//        } else {
//            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Lista not found");
//        }
//        
        return null;
    }

    @Override
    public void deleteListaById(int listaId) {

    }

    @Override
    public ProductDto getProductById(ProductDto productDto) {
        var product = ClassMapper.INTANCE.dtoToProduct(productDto);

        if (product != null) {
            var existingProducts = productRepository.findById(product.getProductId());
            if (!existingProducts.isEmpty()) {
                var productOK = ClassMapper.INTANCE.productToDto(product);
                return productOK;
            } else {
                throw new ProductAPIException(HttpStatus.BAD_REQUEST, "No products found for the specified category");
            }
        } else {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Category is Null");
        }
    }

}