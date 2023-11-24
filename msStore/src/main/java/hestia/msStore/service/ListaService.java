package hestia.msStore.service;

import hestia.msStore.payload.ListaDto;
import hestia.msStore.payload.ProductDto;

import java.util.List;

public interface ListaService {

    public List<ListaDto> findAllListas();
    public List<ListaDto> findAllListaByName(String listaName);

    public ListaDto createLista(ListaDto listaDto);

    public ListaDto updateLista(int listaId, ListaDto listaDto);

    public ListaDto addProductsInLista(int listaId, ListaDto listaDto);

    public void deleteListaById(int listaId);

    public ProductDto getProductById(ProductDto productDto);

}