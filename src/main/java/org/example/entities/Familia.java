package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;
/**
 * Clase que representa a una familia en el sistema.
 * Contiene información sobre el identificador único, nombre, edad, ciudad y los animales que pertenecen a la familia.
 */
@Entity
@Table(name = "Familia")
public class Familia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    private String nombre;
    private Integer edad;
    private String ciudad;

    @OneToMany(mappedBy = "familia", fetch = FetchType.EAGER)
    private Set<Animal> animales;
    /**
     * Constructor vacío para Hibernate.
     */
    public Familia() {}

    /**
     * Constructor para crear una instancia de Familia con los valores especificados.
     *
     * @param id El identificador único de la familia.
     * @param nombre El nombre de la familia.
     * @param edad La edad de la familia (posiblemente el rango de edad de los miembros).
     * @param ciudad La ciudad en la que reside la familia.
     */

    public Familia(Integer id,String nombre, Integer edad, String ciudad) {
        this.id=id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        animales=null;
    }

    /**
     * Obtiene el identificador único de la familia.
     *
     * @return El identificador único de la familia.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único de la familia.
     *
     * @param id El identificador único a establecer.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la familia.
     *
     * @return El nombre de la familia.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la familia.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad de la familia (por ejemplo, el rango de edad de los miembros).
     *
     * @return La edad de la familia.
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la familia.
     *
     * @param edad La edad a establecer.
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la ciudad en la que reside la familia.
     *
     * @return La ciudad en la que reside la familia.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad en la que reside la familia.
     *
     * @param ciudad La ciudad a establecer.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el conjunto de animales que pertenecen a esta familia.
     *
     * @return Un conjunto de animales de la familia.
     */
    public Set<Animal> getAnimales() {
        return animales;
    }

    /**
     * Establece el conjunto de animales que pertenecen a esta familia.
     *
     * @param animales El conjunto de animales a establecer.
     */
    public void setAnimales(Set<Animal> animales) {
        this.animales = animales;
    }

    /**
     * Devuelve una representación en cadena de la familia.
     * La cadena incluye el identificador, nombre, edad, ciudad y el número de animales asociados a la familia.
     *
     * @return Una cadena representando la familia.
     */
    @Override
    public String toString() {
        // Si animales no es nulo ni vacío, se obtiene su tamaño
        if (animales != null || !animales.isEmpty()) {
            animales.size();
        }

        return "Familia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                ", animales=" + (animales != null ? animales.size() : 0) +
                "}\n";
    }

}
