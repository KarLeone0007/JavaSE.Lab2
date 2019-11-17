package com.company;

import com.company.classes.DataOwnerCar;
import com.company.classes.Parking;
import com.company.classes.ParkingPlace;

public class Main {

    public static void main(String[] args) {
        Parking parking = new Parking();

        parking.add(new ParkingPlace(1, new DataOwnerCar("1", "", ""), "", true, true));
        parking.add(new ParkingPlace(2, new DataOwnerCar("abc", "", ""), "", true, false));
        parking.add(new ParkingPlace(3, new DataOwnerCar("abc", "", ""), "", true, true));
        parking.add(new ParkingPlace(4, new DataOwnerCar("", "", ""), "", true, false));
        parking.add(new ParkingPlace(5, new DataOwnerCar("", "", ""), "", true, false));

        //System.out.println(parking.isNotPayed());
        //parking.eraseBySurName("abc");
        /*parking.addAfterSurname(
                    new ParkingPlace(54, new DataOwnerCar("example", "", ""), "", true, true), "1"
        );*/

        //System.out.println(parking.toString());

    }
}
