package com.airidas.ralis.ralis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.airidas.ralis.ralis.model.Masina;
import com.airidas.ralis.ralis.service.CarService;

@Controller
@RequestMapping("/masinos")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String showCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "car-list";
    }

    @GetMapping("/vidutinis-turis")
    public String showAverageVolume(Model model) {
        model.addAttribute("averageVolume", carService.calculateAverageVolume());
        return "average-volume";
    }

    @GetMapping("/paeiska")
    public String searchForm() {
        return "search-form";
    }

    @PostMapping("/paieska")
    public String searchByMakeAndModel(@RequestParam String make, @RequestParam String model, Model modelAttr) {
        List<Masina> results = carService.searchByMakeAndModel(make, model);
        modelAttr.addAttribute("cars", results);
        return "car-list";
    }
}