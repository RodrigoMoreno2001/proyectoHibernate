package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

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

    public Familia() {}
    
    public Familia(Integer id,String nombre, Integer edad, String ciudad) {
        this.id=id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        animales=null;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getEdad() {
        return edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Set<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(Set<Animal> animales) {
        this.animales = animales;
    }

    @Override
    public String toString() {

        if(animales != null||animales.isEmpty()) {
            animales.size();
        }

        return "Familia" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                ", animales=" + (animales != null ? animales.size() : 0) +
                "\n";
    }

}
