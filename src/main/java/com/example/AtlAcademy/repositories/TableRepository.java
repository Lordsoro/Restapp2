package com.example.AtlAcademy.repositories;

import com.example.AtlAcademy.models.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TableRepository extends JpaRepository<TableEntity, Long> {

    List<TableEntity> getTables();

    void createTable(TableEntity table);

    void deleteTable(Long id);

    boolean existsById(Long id);
}
