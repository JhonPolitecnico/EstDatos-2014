package Main;

/***********************************************************************
 * Module:  Articulo.java
 * Author:  Hax0r
 * Purpose: Defines the Class Articulo
 ***********************************************************************/

import java.util.*;

/** @pdOid 992ceebe-3a67-4b26-b0f7-f5461cab774f */
public class Articulo {
   /** @pdOid 013d1a01-8f63-46ee-bea4-43a02df60799 */
   private String type;
   /** @pdOid 3139a1e7-b3ef-47c3-94c3-2b13b5d582a2 */
   private int size;
   /** @pdOid 414537cc-dc3f-4e97-93cd-5ad89059d2f0 */
   private String color;
   /** @pdOid 2d236a57-1d02-4f10-ac88-098fc4116991 */
   private int value;
   /** @pdOid c5134cad-4ffb-4519-851f-fec7de3c2134 */
   private int stock;
   
   /** @pdOid 400dc98f-4b00-436f-a2e5-1852bb3db264 */
   public String getType() {
      return type;
   }
   
   /** @param newType
    * @pdOid fa660367-8fa9-41d5-949f-541374da256e */
   public void setType(String newType) {
      type = newType;
   }
   
   /** @pdOid e1b383c2-441d-450e-9513-1dd10247837a */
   public int getSize() {
      return size;
   }
   
   /** @param newSize
    * @pdOid 0092db2a-e00c-435c-9ff3-e61cebe10840 */
   public void setSize(int newSize) {
      size = newSize;
   }
   
   /** @pdOid 3ec2b609-ad20-4021-bcc2-224ccbca05c8 */
   public String getColor() {
      return color;
   }
   
   /** @param newColor
    * @pdOid 3b590806-6730-4104-a967-20d68668efdf */
   public void setColor(String newColor) {
      color = newColor;
   }
   
   /** @pdOid e37a3bac-f384-42cb-9110-24ff14ba28cc */
   public int getValue() {
      return value;
   }
   
   /** @param newValue
    * @pdOid cf6e8a1e-fb71-46d0-99dc-7d5b5852aa3e */
   public void setValue(int newValue) {
      value = newValue;
   }
   
   /** @pdOid 8cdff9ee-60ee-487d-95fa-8668884fc8e3 */
   public int getStock() {
      return stock;
   }
   
   /** @param newStock
    * @pdOid 6a343005-0dfb-45eb-b6c7-bba7b34b3b8d */
   public void setStock(int newStock) {
      stock = newStock;
   }

}