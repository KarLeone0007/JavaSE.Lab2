package com.company;

import com.company.classes.DataOwnerCar;
import com.company.classes.Parking;
import com.company.classes.ParkingPlace;

public class Main {

    public static void main(String[] args) {
        final int PARKING_PLACE = 100;
        Parking parking = new Parking(PARKING_PLACE);

        parking.addIndex(0, new ParkingPlace(1, new DataOwnerCar("sur", "", ""), "", false, false));
        parking.addIndex(1, new ParkingPlace(2, new DataOwnerCar("abc", "", ""), "", true, false));
        parking.addIndex(2, new ParkingPlace(3, new DataOwnerCar("abc", "", ""), "", true, true));
        parking.addIndex(3, new ParkingPlace(4, new DataOwnerCar("", "", ""), "", true, false));
        parking.addIndex(4, new ParkingPlace(5, new DataOwnerCar("1", "", ""), "", true, false));

       //System.out.println(parking.isNotPayed());
        //parking.eraseBySurName("abc");
        parking.addAfterSurname(
                    new ParkingPlace(54, new DataOwnerCar("example", "", ""), "", true, true), "sur"
        );
        System.out.println(parking.toString());
        parking.getFreePlace();
    }
}
