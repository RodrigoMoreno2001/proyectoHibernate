package org.example.DAO;

import org.example.entities.Familia;
import java.util.Set;

/**
 * Interfaz que define los metodos necesarios para realizar operaciones CRUD sobre los objetos {@link Familia}.
 *
 * Esta interfaz proporciona metodos para guardar, borrar y recuperar familias desde la base de datos.
 * Además, incluye un metodo para obtener una familia por su {@code id}.
 *
 * @see Familia
 */
public interface IFamiliaDAO {

    /**
     * Guarda una nueva familia en la base de datos.
     *
     * Este metodo es responsable de persistir un objeto {@link Familia} en la base de datos.
     * Si el objeto {@code familia} es {@code null}, el metodo no realiza ninguna operación.
     *
     * @param familia El objeto {@link Familia} que se desea guardar en la base de datos.
     */
    void guardarFamilia(Familia familia);

    /**
     * Borra una familia de la base de datos.
     *
     * Este metodo elimina un objeto {@link Familia} de la base de datos. Si el objeto {@code familia} es 
     * {@code null}, no se realiza ninguna operación.
     *
     * @param familia El objeto {@link Familia} que se desea eliminar.
     */
    void borrarFamilia(Familia familia);

    /**
     * Recupera todas las familias de la base de datos.
     *
     * Este metodo obtiene todos los objetos {@link Familia} almacenados en la base de datos.
     *
     * @return Un conjunto de objetos {@link Familia} que representa todas las familias almacenadas en la base de datos.
     */
    Set<Familia> mostrarFamilias();

    /**
     * Recupera una familia de la base de datos utilizando su {@code id}.
     *
     * Este metodo obtiene la familia cuyo {@code id} coincide con el parámetro proporcionado.
     * Si no se encuentra ninguna familia con el {@code id} especificado, puede lanzar una excepción.
     *
     * @param id El {@code id} de la familia que se busca.
     * @return Un objeto {@link Familia} correspondiente al {@code id} proporcionado.
     */
    Familia mostrarFamiliaPorId(Integer id);
}
