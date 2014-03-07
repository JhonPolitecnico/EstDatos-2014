package Main;

/***********************************************************************
 * Module:  MetodoPago.java
 * Author:  Hax0r
 * Purpose: Defines the Class MetodoPago
 ***********************************************************************/

import java.util.*;

/** @pdOid 982ac153-2b97-452c-8244-e92fa5ac8e0b */
public class MetodoPago {
   /** @pdRoleInfo migr=no name=Efectivo assc=metodoPagoEfectivo mult=0..1 type=Composition */
   private Efectivo efectivo;
   /** @pdRoleInfo migr=no name=Cheque assc=metodoPagoCheque mult=0..1 type=Composition */
   private Cheque cheque;
   /** @pdRoleInfo migr=no name=Tarjeta assc=metodoPagoTarjeta mult=0..1 type=Composition */
   private Tarjeta tarjeta;

}