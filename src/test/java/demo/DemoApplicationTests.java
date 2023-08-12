package demo;

import org.example.DiscountPlan;
import org.example.DiscountTable;
import org.example.RatePlan;
import org.example.TieredRateTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoApplicationTests {
    RatePlan planA = new RatePlan("プランA", 1123.30,
            new TieredRateTable(0, 19.62, 120, 26.10, 300, 30.12));
    RatePlan planB = new RatePlan("プランB", 1040.10,
            new TieredRateTable(0, 18.17, 120, 24.17, 300, 27.77));
    DiscountPlan discountPlanA = new DiscountPlan("プランA", 1123.30,
            new TieredRateTable(0, 19.62, 120, 26.10, 300, 30.12),
            new DiscountTable(0, 0.01, 5000, 0.03, 8000, 0.03));
    double amount = 200.5;

    @Test
    void 五百四十kWh時のプラン比較テスト() {
        int expectedAmount = 412;
        int actualAmount = planA.getPrice(amount) - planB.getPrice(amount);
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void プランAの五百四十kWh時の割引後の価格正確性テスト() {
        int expectedAmount = 5410;
        int actualAmount = discountPlanA.getPrice(amount);
        assertEquals(expectedAmount, actualAmount);
    }

}
