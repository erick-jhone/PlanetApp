package com.erick.planetsapp.model;

public class Planet {

    String name;
    int image;
    String[] characteristics;

    public Planet(String name, int image, String[] characteristics) {
        this.name = name;
        this.image = image;
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String[] characteristics) {
        this.characteristics = characteristics;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
