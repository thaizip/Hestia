package hestia.msStore.service;

import hestia.msStore.model.Product;
import hestia.msStore.payload.ListaDto;
import hestia.msStore.payload.ProductDto;

import java.util.List;

public interface ListaService {

    public ListaDto findAllListas();

    public ListaDto createLista(ListaDto listaDto);

    public ListaDto updateLista(int listaId, ListaDto listaDto);

    public void deleteListaById(int listaId);

//    public List<ProductDto> getProductById(ProductDto productDto);

}