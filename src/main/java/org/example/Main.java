package org.example;

public class Main {
    public static void main(String[] args) {
        RatePlan planA = new RatePlan("プランA", 1123.30,
                new TieredRateTable(0, 19.62, 120, 26.10, 300, 30.12));
        RatePlan planB = new RatePlan("プランB", 1040.10,
                new TieredRateTable(0, 18.17, 120, 24.17, 300, 27.77));
        DiscountPlan discountPlanA = new DiscountPlan("プランA", 1123.30,
                new TieredRateTable(0, 19.62, 120, 26.10, 300, 30.12),
                new DiscountTable(0, 0.01, 5000, 0.03, 8000, 0.03));

        double amount = 543.0;
        System.out.printf("プランAで543.0kWhのときの電気料金: %d円\n", planA.getPrice(amount));
        System.out.printf("プランBで543.0kWhのときの電気料金: %d円\n", planB.getPrice(amount));
        int d = planA.getPrice(amount) - planB.getPrice(amount);
        if (d < 0) {
            System.out.printf("%sが%d円安い\n", planA.getName(), -d);
        } else if (d > 0) {
            System.out.printf("%sが%d円安い\n", planB.getName(), d);
        } else {
            System.out.println("両プランで同額");
        }
        System.out.printf("プランAの543.0kWhの割引率；%.1f%%\n", discountPlanA.getDiscountTiers().map(amount) * 100);
        System.out.printf("割引後の価格: %d円\n", discountPlanA.getPrice(amount));
        System.out.printf("節約できた価格: %d円\n", planA.getPrice(amount) - discountPlanA.getPrice(amount));
    }
}