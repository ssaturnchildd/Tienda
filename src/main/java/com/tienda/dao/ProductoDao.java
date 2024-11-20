package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface ProductoDao extends JpaRepository<Producto, Long> {

    //Consulta Ampliada
    //Recupera los productos que estan en un rango de precios ordenados por descripcion
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Consulta JPQL
    //Recupera los productos que estan en un rango de precios ordenados por descripcion
    @Query(value = "SELECT a FROM Producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> consultaJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    //Consulta SQL
    //Recupera los productos que estan en un rango de precios ordenados por descripcion
    @Query(nativeQuery = true, value = "SELECT * FROM producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> consultaSQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
//Consulta Ampliada
    // Recupera los productos con existencias mayores o iguales al valor dado, ordenados por descripción

    List<Producto> findByExistenciasGreaterThanEqualOrderByDescripcion(int existencias);
//Consulta JPQL
// Recupera los productos con existencias mayores o iguales al valor dado, ordenados por descripción

    @Query("SELECT p FROM Producto p WHERE p.existencias >= :existencias ORDER BY p.descripcion ASC")
    List<Producto> consultaJPQL(@Param("existencias") int existencias);
//Consulta SQL
// Recupera los productos con existencias mayores o iguales al valor dado, ordenados por descripción

    @Query(value = "SELECT * FROM producto WHERE existencias >= :existencias ORDER BY descripcion ASC", nativeQuery = true)
    List<Producto> consultaSQL(@Param("existencias") int existencias);

}
