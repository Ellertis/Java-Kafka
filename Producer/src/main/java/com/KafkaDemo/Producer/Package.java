package com.KafkaDemo.Producer;

public class Package {
    private String PackageName;
    private double Weight;
    private double Price;

    public Package() {
    }

    public Package(double price, double weight, String packageName) {
        Price = price;
        Weight = weight;
        PackageName = packageName;
    }

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
