/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joser
 */
@Controller//definimos que es tipo controller
public class PersonaController {
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/persona")//cuando se llame a /persona va a realizar todo lo de abajo
    public String index (Model model){//model permite pasar informacion al html de personas
        List<Persona> listaPersona = personaService.getAllPersona();//pasamos toda la lista personas al html
        model.addAttribute("titulo","Tabla Personas");/*donde en el html encuentre "titulo" lo va a sustituir por 
        "Tabla Persona" */
        model.addAttribute("personas",listaPersona);/*donde en el html encuentre "personas" lo va a sustituir por 
        listaPersona (line 26) */
        return "persona";//devolvera un objeto de tipo string personas
    }
    
}
