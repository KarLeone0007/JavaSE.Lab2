package com.company.classes;

import java.util.ArrayList;

public class Parking {
    private final ArrayList <ParkingPlace> List;                //создаем список парк. мест

    public Parking() {
        this.List = new ArrayList<>();
    }         //конструктор без параметров, т.е. создаем пустой контейнер

    public Parking(int length) {                //в данном случаем указываем размер контейнера
        this.List = new ArrayList<>(length);
        for (int i = 0; i < length; ++i) {      //и заполняем его null, ибо после того как мы указали его length без заполнение, List.size() останется 0.
            add(null);
        }
    }

    public void addIndex(int position, ParkingPlace parkingPlace) { //добавляем по индексу парк. место
        if (position >= 0 && position <= this.List.size()) {    //если позиции в пределах размера контейнера
            this.List.add(position, parkingPlace);              //готовый метод контейнера add(int position, Object obj)
        }
    }

    public void add(ParkingPlace parkingPlace) {
        this.List.add(parkingPlace);
    }   //добавляет в конец списка

    public void setIndex(int position, ParkingPlace parkingPlace) { //по заданной позиции меняет данные
        if (position >= 0 && position <= this.List.size()) {
            this.List.set(position, parkingPlace);
        }
    }


    private ParkingPlace removeIndex(int position) {    //удаляет обьект по позиции
        if(position >= 0 && position < this.List.size()) {
            return this.List.remove(position);          // и возвращает его, если позиция в пределах списка
        }
        return null;
    }

    public Parking isNotPayed() {               //аналогичной 2 лабе создаем массив парк. мест и добавляем туда парк. места, за которые не хаплатили
        Parking parking = new Parking();
        for (ParkingPlace parkingPlace:this.List) {
            if (parkingPlace != null && !parkingPlace.isMonthlyPayments()) {
                parking.add(parkingPlace);
            }
        }
        return parking;                          //возвращаем массив
    }

    public void eraseBySurName(String _surname) {
        this.List.removeIf(parkingPlace -> parkingPlace != null && parkingPlace.getData().getSurName().equals(_surname));
        //здесь используется лямба выражение - в этом списке ищем обьект не пустой и фамилия которого == _surname, и вырезаем его.
        //данный метод возвращает boolean
    }

    public void getFreePlace() { //модифицированный метод для вывода своб. мест
        for (int i = 0; i < this.List.size(); ++i) {
            if (
                    this.List.get(i) == null  || (!this.List.get(i).isMonthlyPayments() && !this.List.get(i).isParking())
                    //проверка пустое ли место и парк. место за которое не заплатили за месяц и там никого нет
            ) {
                System.out.println(this.List.get(i) + " " + i);     //вывод индекс места
            }
        }
    }

    public void addAfterSurname(ParkingPlace parkingPlace, String surname) {            //аналогичен медот для лабы 2
        int indexSurname = -1;
        for (int i = 0; i < this.List.size(); ++i) {
            if (
                    this.List.get(i) != null && this.List.get(i).getData().getSurName().equals(surname)
            ) {
                indexSurname = i;       //находим индекс
                break;
            }
        }
        if (indexSurname != -1) {
            addIndex(indexSurname + 1, parkingPlace);       //добавляем по индексу + 1, парковочное место
        }
    }

    public void clearArray() {
        this.List.clear();
    }               //готовый метод для очистки списка

    @Override
    public String toString() {
        return "Parking{" +
                "List=" + this.List +
                '}';
    }
}
