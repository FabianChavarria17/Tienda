
package com.tienda.service;

import com.tienda.domain.categoria;
import java.util.List;

/**
 *
 * @author fabia
 */
public interface CategoriaService {
    
    public List<categoria> getCategorias(boolean activos);
    
    
}
