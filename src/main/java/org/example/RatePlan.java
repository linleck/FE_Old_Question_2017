package org.example;

public class RatePlan {
    private final String name;
    private final double basicCharge;
    private final TierTable pricingTiers;

    public RatePlan(String name, double basicCharge, TierTable pricingTiers) {
        this.name = name;
        this.basicCharge = basicCharge;
        this.pricingTiers = pricingTiers;
    }

    public String getName() {
        return name;
    }

    public TierTable getPricingTiers() {
        return pricingTiers;
    }

    public int getPrice(double amount) {
        return (int) (basicCharge + pricingTiers.map(amount));
    }
}
