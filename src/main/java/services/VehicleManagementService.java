package services;

import exceptions.SlotNotFoundException;
import models.Floor;
import models.Slot;
import models.Vehicle;
import models.VehicleType;

import java.util.*;

public class VehicleManagementService {

    Map<Integer, Vehicle> vehicleMap = new HashMap<>();


    void genericSlotAllocation(Vehicle vehicle) {
        for(Map.Entry<Integer,Floor> entry : ParkingLotService.parkingLot.getFloorList().entrySet()) {
            Collection<Slot> slotList = entry.getValue().getSlotList().values();

            for (Slot s : slotList) {
                if(vehicle.getType().equals(VehicleType.CAR) && s.getSlotId() >3 ) {
                    if(s.isEmpty()) {
                        s.setEmpty(false);
                        String ticketId =
                                ParkingLotService.parkingLot.getId() + "_" + entry.getKey() + "_" + s.getSlotId();
                        vehicle = vehicle.toBuilder()
                                .ticketId(ticketId)
                                .build();
                        vehicleMap.put(vehicle.getRegNumber(),vehicle);
                        return;
                    }
                } else if (vehicle.getType().equals(VehicleType.BIKE) && s.getSlotId() <= 3 && s.getSlotId() >1 ) {
                    if(s.isEmpty()) {
                        s.setEmpty(false);
                        String ticketId =
                                ParkingLotService.parkingLot.getId() + "_" + entry.getKey() + "_" + s.getSlotId();
                        vehicle = vehicle.toBuilder()
                                .ticketId(ticketId)
                                .build();
                        vehicleMap.put(vehicle.getRegNumber(),vehicle);
                        return;
                    }
                } else {
                    if(s.isEmpty() && s.getSlotId() == 1) {
                        s.setEmpty(false);
                        String ticketId =
                                ParkingLotService.parkingLot.getId() + "_" + entry.getKey() + "_" + s.getSlotId();
                        vehicle = vehicle.toBuilder()
                                .ticketId(ticketId)
                                .build();
                        vehicleMap.put(vehicle.getRegNumber(),vehicle);
                        return;
                    }
                }
            }

        }
        //throw new SlotNotFoundException("Slot not found for regId : " + vehicle.getRegNumber());

    }

    public void bookSlot(Vehicle vehicle) {
        genericSlotAllocation(vehicle);

        if(vehicleMap.get(vehicle.getRegNumber()) == null) {
            System.out.println("Slot not found for regId : " + vehicle.getRegNumber());
        } else {
            System.out.println(vehicleMap.get(vehicle.getRegNumber()).getTicketId());
        }
    }

    public void unPark(String ticketId) {

        for (Map.Entry<Integer,Vehicle> entry : vehicleMap.entrySet()) {
            Vehicle v = entry.getValue();

            if (v.getTicketId().equals(ticketId)) {

                //clear the Slot
                String data[] = ticketId.split("_");
                Integer slotId = Integer.valueOf(data[data.length - 1]);
                Integer floorId = Integer.valueOf(data[data.length - 2]);

                ParkingLotService.parkingLot.getFloorList().get(floorId).getSlotList().get(slotId).setEmpty(true);

                vehicleMap.remove(v.getRegNumber());

                System.out.println("Unparked vehicle with regId: " + v.getRegNumber());
                return;
            }


        }

    }

}
