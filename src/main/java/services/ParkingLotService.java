package services;

import exceptions.FloorNotFoundException;
import models.Floor;
import models.ParkingLot;
import models.Slot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotService {

    static public ParkingLot parkingLot = new ParkingLot();

    public void createParkingLot() {
        parkingLot.setId("PR1234");
    }

    public void addFloor(int floorId) {
        if (parkingLot.getFloorList() == null ) {
            Map<Integer,Floor> floor = new HashMap();
            floor.put(floorId,Floor.builder()
                            .floorId(floorId)
                    .build());

            parkingLot.setFloorList(floor);
        } else {
            parkingLot.getFloorList().put(floorId,Floor.builder()
                    .floorId(floorId)
                    .build());
        }
    }

    public void addSlot(int floorId , int slotId) {

        if (parkingLot.getFloorList().containsKey(floorId)) {

            if (parkingLot.getFloorList().get(floorId).getSlotList() == null ) {

                Map<Integer,Slot> slotMap = new HashMap<>();

                Slot slot = Slot.builder()
                        .slotId(slotId)
                        .isEmpty(true)
                        .build();
                slotMap.put(slotId,slot);

                parkingLot.getFloorList().get(floorId).setSlotList(slotMap);

            } else {

                Slot slot = Slot.builder()
                        .slotId(slotId)
                        .isEmpty(true)
                        .build();

                parkingLot.getFloorList().get(floorId).getSlotList().put(slotId,slot);
            }

        } else {
            throw new FloorNotFoundException("Cannot find floor with given id");
        }
    }


}
