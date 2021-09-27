package com.example.market3.Rapository;

import com.example.market3.Entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductRepository extends JpaRepository<JpaProduct,Long> {

    @Query("select j from JpaProduct j where j.productType = :productType")
    List<JpaProduct>findByType(@Param("productType")String productType);
}
