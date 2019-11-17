package com.company.classes;

public class DataOwnerCar {
    private String surName;
    private String name;
    private String fatherName;
    public DataOwnerCar() {}
    public DataOwnerCar(String _surName, String _name, String _fatherName) {
        this.surName = _surName;
        this.name = _name;
        this.fatherName = _fatherName;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return "DataOwnerCar{" +
                "surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }
}
