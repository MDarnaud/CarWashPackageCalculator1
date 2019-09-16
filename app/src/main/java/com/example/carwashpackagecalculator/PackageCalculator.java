package com.example.carwashpackagecalculator;

public class PackageCalculator {
    static final int Wash_Exterior = 5;
    static final int Wash_Ext_Int = 10;

    private int Area;
    private int Washes;

    public PackageCalculator() {
        Area = Wash_Ext_Int;
        Washes = 0;
    }

    //getters
    public int getArea() {
        return Area;
    }

    public int getWashes() {
        return Washes;
    }

    //setters
    public void setArea(int price) {
        this.Area = price;
    }

    public void setWashes(int washes) {
        Washes = washes;
    }

    //calculate package price
    public int getTotalPrice() {
        int totalPrice = Area*Washes;
        if (Washes >= 12)
        {
            totalPrice -= totalPrice*0.25;
        }
        return totalPrice;
    }


}
