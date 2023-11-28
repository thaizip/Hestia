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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaServiceIMPL implements ListaService {

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
        Optional<Lista> lista = listaRepository.findAllByListaName(listaName);

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
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        existingList.setListaName(listaDto.getListaName());
        existingList.setData(listaDto.getData());
        listaRepository.save(existingList);
        return ClassMapper.INTANCE.listaToDto(existingList);
    }

    @Override
    public ListaDto addProductsInLista(int listaId, int productId) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        var searchProduct = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", productId));

        existingList.getProducts().add(searchProduct);
        listaRepository.save(existingList);
        return ClassMapper.INTANCE.listaToDto(existingList);
    }


    @Override
    public void deleteListaById(int listaId) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        listaRepository.deleteById(existingList.getListaId());
    }

    @Override
    public void deleteProductInLista(int listaId, int productId) {
        var existingList = listaRepository.findById(listaId).orElseThrow(
                () -> new ResourceNotFoundException("Lista", "id", listaId));

        Product searchProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        existingList.getProducts().remove(searchProduct);
        listaRepository.save(existingList);
    }
}