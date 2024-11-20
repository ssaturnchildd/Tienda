package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.services.CategoriaService;
import com.tienda.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProducto(false);
        model.addAttribute("productos", lista);

        var categorias = categoriaService.getCategoria(true);
        model.addAttribute("categorias", categorias);

        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listado(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("productos", categoria.getProductos());

        var categorias = categoriaService.getCategoria(true);
        model.addAttribute("categorias", categorias);

        return "/pruebas/listado";
    }

    @GetMapping("/listado2")
    public String listado2(Model model) {
        var lista = productoService.getProducto(false);
        model.addAttribute("productos", lista);

        return "/pruebas/listado2";
    }

    @GetMapping("/consultaAmpliada")
    public String consultasAmpliadas(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var productos = productoService.consultaAmpliada(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }

    @GetMapping("/consultaJPQL")
    public String consultasJPQL(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var productos = productoService.consultaJPQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }

    @GetMapping("/consultaSQL")
    public String consultasSQL(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var productos = productoService.consultaSQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }

    @GetMapping("/consultaAmpliada2")
    public String consultasAmpliadas(@RequestParam(value = "existencias") int existencias,
            Model model) {
        var productos = productoService.consultaAmpliada(existencias);
        model.addAttribute("productos", productos);
        model.addAttribute("existencias", existencias);
        return "/pruebas/listado2";
    }

    @GetMapping("/consultaJPQL2")
    public String consultasJPQL(@RequestParam(value = "existencias") int existencias,
            Model model) {
        var productos = productoService.consultaJPQL(existencias);
        model.addAttribute("productos", productos);
        model.addAttribute("existencias", existencias);
        return "/pruebas/listado2";
    }

    @GetMapping("/consultaSQL2")
    public String consultasSQL(@RequestParam(value = "existencias") int existencias,
            Model model) {
        var productos = productoService.consultaSQL(existencias);
        model.addAttribute("productos", productos);
        model.addAttribute("existencias", existencias);
        return "/pruebas/listado2";
    }

}
