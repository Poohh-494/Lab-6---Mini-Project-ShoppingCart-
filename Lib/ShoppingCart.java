package Lib;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final PricingService pricingService;
    private final ProductCatalog catalog;
    private final List<CartItem> items = new ArrayList<>();;

    public ShoppingCart(PricingService pricingService, ProductCatalog catalog) {
        this.pricingService = pricingService;
        this.catalog = catalog;
    }
    
    /** 
    * เพิ่มสินค้าในตะกร้า
    */

    public void addItem(String productId, int quantity) {
        Product product = catalog.findById(productId);
        if (product == null || quantity <=0) return;

        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            if (item.getProduct().getProductId().equals(productId)) {
                items.set(i, new CartItem(product, item.getQuantity() + quantity));
                return;
            }
        }
        
        items.add(new CartItem(product, quantity));
    }

    /**
    * เอาสินค้าในตะกร้าออก
    */

    public void removeItem(String productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getProductId().equals(productId)) {
                items.remove(i);
                break;
            }
        }
    }

    /**
    * ล้างสินค้าในตะกร้า
    */

    public void clearCart() {
        items.clear();
    }

    /**
    * @return จำนวนสินค้าในตะกร้า
    */

    public int getItemCount() {
        return items.size();
    }

    /**
    * @return ราคาสินค้า
    */

    public double getTotalPrice() {
        double total = 0.0;
        for (CartItem item : items) {
            total += pricingService.calculateItemPrice(item);
        }
        return total;
    }
}