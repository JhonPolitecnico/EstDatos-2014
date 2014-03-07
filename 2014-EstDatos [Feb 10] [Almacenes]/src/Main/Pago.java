package Main;

/***********************************************************************
 * Module:  Pago.java
 * Author:  Hax0r
 * Purpose: Defines the Class Pago
 ***********************************************************************/

import java.util.*;

/** @pdOid efcf397c-105c-4417-af4d-060c3cc290d9 */
public class Pago {
   /** @pdOid 5bc95261-6449-4356-8cbf-e6413c282e1d */
   private double value;
   
   /** @pdOid f2e31e64-ad26-4852-a615-d4b52186d052 */
   public double getValue() {
      return value;
   }
   
   /** @param newValue
    * @pdOid 30d02277-a3a2-4e09-9355-6c584f260a90 */
   public void setValue(double newValue) {
      value = newValue;
   }

}