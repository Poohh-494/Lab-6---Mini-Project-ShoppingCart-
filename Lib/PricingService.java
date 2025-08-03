package Lib;
import Lib.Discount.*;
import java.util.ArrayList;

/**
 * คลาสสำหรับจัดการโปรโมชั่นและคำนวณราคา
 */
public class PricingService {
    private record StrategyRule(String sku, DiscountStrategy strategy) {
    private final ArrayList<StrategyRule> strategies = new ArrayList<>();
    private final DiscountStrategy defaultStrategy = new DefaultPricingStralegy();

    /**
     * 
     */
   } 
}
