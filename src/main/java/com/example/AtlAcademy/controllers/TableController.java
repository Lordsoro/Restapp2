package com.example.AtlAcademy.controllers;

import com.example.AtlAcademy.services.TableService;
import com.example.AtlAcademy.models.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tables")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public List<TableEntity> getTables(@RequestHeader(value = "Authorization") String token) {
        return tableService.getTables();
    }

    @PostMapping
    public void createTable(@RequestBody TableEntity table) {
        tableService.createTable(table);
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
    }
}
