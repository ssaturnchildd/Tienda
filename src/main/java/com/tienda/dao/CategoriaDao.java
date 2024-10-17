/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.dao;

import com.tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author sebastianbarrantes
 */
@EnableJpaRepositories
public interface CategoriaDao extends JpaRepository<Categoria,Long>{
    
    
}
