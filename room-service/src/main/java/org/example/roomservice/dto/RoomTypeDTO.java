package org.example.roomservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypeDTO {
    private Long id;
    private String name;
    private String description;
}
