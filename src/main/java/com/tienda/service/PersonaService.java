/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joser
 */
@Service//se define que es un servicio
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getAllPersona() {
        return (List<Persona>)personaRepository.findAll();
        //retornamos una lista persona del repositorio persona
    }

    @Override
    public Persona getPersonaById(long id) {
        return personaRepository.findById(id).orElse(null); 
        //retorna una persona por id si no retorna un null
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
        //aca no retornamos solo guardamos la persona
    }

    @Override
    public void delete(long id) {
        personaRepository.deleteById(id);
        //aca no retornamos solo eliminamos por id
    }
    
}
