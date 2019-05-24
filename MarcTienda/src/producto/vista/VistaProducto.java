package producto.vista;
import java.util.Scanner;
import producto.control.GestionaProductos;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;
import tienda.vista.VistaTienda;
import static tienda.vista.VistaTienda.muestraMensaje;

import util.Color;
public class VistaProducto {
    GestionaProductos gestionaProductos = new GestionaProductos();
    
public void menuhacerpedido(){
    
    System.out.println("*************************************************");
     ProductoDAOImp test = new ProductoDAOImp();
     int i=1;
    int opcion;
      System.out.println("PRODUCTOS************************");
       for (Producto leerProducto : test.leerProductos()) {
           System.out.println(i+"\t"+leerProducto.toString());
           i++;
       }
    System.out.println("Elige producto:");
    int opcion2;
    opcion2=pedirOpcionEnRango(1, test.leerProductos().size())-1;
    System.out.println("************************************************");
    System.out.println("1.Añadir producto a la cesta \n2.Visualizar precio total \n3.Imprimir factura \n4.Terminar pedido");
    opcion=pedirOpcionEnRango(1, 4);
    switch (opcion){
        case 1:
            gestionaProductos.añadirproducto(opcion2);
            menuhacerpedido();
            break;
        case 2:
            gestionaProductos.visualizarpreciototal(opcion2);
            menuhacerpedido();
            break;
        case 3:
            gestionaProductos.imprimirfactura(opcion2);
            menuhacerpedido();
            break;
        case 4:
            VistaTienda.opcionDesdeMenuPrincipal();
                break;
    }
}
  private static int pedirOpcionEnRango(int min, int max) {

        Scanner leerTeclado = new Scanner(System.in);
        int opcion = 0;
        boolean hayError = true;

        while (hayError) {
            System.out.print("Seleccione una opción: ");
            if (leerTeclado.hasNextInt()) {
                opcion = leerTeclado.nextInt();
                hayError = opcion < min || opcion > max;
                if (hayError) {
                    muestraMensaje("Error, opción no válida. Debe ser entre [" + min + "," + max + "]", Color.ERROR);
                }
            } else {
                muestraMensaje("Error, opción no válida. Debe ser entre [" + min + "," + max + "]", Color.ERROR);
                leerTeclado.next();
            }
        }

        return opcion;
    }
  public void modmenu (){
   System.out.println("*************************************************");
     ProductoDAOImp test = new ProductoDAOImp();
     int i=1;
    int opcion;
      System.out.println("PRODUCTOS************************");
       for (Producto leerProducto : test.leerProductos()) {
           System.out.println(i+"\t"+leerProducto.toString());
           i++;
       }
    System.out.println("Elige producto:");
    int opcion2;
    opcion2=pedirOpcionEnRango(1, test.leerProductos().size())-1;
    System.out.println("************************************************");
    System.out.println("1.Modificar nombre \n2.Modificar precio \n3.Modificar codigo");
    opcion=pedirOpcionEnRango(1, 3);
    switch (opcion){
        case 1:
               gestionaProductos.modificarnombre(opcion2);
               for (Producto leerProducto : test.leerProductos()) {
           System.out.println(i+"\t"+leerProducto.toString());
           i++;
       }
             VistaTienda.opcionDesdeMenuPrincipal();
            break;
        case 2:
             gestionaProductos.modificarprecio(opcion2);
             VistaTienda.opcionDesdeMenuPrincipal();
            break;
        case 3:
           gestionaProductos.modificarcodigo(opcion2);
             VistaTienda.opcionDesdeMenuPrincipal();
            break;
      
    }
  }
}
