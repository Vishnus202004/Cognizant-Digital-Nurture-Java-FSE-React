package com.financial.forecasting;

public class FinancialForecasting {


 
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // 1. Base Case: If no years remain, the value is just the current present value.
        if (periods == 0) {
            return presentValue;
        }

        // 2. Recursive Case: Compute value for (periods - 1) and apply compounding for 1 year.
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }
}