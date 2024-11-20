package com.tienda.services;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {

    //Se obtiene un arraylist con los registros de la tabla producto
    //Todos los registros, o solo los activos
    public List<Producto> getProducto(boolean activos);

    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);

    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Producto producto);

    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);

    //Consulta Ampliada
    //Recupera los productos que estan en un rango de precios ordenados por descripcion
    public List<Producto> consultaAmpliada(double precioInf, double precioSup);

    //Consulta JPQL
    //Recupera los productos que estan en un rango de precios ordenados por descripcion
    public List<Producto> consultaJPQL(double precioInf, double precioSup);

    //Consulta SQL
    //Recupera los productos que estan en un rango de precios ordenados por descripcion
    public List<Producto> consultaSQL(double precioInf, double precioSup);

    //Consulta ampliada
    // Recupera los productos con existencias mayores o iguales al valor dado, ordenados por descripción
    public List<Producto> consultaAmpliada(int existencias);

    //Consulta JPQL
    // Recupera los productos con existencias mayores o iguales al valor dado, ordenados por descripción
    public List<Producto> consultaJPQL(int existencias);

    //Consulta SQL
    // Recupera los productos con existencias mayores o iguales al valor dado, ordenados por descripción
    public List<Producto> consultaSQL(int existencias);

}
