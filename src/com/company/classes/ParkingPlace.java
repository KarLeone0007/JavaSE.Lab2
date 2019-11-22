package com.company.classes;

public class ParkingPlace {             //парковочное место
    private int numberPlace;
    private DataOwnerCar data;          //тип данных - класс DataOwnerCar, где хранятся данные владельца (ФИО).
    private String carModel;
    private boolean isParking;
    private boolean isMonthlyPayments;

    public ParkingPlace() {}            //пустой конструктор

    public DataOwnerCar getData() {     //public метод для получения доступа к данным владельца автокара.
        return this.data;
    }

    public ParkingPlace(int _numberPlace, DataOwnerCar _data, String _carModel, boolean _isParking, boolean _isMonthlyPayments) {
        this.numberPlace = _numberPlace;                            //конструктор с инициализацией
        this.data = _data;
        this.carModel = _carModel;
        this.isParking = _isParking;
        this.isMonthlyPayments = _isMonthlyPayments;
    }

    public boolean isMonthlyPayments() {
        return this.isMonthlyPayments;
    }   //как и в пред. раз, метод для получения данных

    @Override
    public String toString() {                                         //вывод парковочного места
        return "ParkingPlace{" +
                "numberPlace=" + this.numberPlace +
                ", data=" + this.data +
                ", carModel='" + this.carModel + '\'' +
                ", isParking=" + this.isParking +
                ", isMonthlyPayments=" + this.isMonthlyPayments +
                '}';
    }
}
