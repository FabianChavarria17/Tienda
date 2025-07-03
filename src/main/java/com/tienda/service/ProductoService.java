package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

/**
 *
 * @author fabia
 */
public interface ProductoService {

    // Se obtiene un listado de Productos en un List
    public List<Producto> getProductos(boolean activos);

    // Se obtiene un Producto, a partir del id de un Producto
    public Producto getProducto(Producto producto);

    // Se inserta un nuevo Producto si el id del Producto esta vacío
    // Se actualiza un Producto si el id del Producto NO esta vacío
    public void save(Producto producto);

    // Se elimina el Producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
}
