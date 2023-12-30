package com.inm429.ecommerce.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.inm429.ecommerce.Model.Count;

public interface CountRepository extends CrudRepository<Count, String>{

    @Query(value = "SELECT count FROM count ", nativeQuery = true)
    Integer getCurrentCount();

    @Modifying
    @Transactional
    @Query(value = "UPDATE count SET count = count + 1", nativeQuery = true)
    void increaseCount();

    @Modifying
    @Transactional
    @Query(value = "UPDATE count SET count = count - 1", nativeQuery = true)
    void decreaseCount();
}
