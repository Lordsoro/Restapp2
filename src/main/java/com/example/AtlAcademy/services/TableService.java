package com.example.AtlAcademy.services;

import com.example.AtlAcademy.models.TableEntity;
import com.example.AtlAcademy.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<TableEntity> getTables() {
        return tableRepository.findAll();
    }

    public void createTable(TableEntity table) {
        if (tableRepository.existsById(table.getId())) {
            throw new RuntimeException("La mesa ya ha sido creada");
        }
        tableRepository.save(table);
    }

    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }
}
