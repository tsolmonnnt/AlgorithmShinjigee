public class MegaStore {

    public enum DiscountType {
        Standard,//weight any 6%
        Seasonal,//12% weight is any
        Weight;// (weight <= 10 , 6% discount) (weight > 10,18%)
    }
    
    public static double getDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType) {

        if(discountType.equals(DiscountType.Standard)){
            return totalPrice - totalPrice*0.06;
        }
        else if(discountType.equals(DiscountType.Seasonal)){
            return totalPrice - totalPrice*0.12;
        }
        else{
            if(cartWeight <= 10 && cartWeight > 0)
            {
                return totalPrice - totalPrice * 0.06;
            }
            else{
                return totalPrice - totalPrice * 0.18;
            }

        }
        // throw new UnsupportedOperationException("Waiting to be implemented.");
        
    }
    
    public static void main(String[] args) {        
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));
    }
}