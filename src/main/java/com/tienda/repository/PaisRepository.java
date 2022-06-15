/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.repository;

import com.tienda.entity.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joser
 */

@Repository//Se especifica que va a hacer de positorio
public interface PaisRepository extends CrudRepository<Pais,Long> { //se hace ese extens que es para facilitarnos la vida
    
}
