package com.company;

import com.company.classes.DataOwnerCar;
import com.company.classes.Parking;
import com.company.classes.ParkingPlace;

class Main {

    public static void main(String[] args) {
        final int PARKING_PLACE = 100;
        Parking parking = new Parking(PARKING_PLACE);

        parking.addIndex(
                    new ParkingPlace(0, new DataOwnerCar("abc", "", ""), "", true, false), 0);
        parking.add(new ParkingPlace(1, new DataOwnerCar("", "", ""), "", true, true));
        parking.add(new ParkingPlace(2, new DataOwnerCar("abc", "", ""), "", true, false));
        parking.add(new ParkingPlace(3, new DataOwnerCar("abc", "", ""), "", true, true));
        parking.add(new ParkingPlace(4, new DataOwnerCar("", "", ""), "", true, false));
        parking.add(new ParkingPlace(5, new DataOwnerCar("", "", ""), "", true, false));

        System.out.println(parking.isNotPayed());
        System.out.println(parking.eraseBySurName("abc"));
        parking.getFreePlace();
        parking.addAfterSurname(null, "abc");
        System.out.println(parking.toString());
        parking.clearArray();
        System.out.println(parking.toString());

    }
}
