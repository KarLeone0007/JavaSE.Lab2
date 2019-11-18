package com.company.classes;

import java.util.Arrays;

public class Parking {
    private ParkingPlace[] list;

    public Parking() {
        this.list = new ParkingPlace[0];
    }

    public Parking(int length) {
        this.list = new ParkingPlace[length];
    }

    private void resizeArray(int newLength) {
        ParkingPlace[] tempArray;
        tempArray = Arrays.copyOf(this.list, newLength);
        this.list = tempArray;
    }

    public void addIndex(ParkingPlace parkingPlace, int position) {
        if (position >= this.list.length) {
            this.resizeArray(position + 1);
            this.list[position] = parkingPlace;
        }
        else if (position >= 0) {
            this.list[position] = parkingPlace;
        }
    }

    public void add(ParkingPlace parkingPlace) {

        if (this.list.length != 0 && this.list[this.list.length - 1] == null) {
            for (int i = 0; i < this.list.length; ++i) {
                if (list[i] == null) {
                    list[i] = parkingPlace;
                    break;
                }
            }
        }
        else {
            addIndex(parkingPlace, this.list.length);
        }
    }


    private ParkingPlace removeIndex(int position) {
        if (position >= 0 && position < this.list.length) {
            ParkingPlace parkingPlace = this.list[position];
            if (list.length - 1 - position >= 0)
                System.arraycopy(list, position + 1, list, position, list.length - 1 - position);

            resizeArray(this.list.length - 1);
            return parkingPlace;
        }
        else {
            return null;
        }
    }
    public Parking isNotPayed() {
        Parking parking = new Parking();
        for (ParkingPlace parkingPlace:this.list) {
            if (parkingPlace != null && !parkingPlace.isMonthlyPayments()) {
                parking.add(parkingPlace);
            }
        }
        return parking;
    }

    public Parking eraseBySurName(String _surname) {
        Parking parking = new Parking();
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] != null && this.list[i].getData().getSurName().equals(_surname)) {
                parking.add(removeIndex(i));
                i = 0;
            }
        }
        return parking;
    }

    public void getFreePlace() {
        for (int i = 0; i < this.list.length; ++i) {
            if (this.list[i] == null) {
                System.out.println(i + " ");
            }
        }
    }

    public void addAfterSurname(ParkingPlace parkingPlace, String surname) {
        int indexSurname = -1;
        for (ParkingPlace place : this.list) {
            if (place != null && place.getData().getSurName().equals(surname)) {
                indexSurname = place.getData().getSurName().indexOf(surname);
                break;
            }
        }
        if (indexSurname != -1) {
            addIndex(parkingPlace, indexSurname + 1);
        }
    }


    public void clearArray() {
        resizeArray(0);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
