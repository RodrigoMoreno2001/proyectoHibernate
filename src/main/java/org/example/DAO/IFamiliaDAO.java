package org.example.DAO;

import org.example.entities.Familia;

import java.util.Set;

public interface IFamiliaDAO {

    void guardarFamilia(Familia familia);
    void borrarFamilia(Familia familia);
    Set<Familia> mostrarFamilias();
    Familia mostrarFamiliaPorId(Integer id);
}
