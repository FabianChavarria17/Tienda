
package com.tienda.dao;

import com.tienda.domain.categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDao extends JpaRepository<categoria, Long>{
    
    List<categoria> findByDescripcion(String descripcion);
    
    
    
}
