package com.example.inversion_control;

public class Oneplus implements Mobiles {

    Color color;

    // Default constructor
    Oneplus() {
        System.out.println("One Plus Constructor Trigger");
    }

    // Constructor with Color parameter
    Oneplus(Color colorobj) {
        this.color = colorobj;
    }

    @Override
    public void getModelAndColour() {
        System.out.println("Model : 9 Pro Oneplus");
        color.getOnePlusColor();  // Assuming `Color` has this method
    }
}
