package models;


import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class Vehicle {

    private VehicleType type;
    private Integer regNumber;
    private String color;
    private String ticketId;

}
