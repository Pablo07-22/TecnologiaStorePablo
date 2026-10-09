package Controlador.MenuAdmin;

import Controlador.Empleado.ActualizarEmpleado;
import Controlador.Empleado.AgregarEmpleado;
import Controlador.Empleado.EliminarEmpleado;
import Controlador.Empleado.ListarEmpleado;
import Dao.Empleados.ActualizarEmpleadoDao;
import Vista.MenuAdminEmpleado.MenuEmpleados;
import Vista.Validaciones.Validaciones;
import modelo.Empleado;

public class MenuAdminEmpleados {
    public void MenuAdminEmpleados(){
        MenuEmpleados m = new MenuEmpleados();
        int op;
        do{
            op=m.MenuAdminEmpleados();
            switch (op) {
               case 1:
                    AgregarEmpleado ae = new AgregarEmpleado();
                    ae.Agregar();
                    break;
               case 2:
                   EliminarEmpleado ee = new EliminarEmpleado();
                   ee.Eliminar();
                   break;
               case 3: 
                   ListarEmpleado le = new ListarEmpleado();
                   le.Listar();
                   break;
               case 4: 
                   ActualizarEmpleado acte = new ActualizarEmpleado();
                   acte.Actualizar();
                   break;
               case 5: 
                   System.out.println("============Regresando===========");
                   MenusAdminCelulares ma = new MenusAdminCelulares();
                   ma.MenuAdmin();
                   break;
               default:
                   System.out.println("Opcion no encontrada");
            }
        }while(op!=5);
    }
    
    public void MenuAdminActualizarEmpleado (Empleado empleado){
      MenuEmpleados m = new MenuEmpleados();
      ActualizarEmpleadoDao aed = new ActualizarEmpleadoDao();
      Validaciones v = new Validaciones();
      int op;
      do{
          op=m.MenuActualizarEmpleados();
          switch (op) {
              case 1:
                  empleado.setNombre(v.validar_solo_letras("Ingrese el nuevo nombre del empleado "));
                  aed.ActualizarEmpleado(empleado);
                  break;
              case 2:
                  empleado.setTelefono(v.validar_texto("Ingrese el nuevo Telefono del empleado"));
                  aed.ActualizarEmpleado(empleado);
                  break;
              case 3:
                  System.out.println("========= Regresando ======");
                  MenuAdminEmpleados();
              default:
                  throw new AssertionError();
          }
      }while(op!=3);
    }
}
