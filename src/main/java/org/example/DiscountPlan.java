package org.example;

public class DiscountPlan extends RatePlan {
    private final TierTable discountTiers;

    public DiscountPlan(String name, double basicCharge, TierTable pricingTiers, TierTable discountTiers) {
        super(name, basicCharge, pricingTiers);
        this.discountTiers = discountTiers;
    }

    public TierTable getDiscountTiers() {
        return discountTiers;
    }

    public int getPrice(double amount) {
        int price = super.getPrice(amount);
        return (int) (price * (1.0 - discountTiers.map(price)));
    }
}
