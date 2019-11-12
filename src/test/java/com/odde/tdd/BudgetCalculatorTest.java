package com.odde.tdd;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class BudgetCalculatorTest {
    BudgetRepo br = new BudgetRepoImpl();
    BudgetCalculator bc = new BudgetCalculator(br);

    @Test
    public void sameMonthInvalidDate() {
        int res = bc.calculate(
                LocalDate.of(2019, Month.SEPTEMBER, 25),
                LocalDate.of(2019, Month.SEPTEMBER, 20));
        assertEquals(0, res);
    }

    @Test
    public void differentMonthInvalidDate() {
        int res = bc.calculate(
                LocalDate.of(2019, Month.SEPTEMBER, 1),
                LocalDate.of(2019, Month.JULY, 20));
        assertEquals(0, res);
    }

    @Test
    public void sameDay() {
        int res = bc.calculate(
                LocalDate.of(2019, Month.SEPTEMBER, 25),
                LocalDate.of(2019, Month.SEPTEMBER, 25));
        assertEquals(10, res);
    }

    @Test
    public void sameMonth() {
        int res = bc.calculate(
                LocalDate.of(2019, Month.SEPTEMBER, 25),
                LocalDate.of(2019, Month.SEPTEMBER, 26));
        assertEquals(20, res);
    }

    @Test
    public void differentMonth() {
        int res = bc.calculate(
                LocalDate.of(2019, Month.SEPTEMBER, 25),
                LocalDate.of(2019, Month.NOVEMBER, 10));
        assertEquals(470, res);
    }

}
