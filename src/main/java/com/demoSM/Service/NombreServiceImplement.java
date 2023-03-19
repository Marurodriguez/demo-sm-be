package com.demoSM.Service;

import com.demoSM.Repository.NombreRepository;
import com.demoSM.Model.Nombre;
import java.util.List;

import com.demoSM.Repository.NombreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NombreServiceImplement implements NombreService {
    @Autowired
    private NombreRepository nombreRepository;
    
    @Override
    @Transactional(readOnly=true)
    public List<Nombre> findAll()
    {
        return (List<Nombre>) nombreRepository.findAll();
    }
    
    @Override
     @Transactional(readOnly=false)
    public Nombre save(Nombre nombre)
    {
        return nombreRepository.save(nombre);
    }
    
    @Override
     @Transactional(readOnly=true)
    public Nombre findById(Integer id)
    {
        return nombreRepository.findById(id).orElse(null);
    }
    
    @Override
     @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        nombreRepository.deleteById(id);
    }
    
}