package Main;

/***********************************************************************
 * Module:  Empleado.java
 * Author:  Hax0r
 * Purpose: Defines the Class Empleado
 ***********************************************************************/

import java.util.*;

/** @pdOid 0590b5ef-e562-4f96-bc0c-4782f17eab15 */
public class Empleado extends Persona {
   /** @pdOid 840e7017-61d5-4caa-8798-0a57b530ac1d */
   private String eps;
   /** @pdOid 1c7fc4d6-44b9-4c37-bda7-a10522b3e44d */
   private String arp;
   /** @pdOid 37e32d04-d429-44d0-a9f7-8f7e150629e4 */
   private double salary;
   
   /** @pdOid 501b46d9-75e6-4c85-9f97-3479e9ed39cb */
   public String getEps() {
      return eps;
   }
   
   /** @param newEps
    * @pdOid e102d7fd-0b94-4269-a76a-9907a56d6780 */
   public void setEps(String newEps) {
      eps = newEps;
   }
   
   /** @pdOid 06889596-fab2-4b17-9651-9201983a8060 */
   public String getArp() {
      return arp;
   }
   
   /** @param newArp
    * @pdOid 4469f9d2-270d-4549-b970-2638f8f62984 */
   public void setArp(String newArp) {
      arp = newArp;
   }
   
   /** @pdOid ee3ef40b-3f5b-4f69-bbd7-161ffb1a8c09 */
   public double getSalary() {
      return salary;
   }
   
   /** @param newSalary
    * @pdOid 65865553-0570-4a8d-a021-ad3cfff7e38a */
   public void setSalary(double newSalary) {
      salary = newSalary;
   }

}