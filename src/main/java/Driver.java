import models.Vehicle;
import models.VehicleType;
import services.ParkingLotService;
import services.VehicleManagementService;

import java.util.Scanner;

public class Driver {



    public static void main(String[] args) {

        ParkingLotService parkingLotService = new ParkingLotService();
        //testing approach
        parkingLotService.createParkingLot();
        parkingLotService.addFloor(1);
        parkingLotService.addSlot(1,1);
        parkingLotService.addSlot(1,2);
        parkingLotService.addSlot(1,3);
        parkingLotService.addSlot(1,4);
        parkingLotService.addSlot(1,5);

        System.out.println("Parking Lot created");

        Vehicle truck1 = Vehicle.builder()
                .regNumber(123)
                .color("BLACK")
                .type(VehicleType.TRUCK)
                .build();

        VehicleManagementService vehicleManagementService = new VehicleManagementService();

        vehicleManagementService.bookSlot(truck1);

        Vehicle truck2 = Vehicle.builder()
                .regNumber(456)
                .color("BLACK")
                .type(VehicleType.TRUCK)
                .build();

        vehicleManagementService.bookSlot(truck2);


        Vehicle bike1 = Vehicle.builder()
                .regNumber(123)
                .color("BLACK")
                .type(VehicleType.BIKE)
                .build();

        vehicleManagementService.bookSlot(bike1);


        Vehicle bike2 = Vehicle.builder()
                .regNumber(456)
                .color("BLACK")
                .type(VehicleType.BIKE)
                .build();

        vehicleManagementService.bookSlot(bike2);


        vehicleManagementService.unPark("PR1234_1_3");

        Vehicle bike3 = Vehicle.builder()
                .regNumber(789)
                .color("BLACK")
                .type(VehicleType.BIKE)
                .build();

        vehicleManagementService.bookSlot(bike3);

        //TODO:CLI based Approach
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {

            String commandLine = sc.nextLine();
            String[] commands = commandLine.split(" ");
            String commandType = commands[0];

            switch (commandType) {
                case "create_parking_lot":
                    break;
                case "park_vehicle":
                    break;
                case "unpark_vehicle":
                    break;
                case "display":
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }

    }

}
