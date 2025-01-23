package org.example.DAO;

import org.example.entities.Animal;
import org.example.entities.Familia;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;
/**
 * Implementación de la interfaz {@link IAnimalDAO} que proporciona métodos para realizar operaciones CRUD
 * sobre los objetos {@link Animal} en la base de datos utilizando Hibernate.
 *
 * Esta clase se encarga de guardar, modificar, borrar y recuperar animales desde la base de datos.
 * Las operaciones de lectura son proporcionadas por los métodos para obtener todos los animales,
 * los animales por especie y los animales adoptados.
 *
 * @see IAnimalDAO
 * @see Animal
 * @see HibernateUtil
 */
public class AnimalDAO implements IAnimalDAO {

    /**
     * Guarda un nuevo animal en la base de datos.
     *
     * Si el objeto {@code animal} es {@code null}, no se realiza ninguna operación.
     *
     * @param animal El objeto {@link Animal} que se desea guardar.
     */

    @Override
    public void guardarAnimal(Animal animal) {

        if(animal == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(animal);
        session.getTransaction().commit();
        session.close();
    }


    /**
     * Modifica un animal existente en la base de datos.
     *
     * Si el objeto {@code animal} es {@code null}, no se realiza ninguna operación.
     *
     * @param animal El objeto {@link Animal} que se desea modificar.
     */

    @Override
    public void modificarAnimal(Animal animal) {

        if(animal == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(animal);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Borra un animal de la base de datos.
     *
     * Si el objeto {@code animal} es {@code null}, no se realiza ninguna operación.
     *
     * @param animal El objeto {@link Animal} que se desea eliminar.
     */

    @Override
    public void borrarAnimal(Animal animal) {

        if(animal == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(animal);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Recupera todos los animales de la base de datos.
     *
     * Este metodo ejecuta una consulta HQL para obtener todos los animales y los devuelve en un conjunto {@link Set}.
     *
     * @return Un conjunto de objetos {@link Animal} que representa todos los animales almacenados en la base de datos.
     */

    @Override
    public Set<Animal> mostrarAnimales() {
        Set<Animal> animales = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            animales = new HashSet<>(session.createQuery("from Animal", Animal.class).getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animales;
    }

    /**
     * Recupera todos los animales de la base de datos que pertenecen a una especie específica.
     *
     * Este metodo ejecuta una consulta HQL filtrando por la propiedad especie del animal.
     *
     * @param especie El nombre de la especie que se busca.
     * @return Un conjunto de objetos {@link Animal} que pertenecen a la especie indicada.
     */


    @Override
    public Set<Animal> mostrarAnimalesPorEspecie(String especie) {
        Set<Animal> animales = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            animales = new HashSet<>(
                    session.createQuery("from Animal where especie = :especie", Animal.class)
                    .setParameter("especie",especie)
                    .getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animales;
    }

    /**
     * Recupera todos los animales adoptados, es decir, aquellos que tienen asignada una familia.
     *
     * Este metodo ejecuta una consulta HQL para obtener los animales que tienen la propiedad {@code familia} no {@code null}.
     *
     * @return Un conjunto de objetos {@link Animal} que han sido adoptados.
     */

    @Override
    public Set<Animal> mostrarAnimalesAdoptados() {
        Set<Animal> animales = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            animales = new HashSet<>(session.createQuery("from Animal where familia is not null", Animal.class).getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animales;
    }
}
