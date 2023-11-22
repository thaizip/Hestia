package hestia.msStore.service;

import hestia.msStore.config.ClassMapper;
import hestia.msStore.payload.ListaDto;
import hestia.msStore.repository.CategoryRepository;
import hestia.msStore.repository.ListaRepository;
import hestia.msStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//        var products = listaDto.getProducts(lista.setProducts());
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


//    @Override
//    public List<ProductDto> getProductById(ProductDto productDto) {
//        var product = ClassMapper.INTANCE.dtoToProduct(productDto);
//        var existingProducts = productRepository.findById(product.getProductId());
//
//        if (!existingProducts.isEmpty()) {
//            existingProducts = ClassMapper.INTANCE.dtoProductListToEntityList()
//            return existingProducts;
//        } else {
//            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "No products found for the specified IDs");
//        }
//    }



}