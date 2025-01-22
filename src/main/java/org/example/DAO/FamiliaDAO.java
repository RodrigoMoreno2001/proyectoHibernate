package org.example.DAO;

import org.example.entities.Familia;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class FamiliaDAO implements IFamiliaDAO{
    @Override
    public void guardarFamilia(Familia familia) {

        if(familia == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(familia);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void borrarFamilia(Familia familia) {

        if(familia == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(familia);
        session.getTransaction().commit();
        session.close();
    }

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

    @Override
    public Familia mostrarFamiliaPorId(Integer id) {

        Familia familia;

        Session session = HibernateUtil.getSessionFactory().openSession();

        familia = session.createQuery("from Familia where id = :id", Familia.class)
                .setParameter("id", id)
                .getSingleResult();

        return familia;
    }
}
