package com.company.classes;

import java.util.ArrayList;
import java.util.Iterator;

public class Parking {
    private ArrayList <ParkingPlace> List;

    public Parking() {
        this.List = new ArrayList<>();
    }

    public Parking(int length) {
        this.List = new ArrayList<>(length);
        for (int i = 0; i < length; ++i) {
            add(null);
        }
    }

    public void addIndex(int position, ParkingPlace parkingPlace) {
        if (position >= 0 && position <= this.List.size()) {
            this.List.add(position, parkingPlace);
        }
    }

    public void add(ParkingPlace parkingPlace) {
        this.List.add(parkingPlace);
    }

    public void setIndex(int position, ParkingPlace parkingPlace) {
        if (position >= 0 && position <= this.List.size()) {
            this.List.set(position, parkingPlace);
        }
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
        this.List.removeIf(parkingPlace -> parkingPlace != null && parkingPlace.getData().getSurName().equals(_surname));
    }

    public void getFreePlace() {
        for (int i = 0; i < this.List.size(); ++i) {
            if (
                    this.List.get(i) == null  || (!this.List.get(i).isMonthlyPayments() && !this.List.get(i).isParking())
            ) {
                System.out.println(this.List.get(i) + " " + i);
            }
        }
    }

    public void addAfterSurname(ParkingPlace parkingPlace, String surname) {
        int indexSurname = -1;
        for (int i = 0; i < this.List.size(); ++i) {
            if (
                    this.List.get(i) != null && this.List.get(i).getData().getSurName().equals(surname)
            ) {
                indexSurname = i;
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
