package com.demoSM.Service;

import com.demoSM.Model.Nombre;
import java.util.List;

public interface NombreService {
    public List<Nombre> findAll();
    public Nombre save(Nombre tarea);
    public Nombre findById(Integer id);
    public void delete(Integer id);
    
}
