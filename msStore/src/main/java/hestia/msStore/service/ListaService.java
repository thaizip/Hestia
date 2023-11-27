package hestia.msStore.service;

import hestia.msStore.payload.ListaDto;

import java.util.List;

public interface ListaService {

    public List<ListaDto> findAllListas();
    public List<ListaDto> findAllListaByName(String listaName);

    public ListaDto createLista(ListaDto listaDto);

    public ListaDto updateLista(int listaId, ListaDto listaDto);

    public ListaDto addProductsInLista(int listaId, int productId);

    public void deleteListaById(int listaId);

    public void deleteProductInLista(int listaId, int productId);

}