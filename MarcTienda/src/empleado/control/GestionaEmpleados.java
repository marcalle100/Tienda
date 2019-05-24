package empleado.control;

import empleado.dao.EmpleadoDAOImp;
import empleado.dominio.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import util.Color;

public class GestionaEmpleados {

    ControladorEmpleado controlador;
    Empleado empleadoAutenticado;

    public GestionaEmpleados() {
        this.controlador = new ControladorEmpleado();
        this.empleadoAutenticado = null;
    }

    public void login() {
        Scanner leerTeclado = new Scanner(System.in);
        boolean esEmpleadoValido = false;
        boolean esPasswordValido = false;
        int codigoEntrada;
        String passwordEntrada;
        boolean logincorrecto=false;
        do {            
            
      
        System.out.println("Bienvenido a la tienda");
        System.out.println("***************************************");

        System.out.print("Introduce el código de tu usuario: ");
        while (!leerTeclado.hasNextInt()) {
            System.out.println(Color.ERROR + "Debe escribir un valor numérico" + Color.DEFAULT);
            System.out.print("Introduce el código de tu usuario: ");
            leerTeclado.next();
        }
         codigoEntrada = leerTeclado.nextInt();

        System.out.print("Introduce tu contraseña: ");
        passwordEntrada = leerTeclado.next();
        logincorrecto=logincorrecto(passwordEntrada, codigoEntrada);
        if (logincorrecto==false){
            System.out.println("Login incorrecto");
            System.out.println("");
        }
  } while (logincorrecto(passwordEntrada, codigoEntrada)==false);
        System.out.println("***************************************");
        System.out.println("Login correcto");
        
       // empleadoAutenticado = controlador.getEmpleadoPorCodigo(codigoEntrada);
       /* if (empleadoAutenticado != null) {
            esEmpleadoValido = true;
            if (passwordEntrada.equals(empleadoAutenticado.getPassword())) {
                esPasswordValido = true;
            }
        }

        if (!esEmpleadoValido) {
            //throw new ;
            System.out.println("Usuario incorrecto");
        } else if (!esPasswordValido) {
            //throw new ;
            System.out.println("Contraseña incorrecta");
        }*/


    }
        public boolean logincorrecto(String contraseña, int codigo){
            List<Empleado> acceso = new ArrayList<>();
            boolean usuarioautenticado=false;
            acceso=controlador.leerEmpleados();
            for (Empleado empleado : acceso) {
                if(empleado.getCodigo()==codigo && empleado.getPassword().equals(contraseña)){
                usuarioautenticado=true;
                empleadoAutenticado=empleado;
                }
            }
            return usuarioautenticado;
        }
    public Empleado getEmpleadoAutenticado() {
        return empleadoAutenticado;
    }
     public static void reescribirpassword() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce nuevo password (tiene que ser numerico)");
        String nuevopassword = lector.next();
        EmpleadoDAOImp emple = new EmpleadoDAOImp();
        List<Empleado> empleados =emple.leerEmpleados();
        for (Empleado empleado : empleados) {
            empleado.setPassword(nuevopassword);
            EmpleadoDAOImp.modificarPassword(empleados);
            
        }
    }
    
}
 


