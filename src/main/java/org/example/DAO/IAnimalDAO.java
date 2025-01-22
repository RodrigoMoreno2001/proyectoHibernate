package org.example.DAO;

import org.example.entities.Animal;

import java.util.Set;

public interface IAnimalDAO {
    void guardarAnimal(Animal animal);
    void modificarAnimal(Animal animal);
    void borrarAnimal(Animal animal);
    Set<Animal> mostrarAnimales();
    Set<Animal> mostrarAnimalesPorEspecie(String especie);
}
