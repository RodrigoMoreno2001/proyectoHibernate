package org.example.DAO;

import org.example.entities.Animal;
import org.example.entities.Familia;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class AnimalDAO implements IAnimalDAO {
    @Override
    public void guardarAnimal(Animal animal) {

        if(animal == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(animal);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarAnimal(Animal animal) {

        if(animal == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(animal);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void borrarAnimal(Animal animal) {

        if(animal == null) return;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(animal);
        session.getTransaction().commit();
        session.close();
    }

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
}
