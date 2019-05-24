package producto.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;

public class GestionaProductos {

    private List<Producto> factura = new ArrayList<>();
    ProductoDAOImp productoDAOImp = new ProductoDAOImp();

    public void añadirproducto(int opcion) {
        ProductoDAOImp test = new ProductoDAOImp();
        Producto productodeseado = test.leerProductos().get(opcion);
        factura.add(productodeseado);
    }

    public void visualizarpreciototal(int opcion) {
        double preciototal = 0.0;
        for (Producto producto : factura) {
            preciototal += producto.getPrecio();

        }
        System.out.println("precio de la factura " + preciototal);
    }

    public void imprimirfactura(int opcion) {
        System.out.println("factura");
        for (Producto producto : factura) {
            System.out.println(producto.toString());
        }
    }

    public void modificarnombre(int opcion) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el codigo del producto ");
        int codigo = lector.nextInt();
        System.out.println("Introduce nuevo nombre");
        String nuevonombre = lector.next();
        ProductoDAOImp test = new ProductoDAOImp();
        List<Producto> productos = test.leerProductos();
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                producto.setNombre(nuevonombre);
                productoDAOImp.reescribirproducto(productos);
                break;
            }
        }
       

    }

    public void modificarcodigo(int opcion) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el codigo del producto");
        int codigo= lector.nextInt();
        System.out.println("Introduce nuevo codigo");
        int nuevocodigo = lector.nextInt();
        ProductoDAOImp test = new ProductoDAOImp();
        List<Producto> productos =test.leerProductos();
        for (Producto producto : productos) {
            if(producto.getCodigo() == codigo){
            producto.setCodigo(nuevocodigo);
             productoDAOImp.reescribirproducto(productos);
             break;
            }
        }
    }

    public void modificarprecio(int opcion) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el codigo del producto");
        int codigo=lector.nextInt();
        System.out.println("Introduce nuevo precio");
        double nuevoprecio= lector.nextDouble();
        ProductoDAOImp test = new ProductoDAOImp();
        List<Producto> productos = test.leerProductos();
        for (Producto producto : productos) {
            if(producto.getCodigo()==codigo){
            producto.setPrecio(nuevoprecio);
            productoDAOImp.reescribirproducto(productos);
            break;
            }
            
        }
    }

}
