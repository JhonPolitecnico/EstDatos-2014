package Main;

/***********************************************************************
 * Module:  Venta.java
 * Author:  Hax0r
 * Purpose: Defines the Class Venta
 ***********************************************************************/

import java.util.*;

/** @pdOid 8d973a63-cef1-4e3a-860a-ac569c31583c */
public class Venta {
   /** @pdOid 42c191fd-33bb-4d64-861f-0f66a86b0733 */
   private Date date;
   
   /** @pdRoleInfo migr=no name=MetodoPago assc=ventaMetodoPago coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Composition */
   private java.util.Collection<MetodoPago> metodoPago;
   /** @pdRoleInfo migr=no name=Articulo assc=ventaArticulo coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Aggregation */
   private java.util.Collection<Articulo> articulo;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<MetodoPago> getMetodoPago() {
      if (metodoPago == null)
         metodoPago = new java.util.HashSet<MetodoPago>();
      return metodoPago;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMetodoPago() {
      if (metodoPago == null)
         metodoPago = new java.util.HashSet<MetodoPago>();
      return metodoPago.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMetodoPago */
   public void setMetodoPago(java.util.Collection<MetodoPago> newMetodoPago) {
      removeAllMetodoPago();
      for (java.util.Iterator iter = newMetodoPago.iterator(); iter.hasNext();)
         addMetodoPago((MetodoPago)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMetodoPago */
   public void addMetodoPago(MetodoPago newMetodoPago) {
      if (newMetodoPago == null)
         return;
      if (this.metodoPago == null)
         this.metodoPago = new java.util.HashSet<MetodoPago>();
      if (!this.metodoPago.contains(newMetodoPago))
         this.metodoPago.add(newMetodoPago);
   }
   
   /** @pdGenerated default remove
     * @param oldMetodoPago */
   public void removeMetodoPago(MetodoPago oldMetodoPago) {
      if (oldMetodoPago == null)
         return;
      if (this.metodoPago != null)
         if (this.metodoPago.contains(oldMetodoPago))
            this.metodoPago.remove(oldMetodoPago);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMetodoPago() {
      if (metodoPago != null)
         metodoPago.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Articulo> getArticulo() {
      if (articulo == null)
         articulo = new java.util.HashSet<Articulo>();
      return articulo;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorArticulo() {
      if (articulo == null)
         articulo = new java.util.HashSet<Articulo>();
      return articulo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newArticulo */
   public void setArticulo(java.util.Collection<Articulo> newArticulo) {
      removeAllArticulo();
      for (java.util.Iterator iter = newArticulo.iterator(); iter.hasNext();)
         addArticulo((Articulo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArticulo */
   public void addArticulo(Articulo newArticulo) {
      if (newArticulo == null)
         return;
      if (this.articulo == null)
         this.articulo = new java.util.HashSet<Articulo>();
      if (!this.articulo.contains(newArticulo))
         this.articulo.add(newArticulo);
   }
   
   /** @pdGenerated default remove
     * @param oldArticulo */
   public void removeArticulo(Articulo oldArticulo) {
      if (oldArticulo == null)
         return;
      if (this.articulo != null)
         if (this.articulo.contains(oldArticulo))
            this.articulo.remove(oldArticulo);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllArticulo() {
      if (articulo != null)
         articulo.clear();
   }
   
   /** @pdOid 1002aa5c-9106-4806-8ab2-e53c5f27d50d */
   public Date getDate() {
      return date;
   }
   
   /** @param newDate
    * @pdOid cc91c836-4f6b-41c6-be0c-0e391ecba8b4 */
   public void setDate(Date newDate) {
      date = newDate;
   }

}