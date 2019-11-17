package com.company.classes;

import java.util.ArrayList;

public class Parking {
    private final ArrayList <ParkingPlace> List;

    public Parking() {
        this.List = new ArrayList<>();
    }

    public Parking(int length) {
        this.List = new ArrayList<>(length);
    }

    public void addIndex(int position, ParkingPlace parkingPlace) {
        if (position >= 0 && position <= this.List.size()) {
            this.List.add(position, parkingPlace);
        }
    }

    public void add(ParkingPlace parkingPlace) {
        this.List.add(parkingPlace);
    }


    private ParkingPlace removeIndex(int position) {
        if(position >= 0 && position < this.List.size()) {
            return this.List.remove(position);
        }
        return null;
    }

    public Parking isNotPayed() {
        Parking parking = new Parking();
        for (ParkingPlace parkingPlace:this.List) {
            if (parkingPlace != null && !parkingPlace.isMonthlyPayments()) {
                parking.add(parkingPlace);
            }
        }
        return parking;
    }

    public void eraseBySurName(String _surname) {
        this.List.removeIf(parkingPlace -> parkingPlace.getData().getSurName().equals(_surname));
    }

    public void getFreePlace() {

    }

    public void addAfterSurname(ParkingPlace parkingPlace, String surname) {
        int indexSurname = 0;
        for (ParkingPlace _parkingPlace: this.List) {
            if (
                    _parkingPlace.getData().getSurName().equals(surname)
            ) {
                indexSurname = _parkingPlace.getData().getSurName().indexOf(surname);
                break;
            }
        }
        if (indexSurname != -1) {
            addIndex(indexSurname + 1, parkingPlace);
        }
    }



    public void clearArray() {
        this.List.clear();
    }

    @Override
    public String toString() {
        return "Parking{" +
                "List=" + this.List +
                '}';
    }
}
