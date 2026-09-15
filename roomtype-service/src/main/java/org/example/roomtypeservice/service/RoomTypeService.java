package org.example.roomtypeservice.service;

import lombok.RequiredArgsConstructor;
import org.example.roomtypeservice.entity.RoomType;
import org.example.roomtypeservice.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomTypeService {
    private final RoomTypeRepository repository;

    public RoomType getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public RoomType create(RoomType roomType) {
        return repository.save(roomType);
    }

    public List<RoomType> getAll() {
        return repository.findAll();
    }
}
