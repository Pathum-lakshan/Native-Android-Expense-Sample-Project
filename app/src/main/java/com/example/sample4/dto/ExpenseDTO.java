package com.example.sample4.dto;

import android.graphics.Bitmap;

import java.time.LocalDate;

public class ExpenseDTO {
    private String expenseID;
    private double travelExpense;
    private Bitmap travelImage;
    private double fuelExpense;
    private Bitmap fuelImage;
    private double highwayChargeExpense;
    private Bitmap highwayChargeImage;
    private double parkingExpense;
    private Bitmap parkingImage;
    private double vehicleServiceExpense;
    private Bitmap vehicleServiceImage;
    private double nightOutExpense;
    private Bitmap nightOutImage;
    private double lunchExpense;
    private Bitmap lunchImage;
    private LocalDate expenseDate;

    public ExpenseDTO() {
    }

    public ExpenseDTO(double travelExpense, Bitmap travelImage, double fuelExpense, Bitmap fuelImage, double highwayChargeExpense, Bitmap highwayChargeImage, double parkingExpense, Bitmap parkingImage, double vehicleServiceExpense, Bitmap vehicleServiceImage, double nightOutExpense, Bitmap nightOutImage, double lunchExpense, Bitmap lunchImage, LocalDate expenseDate) {
        this.travelExpense = travelExpense;
        this.travelImage = travelImage;
        this.fuelExpense = fuelExpense;
        this.fuelImage = fuelImage;
        this.highwayChargeExpense = highwayChargeExpense;
        this.highwayChargeImage = highwayChargeImage;
        this.parkingExpense = parkingExpense;
        this.parkingImage = parkingImage;
        this.vehicleServiceExpense = vehicleServiceExpense;
        this.vehicleServiceImage = vehicleServiceImage;
        this.nightOutExpense = nightOutExpense;
        this.nightOutImage = nightOutImage;
        this.lunchExpense = lunchExpense;
        this.lunchImage = lunchImage;
        this.expenseDate = expenseDate;
    }

    public ExpenseDTO(String expenseID, double travelExpense, Bitmap travelImage, double fuelExpense, Bitmap fuelImage, double highwayChargeExpense, Bitmap highwayChargeImage, double parkingExpense, Bitmap parkingImage, double vehicleServiceExpense, Bitmap vehicleServiceImage, double nightOutExpense, Bitmap nightOutImage, double lunchExpense, Bitmap lunchImage, LocalDate expenseDate) {
        this.expenseID = expenseID;
        this.travelExpense = travelExpense;
        this.travelImage = travelImage;
        this.fuelExpense = fuelExpense;
        this.fuelImage = fuelImage;
        this.highwayChargeExpense = highwayChargeExpense;
        this.highwayChargeImage = highwayChargeImage;
        this.parkingExpense = parkingExpense;
        this.parkingImage = parkingImage;
        this.vehicleServiceExpense = vehicleServiceExpense;
        this.vehicleServiceImage = vehicleServiceImage;
        this.nightOutExpense = nightOutExpense;
        this.nightOutImage = nightOutImage;
        this.lunchExpense = lunchExpense;
        this.lunchImage = lunchImage;
        this.expenseDate = expenseDate;
    }

    public String getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(String expenseID) {
        this.expenseID = expenseID;
    }

    public double getTravelExpense() {
        return travelExpense;
    }

    public void setTravelExpense(double travelExpense) {
        this.travelExpense = travelExpense;
    }

    public Bitmap getTravelImage() {
        return travelImage;
    }

    public void setTravelImage(Bitmap travelImage) {
        this.travelImage = travelImage;
    }

    public double getFuelExpense() {
        return fuelExpense;
    }

    public void setFuelExpense(double fuelExpense) {
        this.fuelExpense = fuelExpense;
    }

    public Bitmap getFuelImage() {
        return fuelImage;
    }

    public void setFuelImage(Bitmap fuelImage) {
        this.fuelImage = fuelImage;
    }

    public double getHighwayChargeExpense() {
        return highwayChargeExpense;
    }

    public void setHighwayChargeExpense(double highwayChargeExpense) {
        this.highwayChargeExpense = highwayChargeExpense;
    }

    public Bitmap getHighwayChargeImage() {
        return highwayChargeImage;
    }

    public void setHighwayChargeImage(Bitmap highwayChargeImage) {
        this.highwayChargeImage = highwayChargeImage;
    }

    public double getParkingExpense() {
        return parkingExpense;
    }

    public void setParkingExpense(double parkingExpense) {
        this.parkingExpense = parkingExpense;
    }

    public Bitmap getParkingImage() {
        return parkingImage;
    }

    public void setParkingImage(Bitmap parkingImage) {
        this.parkingImage = parkingImage;
    }

    public double getVehicleServiceExpense() {
        return vehicleServiceExpense;
    }

    public void setVehicleServiceExpense(double vehicleServiceExpense) {
        this.vehicleServiceExpense = vehicleServiceExpense;
    }

    public Bitmap getVehicleServiceImage() {
        return vehicleServiceImage;
    }

    public void setVehicleServiceImage(Bitmap vehicleServiceImage) {
        this.vehicleServiceImage = vehicleServiceImage;
    }

    public double getNightOutExpense() {
        return nightOutExpense;
    }

    public void setNightOutExpense(double nightOutExpense) {
        this.nightOutExpense = nightOutExpense;
    }

    public Bitmap getNightOutImage() {
        return nightOutImage;
    }

    public void setNightOutImage(Bitmap nightOutImage) {
        this.nightOutImage = nightOutImage;
    }

    public double getLunchExpense() {
        return lunchExpense;
    }

    public void setLunchExpense(double lunchExpense) {
        this.lunchExpense = lunchExpense;
    }

    public Bitmap getLunchImage() {
        return lunchImage;
    }

    public void setLunchImage(Bitmap lunchImage) {
        this.lunchImage = lunchImage;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    @Override
    public String toString() {
        return "ExpenseDTO{" +
                "expenseID='" + expenseID + '\'' +
                ", travelExpense=" + travelExpense +
                ", travelImage=" + travelImage +
                ", fuelExpense=" + fuelExpense +
                ", fuelImage=" + fuelImage +
                ", highwayChargeExpense=" + highwayChargeExpense +
                ", highwayChargeImage=" + highwayChargeImage +
                ", parkingExpense=" + parkingExpense +
                ", parkingImage=" + parkingImage +
                ", vehicleServiceExpense=" + vehicleServiceExpense +
                ", vehicleServiceImage=" + vehicleServiceImage +
                ", nightOutExpense=" + nightOutExpense +
                ", nightOutImage=" + nightOutImage +
                ", lunchExpense=" + lunchExpense +
                ", lunchImage=" + lunchImage +
                ", expenseDate=" + expenseDate +
                '}';
    }
}
