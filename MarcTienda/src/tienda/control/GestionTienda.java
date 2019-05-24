package tienda.control;

import empleado.control.GestionaEmpleados;
import empleado.dao.EmpleadoDAOImp;
import empleado.dominio.Empleado;
import java.util.ArrayList;
import java.util.List;
import producto.control.GestionaProductos;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;
import producto.vista.VistaProducto;
import tienda.vista.VistaTienda;

public class GestionTienda {

    private Empleado empleadoAutenticado;
    private List<Producto> cesta;
    GestionaEmpleados gestionaEmpleados;
    VistaProducto vistaProducto;

    public GestionTienda() {
        empleadoAutenticado = null;
        cesta = new ArrayList<>();
        gestionaEmpleados = new GestionaEmpleados();
        vistaProducto = new VistaProducto();
    }

    public void iniciar() {
        
       gestionaEmpleados.login();
        ProductoDAOImp test = new ProductoDAOImp();
        int i=1;

        empleadoAutenticado = gestionaEmpleados.getEmpleadoAutenticado();
        System.out.println("Bienvenido"+empleadoAutenticado.getNombre());
        VistaTienda.mensajeBienvenida(empleadoAutenticado);

        switch (VistaTienda.opcionDesdeMenuPrincipal()) {
            case HACER_PEDIDO:
           
              
     vistaProducto.menuhacerpedido();
                break;
            case MODIFICAR_PRODUCTO:
              vistaProducto.modmenu();
                break;
            case CAMBIAR_PASSWORD:
            GestionaEmpleados.reescribirpassword();
                break;
            case CERRAR_SESION:
                // cerrarSesion
                break;
        }

    }

}
