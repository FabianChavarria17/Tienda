/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service.inpl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabia
 */
@Service
public class CategoriaServiceInpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<categoria> getCategorias(boolean activos) {
        List<categoria> lista = categoriaDao.findAll();
        
        //Filtrar los activos 
        if(activos){
            lista.removeIf(cat -> !cat.isActivo());
        }
        return lista;
    }
    
}
