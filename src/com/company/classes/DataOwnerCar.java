package com.company.classes;

public class DataOwnerCar { //данные владельца мащини
    private String surName;
    private String name;
    private String fatherName;
    public DataOwnerCar() {} //пустой констуктор
    public DataOwnerCar(String _surName, String _name, String _fatherName) { //конструктор, в которм происходит инициализация переменных
        this.surName = _surName;                                             // this. обращаемся к данному полю с модификатором доступа private
        this.name = _name;                                                   // т.е. инкапсуляция
        this.fatherName = _fatherName;
    }

    public String getSurName() {                                               //метод для того, чтобы получить данные, так как поле private, a метод public
        return this.surName;
    }

    @Override                                                                   //собственно и вывод
    public String toString() {
        return "DataOwnerCar{" +
                "surName='" + this.surName + '\'' +
                ", name='" + this.name + '\'' +
                ", fatherName='" + this.fatherName + '\'' +
                '}';
    }
}
