package org.example.roomservice.service;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.example.roomservice.client.RoomTypeClient;
import org.example.roomservice.dto.RoomTypeDTO;
import org.example.roomservice.entity.Room;
import org.example.roomservice.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository repository;
    private final RoomTypeClient roomTypeClient;

    public List<Room> getAll() {
        return repository.findAll();
    }

    public Room create(Room room) {
        try {
            RoomTypeDTO roomType = roomTypeClient.getById(room.getRoomTypeId());
            if (roomType == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loai phong khong ton tai");
            }
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loai phong khong ton tai");
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loai phong khong ton tai");
        }

        return repository.save(room);
    }
}
