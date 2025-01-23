package org.example.DAO;

import org.example.entities.Familia;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementación de la interfaz {@link IFamiliaDAO} que proporciona métodos para realizar operaciones CRUD
 * sobre los objetos {@link Familia} en la base de datos utilizando Hibernate.
 *
 * Esta clase se encarga de guardar, borrar y recuperar familias desde la base de datos.
 * Las operaciones de lectura incluyen obtener todas las familias o una familia por su {@code id}.
 *
 * @see IFamiliaDAO
 * @see Familia
 * @see HibernateUtil
 */
public class FamiliaDAO implements IFamiliaDAO{

    /**
     * Guarda una nueva familia en la base de datos.
     *
     * Si el objeto {@code familia} es {@code null}, no se realiza ninguna operación.
     *
     * @param familia El objeto {@link Familia} que se desea guardar.
     */

    @Override
    public void guardarFamilia(Familia familia) {

        if(familia == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(familia);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Borra una familia de la base de datos.
     *
     * Si el objeto {@code familia} es {@code null}, no se realiza ninguna operación.
     *
     * @param familia El objeto {@link Familia} que se desea eliminar.
     */

    @Override
    public void borrarFamilia(Familia familia) {

        if(familia == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(familia);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Recupera todas las familias de la base de datos.
     *
     * Este metodo ejecuta una consulta HQL para obtener todas las familias y las devuelve en un conjunto {@link Set}.
     *
     * @return Un conjunto de objetos {@link Familia} que representa todas las familias almacenadas en la base de datos.
     */

    @Override
    public Set<Familia> mostrarFamilias() {
        Set<Familia> familias = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            familias = new HashSet<>(session.createQuery("from Familia", Familia.class).getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return familias;
    }


    /**
     * Recupera una familia de la base de datos utilizando su id.
     *
     * Este metodo ejecuta una consulta HQL para obtener la familia cuyo id coincide con el parámetro proporcionado.
     * Si no se encuentra ninguna familia con el id especificado, puede lanzar una excepción.
     *
     * @param id El id de la familia que se busca.
     * @return Un objeto {@link Familia} correspondiente al id proporcionado.
     */

    @Override
    public Familia mostrarFamiliaPorId(Integer id) {

        Familia familia;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            familia = session.createQuery("from Familia where id = :id", Familia.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }

        return familia;
    }
}
