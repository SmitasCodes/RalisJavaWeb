package com.airidas.ralis.ralis.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.airidas.ralis.ralis.model.Masina;

@Service
public class CarService {
    private final List<Masina> masinuSarasas = new ArrayList<>();

    public CarService() {
        loadCarsFromFile();
    }

    private void loadCarsFromFile() {
        try (InputStream inputStream = getClass().getResourceAsStream("/static/masinos.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                masinuSarasas
                        .add(new Masina(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Masina> getAllCars() {
        return masinuSarasas;
    }

    public String calculateAverageVolume() {
        double average = masinuSarasas.stream().mapToDouble(Masina::getTuris).average().orElse(0);
        return String.format("%.2f", average);
    }

    public List<Masina> searchByMakeAndModel(String make, String model) {
        List<Masina> result = new ArrayList<>();
        for (Masina car : masinuSarasas) {
            if ((make.isEmpty() || car.getMarke().contains(make)) &&
                    (model.isEmpty() || car.getModelis().contains(model))) {
                result.add(car);
            }
        }
        return result;
    }
}