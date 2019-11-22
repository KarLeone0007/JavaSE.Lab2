package com.company.classes;

import java.util.Arrays;

public class Parking {
    private ParkingPlace[] list;        //создаем массив парковочных мест.

    public Parking() {                  //конструктор, в котором нету входящих параметров, поэтому размер массива 0.
        this.list = new ParkingPlace[0];
    }

    public Parking(int length) {        //также можно передать в конструктор парковки количество парковочных мест
        this.list = new ParkingPlace[length];
    }

    private void resizeArray(int newLength) {            //изменить размер массива
        ParkingPlace[] tempArray;                        //создаем временный массив,
        tempArray = Arrays.copyOf(this.list, newLength); //в который копируем данный массив, и до позиции newLength
        this.list = tempArray;                           //и приравниваем данные массив к временному.
    }

    public void addIndex(ParkingPlace parkingPlace, int position) {     //добавляем парковочное место по индексу(position)
        if (position >= this.list.length) {                             //условие прикором мы выходим за размеры нашего массива
            this.resizeArray(position + 1);                   //изменяем размер массива на +1
            this.list[position] = parkingPlace;                         //и добавляем его на данную позицию
        }
        else if (position >= 0) {
            this.list[position] = parkingPlace;                         //если позиция находится в пределах массива, добавляем на эту позицию
        }                                                               // парковочное место
    }

    //null означает отсутствующее значение или ссылку
    public void add(ParkingPlace parkingPlace) {                         //
        if (this.list.length != 0 && this.list[this.list.length - 1] == null) { //проверка на размер != 0, и является ли последений эл. пустым
            for (int i = 0; i < this.list.length; ++i) {                        //через итерацию находим пустой обьект
                if (list[i] == null) {
                    list[i] = parkingPlace;                                     //и инициализируем массив в данной позиции
                    break;
                }
            }
        }
        else {
            addIndex(parkingPlace, this.list.length);                             //иначе добавляем в конец парковочное место
        }
    }           //данный метод позволяет добавить парк. место в конец массива


    private ParkingPlace removeIndex(int position) {                                                    //удаление по индексу
        if (position >= 0 && position < this.list.length) {
            ParkingPlace parkingPlace = this.list[position];                                            //создаем парковочное место, которое в итоге возвращаем  *
            if (list.length - 1 - position >= 0)
                System.arraycopy(list, position + 1, list, position, list.length - 1 - position);   //метод, которые позволяет скопировать все элементы
                                                                                                                 //кроме позиции, которую необходимо удалить,
                                                                                                                 //в данный массив
            resizeArray(this.list.length - 1);                                                 //уменьшаем размер на 1
            return parkingPlace;                                                                         // *
        }
        else {
            return null;        //если позиции за пределами массива, возвращаем null
        }
    }
    public Parking isNotPayed() {                                               //парковочные места, за которые не заплатили
        Parking parking = new Parking();                                        //новый массив парк. мест, в который записываем все парк. места, за которые не заплатили
        for (ParkingPlace parkingPlace:this.list) {                             //с помощью итераций проходимся по массиву и ищем
            if (parkingPlace != null && !parkingPlace.isMonthlyPayments()) {    //не null места и места, за которые не заплатили
                parking.add(parkingPlace);                                      //и добавляем в этот массив
            }
        }
        return parking;                                                          //возвращаем массив парк. мест, за которые не заплатили
    }

    public Parking eraseBySurName(String _surname) {                                //вырезаем с массива людей с фамилией (_surname)
        Parking parking = new Parking();                                            //аналогично пред. функции, создаем массив парк. мест, чтобы в итоге вернуть в виде массива
        for (int i = 0; i < this.list.length; ++i) {                                //итерацией
            if (this.list[i] != null && this.list[i].getData().getSurName().equals(_surname)) { //находим человека с такой-то фамилией  ( .equals(_surname) или string1 == string2)
                parking.add(removeIndex(i));                                        //добавляем в этот массив всех людей, которых мы вырезали с общего массива
                i = 0;                                                              //приравниваем i к 0, ибо list.length уменьшается на 1, и если на следующей
            }                                                                       //позиции будет человек  с такой же фамилией, его пропустит цикл.
        }
        return parking;                                                              //возвращаем массив парк. мест
    }

    public void getFreePlace() {                                                    //вывод пустых парковочный мест
        for (int i = 0; i < this.list.length; ++i) {                                //итерацией
            if (this.list[i] == null) {                                             //если обьект на этой позиции пуст
                System.out.println(i);                                              //выводим индекс
            }
        }
    }

    public void addAfterSurname(ParkingPlace parkingPlace, String surname) {            //добавить парковочное место после фамилии
        int indexSurname = -1;                                                          //индекс
        for (ParkingPlace place : this.list) {                                          //итерацией
            if (place != null && place.getData().getSurName().equals(surname)) {        //находим обьект с данной фамилией
                indexSurname = place.getData().getSurName().indexOf(surname);           //узнаем индекс (местонахождение) в массиве
                break;                                                                  //и прерываем цикл
            }
        }
        if (indexSurname != -1) {
            addIndex(parkingPlace, indexSurname + 1);                            //добавляем в данный массив парк. место после фамилии (индекс + 1)
        }
    }


    public void clearArray() {                      //очистка массива
        resizeArray(0);
    }

    @Override
    public String toString() {                       //вывод массива парк. мест.
        return "Parking{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
