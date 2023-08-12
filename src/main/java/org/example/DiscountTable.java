package org.example;

public class DiscountTable extends TierTable {
    public DiscountTable(double... tiers) {
        super(tiers);
    }

    public double map(double amount) {
        for (int i = pairs.length - 1; i >= 0; i--) {
            if (amount >= pairs[i][0]) {
                return pairs[i][1];
            }
        }
        throw new IllegalArgumentException("amount = " + amount);
    }
}
