package Main;

/***********************************************************************
 * Module:  Almacen.java
 * Author:  Hax0r
 * Purpose: Defines the Class Almacen
 ***********************************************************************/

import java.util.*;

/** @pdOid 9a76cab3-0b62-49e1-a269-f833d180624d */
public class Almacen {
   /** @pdOid feae6daf-8e0e-48a4-af96-7f66c553bf93 */
   private String name;
   /** @pdOid b3979054-768f-4b94-b761-7fdcd380f64d */
   private String address;
   
   /** @pdRoleInfo migr=no name=Cliente assc=almacenCliente coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Cliente> cliente;
   /** @pdRoleInfo migr=no name=Empleado assc=almacenEmpleado coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Aggregation */
   private java.util.Collection<Empleado> empleado;
   /** @pdRoleInfo migr=no name=Articulo assc=almacenArticulo coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Articulo> articulo;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Cliente> getCliente() {
      if (cliente == null)
         cliente = new java.util.HashSet<Cliente>();
      return cliente;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCliente() {
      if (cliente == null)
         cliente = new java.util.HashSet<Cliente>();
      return cliente.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCliente */
   public void setCliente(java.util.Collection<Cliente> newCliente) {
      removeAllCliente();
      for (java.util.Iterator iter = newCliente.iterator(); iter.hasNext();)
         addCliente((Cliente)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCliente */
   public void addCliente(Cliente newCliente) {
      if (newCliente == null)
         return;
      if (this.cliente == null)
         this.cliente = new java.util.HashSet<Cliente>();
      if (!this.cliente.contains(newCliente))
         this.cliente.add(newCliente);
   }
   
   /** @pdGenerated default remove
     * @param oldCliente */
   public void removeCliente(Cliente oldCliente) {
      if (oldCliente == null)
         return;
      if (this.cliente != null)
         if (this.cliente.contains(oldCliente))
            this.cliente.remove(oldCliente);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCliente() {
      if (cliente != null)
         cliente.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Empleado> getEmpleado() {
      if (empleado == null)
         empleado = new java.util.HashSet<Empleado>();
      return empleado;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorEmpleado() {
      if (empleado == null)
         empleado = new java.util.HashSet<Empleado>();
      return empleado.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newEmpleado */
   public void setEmpleado(java.util.Collection<Empleado> newEmpleado) {
      removeAllEmpleado();
      for (java.util.Iterator iter = newEmpleado.iterator(); iter.hasNext();)
         addEmpleado((Empleado)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newEmpleado */
   public void addEmpleado(Empleado newEmpleado) {
      if (newEmpleado == null)
         return;
      if (this.empleado == null)
         this.empleado = new java.util.HashSet<Empleado>();
      if (!this.empleado.contains(newEmpleado))
         this.empleado.add(newEmpleado);
   }
   
   /** @pdGenerated default remove
     * @param oldEmpleado */
   public void removeEmpleado(Empleado oldEmpleado) {
      if (oldEmpleado == null)
         return;
      if (this.empleado != null)
         if (this.empleado.contains(oldEmpleado))
            this.empleado.remove(oldEmpleado);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllEmpleado() {
      if (empleado != null)
         empleado.clear();
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
   
   /** @pdOid d6f2faf8-0742-4a50-8488-526cb7ce4544 */
   public String getName() {
      return name;
   }
   
   /** @param newName
    * @pdOid 9cd58dd8-a801-4153-aae7-f20c85c3cdd7 */
   public void setName(String newName) {
      name = newName;
   }
   
   /** @pdOid 6658aa16-2e7f-4355-b7ee-d5521eb8d6ef */
   public String getAddress() {
      return address;
   }
   
   /** @param newAddress
    * @pdOid f0980237-91e7-4eca-b54f-7b1ae8bda94f */
   public void setAddress(String newAddress) {
      address = newAddress;
   }

}