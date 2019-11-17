package com.company.classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

class BackupCollection {
    public void writeJSON(Parking parking, String fileName) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter(fileName);
        writer.write(gson.toJson(parking));
        writer.close();
    }
    public Parking readJSON(String fileName) throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName));
        return gson.fromJson(bufferedReader, Parking.class);
    }
}