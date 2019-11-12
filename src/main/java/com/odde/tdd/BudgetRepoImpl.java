package com.odde.tdd;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class BudgetRepoImpl implements BudgetRepo {
    @Override
    public List<Budget> findAll() {
        List<Budget> res = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            YearMonth ym = YearMonth.of(2019, i);
            res.add(new Budget(ym, ym.lengthOfMonth() * 10));
        }
        return res;
    }
}
