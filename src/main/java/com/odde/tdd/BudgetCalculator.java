package com.odde.tdd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BudgetCalculator {
    private final BudgetRepo br;

    public BudgetCalculator(BudgetRepo br) {
        this.br = br;
    }

    public int calculate(LocalDate start, LocalDate end) {
        int res = 0;
        // if start date is greater than earlier date, then return 0
        if (start.compareTo(end) > 0) return res;
        List<Budget> list = br.findAll();
        List<Integer> budgets = new ArrayList<>();
        list.forEach(budget -> budgets.add(budget.getAmount()));

        int startIndex = start.getMonthValue() - 1;
        int endIndex = end.getMonthValue() - 1;

        if (startIndex == endIndex) {
            int startMonthLength = start.lengthOfMonth();
            res = budgets.get(startIndex) / startMonthLength * (end.getDayOfMonth() - start.getDayOfMonth() + 1);

        } else {
            // calc start month budget
            int startMonthLength = start.lengthOfMonth();
            int startDays = startMonthLength - start.getDayOfMonth() + 1;
            res += budgets.get(startIndex) / startMonthLength * startDays;

            // calc end month budget
            int endMonthLength = end.lengthOfMonth();
            int endDays = end.getDayOfMonth();
            res += budgets.get(endIndex) / endMonthLength * endDays;

            // full months in between
            for (int i = startIndex + 1; i < endIndex; i++) {
                res += budgets.get(i);
            }
        }

        return res;
    }


}
