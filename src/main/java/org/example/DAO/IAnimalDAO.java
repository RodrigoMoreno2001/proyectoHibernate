package org.example.DAO;

import org.example.entities.Animal;

import java.util.Set;

/**
 * Interfaz que define los metodos necesarios para realizar operaciones CRUD sobre los objetos {@link Animal}.
 *
 * Esta interfaz proporciona metodos para guardar, modificar, borrar y recuperar animales desde la base de datos.
 * Además, incluye metodos para obtener animales por especie y para obtener animales adoptados.
 *
 * @see Animal
 */
public interface IAnimalDAO {

    /**
     * Guarda un nuevo animal en la base de datos.
     *
     * Este metodo es responsable de persistir un objeto {@link Animal} en la base de datos.
     * Si el objeto {@code animal} es {@code null}, el metodo no realiza ninguna operación.
     *
     * @param animal El objeto {@link Animal} que se desea guardar en la base de datos.
     */
    void guardarAnimal(Animal animal);

    /**
     * Modifica un animal existente en la base de datos.
     *
     * Este metodo actualiza los datos de un objeto {@link Animal} en la base de datos. Si el objeto 
     * {@code animal} es {@code null}, el metodo no realiza ninguna operación.
     *
     * @param animal El objeto {@link Animal} que se desea modificar.
     */
    void modificarAnimal(Animal animal);

    /**
     * Borra un animal de la base de datos.
     *
     * Este metodo elimina un objeto {@link Animal} de la base de datos. Si el objeto {@code animal} es 
     * {@code null}, no se realiza ninguna operación.
     *
     * @param animal El objeto {@link Animal} que se desea eliminar.
     */
    void borrarAnimal(Animal animal);

    /**
     * Recupera todos los animales de la base de datos.
     *
     * Este metodo obtiene todos los objetos {@link Animal} almacenados en la base de datos.
     *
     * @return Un conjunto de objetos {@link Animal} que representa todos los animales almacenados en la base de datos.
     */
    Set<Animal> mostrarAnimales();

    /**
     * Recupera todos los animales de una especie específica.
     *
     * Este metodo obtiene todos los objetos {@link Animal} que pertenecen a la especie indicada. Utiliza el 
     * parámetro {@code especie} para filtrar los resultados.
     *
     * @param especie El nombre de la especie que se busca.
     * @return Un conjunto de objetos {@link Animal} que pertenecen a la especie indicada.
     */
    Set<Animal> mostrarAnimalesPorEspecie(String especie);

    /**
     * Recupera todos los animales adoptados, es decir, aquellos que tienen asignada una familia.
     *
     * Este metodo obtiene todos los objetos {@link Animal} que tienen una familia asociada en la base de datos,
     * considerándolos como adoptados.
     *
     * @return Un conjunto de objetos {@link Animal} que han sido adoptados (aquellos con una familia asignada).
     */
    Set<Animal> mostrarAnimalesAdoptados();
}