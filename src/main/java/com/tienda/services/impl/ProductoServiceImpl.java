package com.tienda.services.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProducto(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            //Se deben eliminar de la lista los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    //Consulta Ampliada
    //Recupera los productos que estan en un rango de precios ordenados por descripcion
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaAmpliada(double precioInf, double precioSup) {

        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    //Consulta JPQL
    //Recupera los productos que estan en un rango de precios ordenados por descripcion
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPQL(double precioInf, double precioSup) {
        return productoDao.consultaJPQL(precioInf, precioSup);
    }

    //Consulta SQL
    //Recupera los productos que estan en un rango de precios ordenados por descripcion
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaSQL(double precioInf, double precioSup) {
        return productoDao.consultaSQL(precioInf, precioSup);
    }

    //Consulta Ampliada
    //Recupera los productos segun la cantidad de existencias ordenados por descripcion
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaAmpliada(int existencias) {
        return productoDao.findByExistenciasGreaterThanEqualOrderByDescripcion(existencias);
    }

    //Consulta JPQL
    //Recupera los productos segun la cantidad de existencias ordenados por descripcion
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPQL(int existencias) {
        return productoDao.consultaJPQL(existencias);
    }
    //Consulta SQL
    //Recupera los productos segun la cantidad de existencias ordenados por descripcion

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaSQL(int existencias) {
        return productoDao.consultaSQL(existencias);
    }

}
