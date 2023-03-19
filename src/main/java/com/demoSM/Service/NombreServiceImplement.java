package com.demoSM.Service;

import com.demoSM.Dao.NombreDao;
import com.demoSM.Model.Nombre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NombreServiceImplement implements NombreService {
    @Autowired
    private NombreDao nombreDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Nombre> findAll()
    {
        return (List<Nombre>) nombreDao.findAll();
    }
    
    @Override
     @Transactional(readOnly=false)
    public Nombre save(Nombre nombre)
    {
        return nombreDao.save(nombre);
    }
    
    @Override
     @Transactional(readOnly=true)
    public Nombre findById(Integer id)
    {
        return nombreDao.findById(id).orElse(null);
    }
    
    @Override
     @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        nombreDao.deleteById(id);
    }
    
}