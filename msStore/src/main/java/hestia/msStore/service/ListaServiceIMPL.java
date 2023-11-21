package hestia.msStore.service;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.payload.ListaDto;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.repository.ListaRepository;
import hestia.msStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        List<ProductDto> productDtos = listaDto.getProducts();
        if (productDtos != null) {
            // Assuming that the setProducts method expects a List<Product>
            lista.setProducts(ClassMapper.INTANCE.dtoProductListToEntityList(productDtos));
        }

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


//    public List<Product> getProductsByName(Product product){
//        if (product != null) {
//            List<Product> existingProducts = productRepository.f
//            if (!existingProducts.isEmpty()) {
//                return existingProducts;
//            } else {
//                throw new ProductAPIException(HttpStatus.BAD_REQUEST, "No products found for the specified category");
//            }
//        } else {
//            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "Category is Null");
//        }
//
//    }



}