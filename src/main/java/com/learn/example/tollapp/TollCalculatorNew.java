package com.learn.example.tollapp;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;

public class TollCalculatorNew {

  private static final int DAILY_MAX_TOLL = 60;

  public int getTollFee(Vehicle vehicle, Date... dates) {

    // All dates are guaranteed to be on the same day
    if (dates == null || dates.length == 0 || isTollFreeDate(dates[0]) || isTollFreeVehicle(vehicle)) {
      return 0;
    }

    int tollSumForTheDay = 0;
    int currentIntervalToll = 0;

    Arrays.sort(dates);
    Instant intervalEndInstant = dates[0].toInstant().plus(1, ChronoUnit.HOURS);

    for (Date date : dates) {

      final int currentPassToll = getTollFeeForPass(date, vehicle);
      final Instant currentPass = date.toInstant();
      if (!currentPass.isAfter(intervalEndInstant)) {
        currentIntervalToll = Math.max(currentIntervalToll, currentPassToll);
        continue;
      }
      tollSumForTheDay += currentIntervalToll;
      intervalEndInstant = currentPass.plus(1, ChronoUnit.HOURS);
      currentIntervalToll = currentPassToll;

    }
    tollSumForTheDay += currentIntervalToll;
    return Math.min(DAILY_MAX_TOLL , tollSumForTheDay);
  }

  public int getTollFeeForPass(final Date date, Vehicle vehicle) {
    return 0;
  }

  private boolean isTollFreeVehicle(Vehicle vehicle) {

    return false;
  }

  private boolean isTollFreeDate(Date date) {
    return false;
  }

}
