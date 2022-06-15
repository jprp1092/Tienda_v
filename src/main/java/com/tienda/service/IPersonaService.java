/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;

/**
 *
 * @author joser
 */
public interface IPersonaService {
    public List<Persona> getAllPersona();//la lista nos guarda elementos persona
    public Persona getPersonaById(long id);//dado un id retorno un objeto tipo persona
    public void savePersona(Persona persona);/*son void porque no devuelve informacion-guardamos una
    nueva fila en nuestra tabla*/
    public void delete(long id);//elimina una fila por id
 }
