/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.ClienteReportService;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author joser
 */
@Controller//definimos que es tipo controller
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPaisService paisService;
    
    @Autowired
    private ClienteReportService clienteReportService;

    //Metodo que arrastra los datos de base de datos al htnml
    @GetMapping("/persona")//cuando se usa ese url pasa lo de abajo
    public String index(Model model) {//model permite pasar informacion a un html
        List<Persona> listaPersona = personaService.getAllPersona();//pasamos toda la lista personas al html
        model.addAttribute("titulo", "Tabla Personas");/*donde en el html encuentre "titulo" lo va a sustituir por 
        "Tabla Persona" */
        model.addAttribute("personas", listaPersona);/*donde en el html encuentre "personas" lo va a sustituir por 
        listaPersona (line 26) */
        return "persona";//devolvera html persona
    }

    //Metodo que crear una nueva persona
    @GetMapping("/personaN")//cuando se usa ese url pasa lo de abajo
    public String crearPersona(Model model) {//model permite pasar informacion a un html
        List<Pais> listaPaises = paisService.listCountry();//pasamos toda la lista pais al html
        model.addAttribute("persona", new Persona());//creamos un objeto nuevo tipo persona para poder crear la fila
        model.addAttribute("paises", listaPaises);/*donde en el html encuentre "paises" lo va a sustituir por 
        listaPaises (line 41) esto para poder hacer el dropdowm*/
        return "crear";//devolvera html crear
    }

    //Metodo que guardar la nueva persona y su info
    @PostMapping("/save")//cuando se usa ese url pasa lo de abajo
    public String guardarPersona(@ModelAttribute Persona persona) {//enviar informacion a mi metodo 
        personaService.savePersona(persona);//asi lo guardo en la base de datos
        return "redirect:/persona";//redirige a persona
    }

    //Metodo que edita
    @GetMapping("/editPersona/{id}")//cuando se usa ese url pasa lo de abajo y le estoy especificando que quiero edutar por el id
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {//enviar informacion a mi metodo 
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", persona);//ya no creamos el objeto por que el objeto lo creamos en la linea 64
        model.addAttribute("paises", listaPaises);
        return "crear";//redirige a persona
    }

    //Metodo que elimina
    @GetMapping("/delete/{id}")//cuando se usa ese url pasa lo de abajo y le estoy especificando que quiero edutar por el id
    public String eliminarPersona(@PathVariable("id") Long idPersona) {//enviar informacion a mi metodo 
        personaService.delete(idPersona);
        return "redirect:/persona";//redirige a persona
    }
    
    @GetMapping(value = "/ReporteClientes", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(clienteReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
