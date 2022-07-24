/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.repository;

import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joser
 */

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long> {
    Persona findByNombre (String nombre); /*Metodo para buscar persona por nombre, deberia ser por usuario para el login pero por este ejemplo es nombre*/
}
