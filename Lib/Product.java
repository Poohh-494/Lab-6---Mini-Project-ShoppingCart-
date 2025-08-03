package Lib;

public final class Product{

        private final String productId;
        private final String productName;
        private final double price;
        public Object equals;

        // Rep Invariant (RI):
        // - productId and productName are not null or blank.
        // - price >= 0.
        //
        // Abstraction Function (AF):
        // - AF(productId, productName, price) = A product with the gi


        /**
         * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
         */
        private void checkRep(){
            if (productId == null || productId.isBlank()){
                throw new RuntimeException("RI violated: product");
            }
            if (productName == null || productName.isBlank()){
                throw new RuntimeException("RI violated: product");
            }
            if (price < 0){
                throw new RuntimeException("RI violated: product");
            }
        }
    /**
     * สร้างอ็อบเจกต์ Product
     * @param productId รหัสสินค้า ห้ามเป็นค่าว่าง
     * @param productName ชื่อสินค้า ห้ามเป็นค่าว่าง
     * @param price ราคาไม่ติดลบ
     * @throws IllegalArgumentException หากคุณสมบัติ
     */
        public Product(String productId, String productName, double price){
            this.productId = productId;
            this.productName = productName;
            this.price = price;
            checkRep(); // ตรวจสอบความถูกต้องทุกครั้งที่สร้าง
            }
    /**
     * @return รหัสสินค้า
     */
        public String getProductId(){return productId; }
        /**
         * @return ชื่อสินค้า
         */
        public String getProductName(){return productName; }
        /**
         * @return ชื่อสินค้า
         */
        public double getPrice(){return price; }

}
