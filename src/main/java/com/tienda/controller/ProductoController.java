/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.domain.categoria;
import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fabia
 */
@Controller
@Slf4j
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService ProductoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var Productos = ProductoService.getProductos(false);
        model.addAttribute("Productos", Productos);
        model.addAttribute("totalProductos", Productos.size());

        List<categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "/roducto/listado";
    }

    @GetMapping("/nuevo")
    public String ProductoNuevo(Producto producto) {
        return "/Producto/modifica";
    }

    @PostMapping("/guardar")
    public String ProductoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            ProductoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "Producto",
                            producto.getIdProducto()));
        }
        ProductoService.save(producto);
        return "redirect:/Producto/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String ProductoEliminar(Producto producto) {
        ProductoService.delete(producto);
        return "redirect:/Producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String ProductoModificar(Producto producto, Model model) {
        producto = ProductoService.getProducto(producto);
        model.addAttribute("Producto", producto);

        List<categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "/Producto/modifica";
    }
}
