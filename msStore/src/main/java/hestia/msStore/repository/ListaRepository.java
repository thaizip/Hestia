package hestia.msStore.repository;

import hestia.msStore.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaRepository extends JpaRepository<Lista, Integer> {
    List<Lista> findAllByListaName(String listaName);
}
