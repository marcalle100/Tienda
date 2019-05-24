package app.principal;

import empleado.dao.EmpleadoDAOImp;
import empleado.dominio.Empleado;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;
import tienda.control.GestionTienda;

public class MainApp {

    public static void main(String[] args) {
        
        GestionTienda gestionTienda = new GestionTienda();
        gestionTienda.iniciar();
       
        
    }

}
