package com.tienda.service;

import com.tienda.domain.categoria;
import java.util.List;

/**
 *
 * @author fabia
 */
public interface CategoriaService {

    // Se obtiene un listado de categorias en un List
    public List<categoria> getCategorias(boolean activos);

    // Se obtiene un Categoria, a partir del id de un categoria
    public categoria getCategoria(categoria categoria);

    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(categoria categoria);

    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(categoria categoria);
}
