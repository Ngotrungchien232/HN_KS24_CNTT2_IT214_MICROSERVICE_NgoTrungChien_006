package org.example.roomtypeservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.roomtypeservice.entity.RoomType;
import org.example.roomtypeservice.service.RoomTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomtypes")
@RequiredArgsConstructor
public class RoomTypeController {
    private final RoomTypeService service;

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getById(@PathVariable Long id) {
        RoomType roomType = service.getById(id);
        if (roomType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(roomType);
    }

    @PostMapping
    public RoomType create(@RequestBody RoomType roomType) {
        return service.create(roomType);
    }

    @GetMapping
    public List<RoomType> getAll() {
        return service.getAll();
    }
}
