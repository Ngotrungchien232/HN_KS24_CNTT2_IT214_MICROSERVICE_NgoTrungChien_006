package org.example.roomservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.roomservice.entity.Room;
import org.example.roomservice.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService service;

    @GetMapping
    public List<Room> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Room create(@RequestBody Room room) {
        return service.create(room);
    }
}
