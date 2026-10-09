package Controlador.MenuAdmin;

import Controlador.Celular.ActualizarCelular;
import Controlador.Celular.AgregarCelular;
import Controlador.Celular.EliminarCelular;
import Controlador.GestionMenuPrincipal;
import Controlador.Celular.ListarCelular;
import Vista.Validaciones.Validaciones;
import Dao.Celular.ActualizarCelularDao;
import Vista.MenuPrincipalCelulares.MenuAdminCelulares;
import Vista.MenuPrincipalCelulares.MenuPrincipalAdmin;
import modelo.CategoriaGama;
import modelo.Celular;
import modelo.Marca;
import modelo.SistemaOperativo;

public class MenusAdminCelulares {
  public void MenuAdmin(){
   MenuPrincipalAdmin mpa = new MenuPrincipalAdmin();
   int op;
   do{
       op = mpa.MenuPrincipalAdmin();
       switch (op) {
           case 1:
               MenuAdminCelulares();
               break;
           case 2:
               MenuAdminEmpleados mae = new MenuAdminEmpleados();
               mae.MenuAdminEmpleados();
               break;
           case 3:
               System.out.println("Reporte ventas Realizadas");
               break;
           case 4:
               System.out.println("Informacion celulares");
               break;
           case 5:
               GestionMenuPrincipal gm = new GestionMenuPrincipal();
               gm.RespuestaMenuPrincipal();
               break;
           default:
               System.out.println("Opcion no encontrada");
       }
   }while(op!=5);
  }
  
  public void MenuAdminCelulares (){
        MenuAdminCelulares mac = new MenuAdminCelulares();
        int op;
        do{
            op=mac.MenuAdminCelular();
            switch (op) {
                case 1:
                  AgregarCelular ac = new AgregarCelular();
                  ac.agregar();
                  break;
              case 2:
                  EliminarCelular ec = new EliminarCelular();
                  ec.Eliminar();
                  break;
              case 3:
                  ListarCelular lc = new ListarCelular();
                  lc.Listar();
                  break;
              case 4:
                  ActualizarCelular atc = new ActualizarCelular();
                  atc.Actualizar();
                  break;
              case 5:
                  System.out.println("REGRESANDO");
                  MenuAdmin();
                  break;
              default:
                  System.out.println("Opcion no encontrada");
          }
      }while(op!=5);
  }
  
  public void MenuActualizarCelular(Celular celular){
      MenuAdminCelulares mac = new MenuAdminCelulares();
      ActualizarCelularDao acd = new ActualizarCelularDao();
      Validaciones v = new Validaciones();
      int op;
      do{
          op=mac.MenuActualizarCelular();
          switch (op) {
              case 1:
                  String nombreMarca = v.validar_texto("Ingrese la nueva marca del celular:");
                  Marca marca = new Marca(nombreMarca);
                  celular.setMarca(marca);
                  acd.ActualizarCelularDao(celular);
                  break;
              case 2:
                  celular.setModelo(v.validar_texto("Ingrese el nuevo modelo"));
                  acd.ActualizarCelularDao(celular);
                  break;
              case 3:
                  SistemaOperativo so = SistemaOperativo.SeleccionarSistemaOperativo();
                  celular.setSistemaop(so);
                  acd.ActualizarCelularDao(celular);
                  break;
              case 4:
                   CategoriaGama cg = CategoriaGama.SeleccionarGama();
                   celular.setGama(cg);
                   acd.ActualizarCelularDao(celular);
                   break;
              case 5:
                  celular.setPrecio(v.validar_decimal("Ingrese el nuevo precio"));
                  acd.ActualizarCelularDao(celular);
                  break;
              case 6: 
                  celular.setStock(v.validar_entero("Ingrese el nuevo Stock"));
                  acd.ActualizarCelularDao(celular);
                  break;
              case 7:
                  celular.setStockMinimo(v.validar_entero("Ingrese el nuevo stock minimo"));
                  acd.ActualizarCelularDao(celular);
                  break;
              case 8:
                  System.out.println("Gracias por ingresar, Regresando a menu anterior");
                  MenuAdminCelulares();
                  break;
              default:
                  System.out.println("Opcion no encontrada");
          }        
      }while(op!=8);
   }
}
