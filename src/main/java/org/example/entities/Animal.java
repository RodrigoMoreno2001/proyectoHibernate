package org.example.entities;

import jakarta.persistence.*;
/**
 * Clase que representa a un animal en el sistema.
 * Contiene información sobre su identificación, nombre, especie, edad, descripción, estado y la familia a la que pertenece
 * Si la familia es {@code null}, significa que no está adoptado.
 */
@Entity
@Table(name = "Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String especie;

    private Integer edad;

    private String descripcion;
    
    private String estado;

    @ManyToOne
    @JoinColumn(name = "familia_id")
    private Familia familia;
    /**
     * Constructor vacío para Hibernate.
     */
    public Animal() {}

    /**
     * Constructor para crear una instancia de Animal con los valores especificados.
     *
     * @param id El identificador único del animal.
     * @param nombre El nombre del animal.
     * @param especie La especie del animal.
     * @param edad La edad del animal.
     * @param descripcion Una descripción del animal.
     * @param estado El estado del animal.
     * @param familia La familia a la que pertenece el animal.
     */

    public Animal(Integer id, String nombre, String especie, Integer edad, String descripcion, String estado, Familia familia) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.familia = familia;
    }

    /**
     * Obtiene el identificador único del animal.
     *
     * @return El identificador único del animal.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del animal.
     *
     * @param id El identificador único a establecer.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del animal.
     *
     * @return El nombre del animal.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del animal.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la especie del animal.
     *
     * @return La especie del animal.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Establece la especie del animal.
     *
     * @param especie La especie a establecer.
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Obtiene la edad del animal.
     *
     * @return La edad del animal.
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Establece la edad del animal.
     *
     * @param edad La edad a establecer.
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la descripción del animal.
     *
     * @return La descripción del animal.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del animal.
     *
     * @param descripcion La descripción a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el estado del animal.
     *
     * @return El estado del animal (por ejemplo, activo, en recuperación, etc.).
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del animal.
     *
     * @param estado El estado a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la familia a la que pertenece el animal.
     *
     * @return La familia del animal.
     */
    public Familia getFamilia() {
        return familia;
    }

    /**
     * Establece la familia a la que pertenece el animal.
     *
     * @param familia La familia a establecer.
     */
    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    /**
     * Devuelve una representación en cadena del objeto Animal.
     * La cadena incluye el identificador, nombre, especie, edad, descripción, estado y familia.
     *
     * @return Una cadena representando al animal.
     */
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", familia=" + (familia != null ? familia.getId() : null) +
                '}';
    }

}
