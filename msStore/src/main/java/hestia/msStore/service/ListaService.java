package hestia.msStore.service;

import hestia.msStore.payload.ListaDto;

public interface ListaService {

    public ListaDto findAllListas();

    public ListaDto createLista(ListaDto listaDto);

    public ListaDto updateLista(int listaId, ListaDto listaDto);

    public void deleteListaById(int listaId);


}