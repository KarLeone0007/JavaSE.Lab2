package com.company.classes;

public class ParkingPlace {
    private int numberPlace;
    private DataOwnerCar data;
    private String carModel;
    private boolean isParking;
    private boolean isMonthlyPayments;

    public ParkingPlace() {}

    public DataOwnerCar getData() {
        return data;
    }

    public ParkingPlace(int _numberPlace, DataOwnerCar _data, String _carModel, boolean _isParking, boolean _isMonthlyPayments) {
        this.numberPlace = _numberPlace;
        this.data = _data;
        this.carModel = _carModel;
        this.isParking = _isParking;
        this.isMonthlyPayments = _isMonthlyPayments;
    }

    public boolean isMonthlyPayments() {
        return isMonthlyPayments;
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
                "numberPlace=" + this.numberPlace +
                ", data=" + this.data +
                ", carModel='" + this.carModel + '\'' +
                ", isParking=" + this.isParking +
                ", isMonthlyPayments=" + this.isMonthlyPayments +
                '}';
    }
}
