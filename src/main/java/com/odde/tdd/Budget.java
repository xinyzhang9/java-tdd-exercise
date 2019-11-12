package com.odde.tdd;

import java.time.YearMonth;

public class Budget {
    private final YearMonth month;
    private final int amount;

    public Budget(YearMonth month, int amount) {
        this.month = month;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public YearMonth getMonth() {
        return month;
    }
}
