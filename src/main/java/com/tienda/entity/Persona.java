/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joser
 */

@Entity //aca se define que la clase persona va a hacer un entidad
@Table(name="personas")//referenciamos como se llama la tabla en la base de datos
public class Persona implements Serializable{
    @Id //Se escribe el primarykey de la tabla
    @GeneratedValue(strategy= GenerationType.IDENTITY)//enla base de datos definimos que id es auto incrementable por lo tanto tambien hay que definir ese comportamiento aca 
    private long id;
    //se agrega los demas atributos de la tabla
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    //Definir el foreing key existente en la tabla
    @ManyToOne//se definine la relacion
    @JoinColumn(name="paises_id")//referenciamos la columna pertenciente al foreing key
    private Pais pais; //Variable que apunta a la otra tabla

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
}
