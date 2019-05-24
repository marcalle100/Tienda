package producto.dao;

import conexion.ConexionBD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import producto.dominio.Producto;

public class ProductoDAOImp implements ProductoDAO {

    @Override
    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        //definir un formato numero segun la region
        NumberFormat formatoNumero = NumberFormat.getInstance(Locale.FRANCE);
        Number numero;
        String lineDatos;

        try (BufferedReader archivo = Files.newBufferedReader(Paths.get("producto3.txt"))) {
            while (archivo.readLine() != null) {

                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineDatos);
                int codigo = numero.intValue();
                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                String nombre = lineDatos;
                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                String descripcion = lineDatos;
                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineDatos);
                double precio = numero.doubleValue();
                Producto pro = new Producto(codigo, nombre, descripcion, precio);
                productos.add(pro);
            }
        } catch (ParseException e) {
            System.out.println("exce");
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println("exce");
            System.out.println(ex.getMessage());
        }

        return productos;

    }

    @Override
    public boolean actualizarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void reescribirproducto(List<Producto> product) {
        try {
            BufferedWriter reescribir = Files.newBufferedWriter(Paths.get("producto3.txt"));
            for (Producto producto : product) {
                reescribir.write("[Producto]\n");
                reescribir.write("[codigo]\n");
                reescribir.write(String.format("%d%n", producto.getCodigo()));
                reescribir.write("[nombre]\n");
                reescribir.write(String.format("%s%n", producto.getNombre()));
                reescribir.write("[descripcion]\n");
                reescribir.write(String.format("%s%n", producto.getDescripcion()));
                reescribir.write("[precio]\n");
                reescribir.write(String.format("%.2f%n", producto.getPrecio()));
            }
            reescribir.close();
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
