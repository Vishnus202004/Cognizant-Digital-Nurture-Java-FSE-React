package com.financial.forecasting;

public class ForecastingTest {
    public static void main(String[] args) {
        System.out.println("=== Running Financial Forecasting Tool ===\n");

        double initialInvestment = 1000.0; // Starting with $1000
        double annualGrowthRate = 0.05;    // 5% constant annual growth
        int forecastYears = 5;             // Predicting 5 years into the future

        System.out.println("Initial Present Value: $" + initialInvestment);
        System.out.println("Assumed Growth Rate: " + (annualGrowthRate * 100) + "% annually");
        System.out.println("Forecasting Range: " + forecastYears + " years\n");

        // Execute prediction calculation
        double predictedValue = FinancialForecasting.calculateFutureValue(initialInvestment, annualGrowthRate, forecastYears);

        System.out.println("--- Forecast Results ---");
        System.out.printf("Predicted Future Value after %d years: $%.2f%n", forecastYears, predictedValue);
    }
}