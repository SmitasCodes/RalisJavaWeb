package com.airidas.ralis.ralis.model;

public class Masina {
    private String marke;
    private String modelis;
    private double turis;
    private int maxGreitis;

    public Masina(String marke, String modelis, double turis, int maxGreitis) {
        this.marke = marke;
        this.modelis = modelis;
        this.turis = turis;
        this.maxGreitis = maxGreitis;
    }

    // Getters and setters
    public String getMarke() {
        return marke;
    }

    public String getModelis() {
        return modelis;
    }

    public double getTuris() {
        return turis;
    }

    public int getMaxGreitis() {
        return maxGreitis;
    }
}