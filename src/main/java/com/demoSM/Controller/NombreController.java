package com.demoSM.Controller;

import com.demoSM.Model.Nombre;
import com.demoSM.Service.NombreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/api")
public class NombreController {
    @Autowired
    private NombreService nombreService;
    
    //listar
    @GetMapping("/nombres")
    public List<Nombre> listar()
    {
        return nombreService.findAll();
    }
    
    //guardar
    @PostMapping("/nombres")
    public  Nombre guardar(@RequestBody Nombre nombre)
    {
        return nombreService.save(nombre);
    }
    
    //get una tarea
    @GetMapping("/nombres/{id}")
    public Nombre getUnNombre(@PathVariable Integer id)
    {
        return nombreService.findById(id);
    }
    
    //Modeficar
    @PutMapping("/nombres/{id}")
    public Nombre modificar(@RequestBody Nombre nombre,@PathVariable Integer id)
    {
        Nombre nombreActual= nombreService.findById(id);
        nombreActual.setNombre(nombre.getNombre());

        return nombreService.save(nombreActual);
    }
    
    @DeleteMapping("/nombres/{id}")
    public void eliminar(@PathVariable Integer id)
    {
        nombreService.delete(id);
    }
    
}
