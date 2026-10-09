package Controlador;

import Controlador.Celular.ListarCelular;
import Controlador.MenuAdmin.MenusAdminCelulares;
import Vista.MenuPrincipal.MenuPrincipal;
import Vista.MenuCliente.MenuCliente;
import Vista.RealizarCompra.RealizarCompra;
import java.util.Scanner;

public class GestionMenuPrincipal {
    
  public void RespuestaMenuPrincipal (){
      MenuPrincipal  mp = new MenuPrincipal();
      int op;
      do{
          op=mp.MenuPrincipal();
          switch (op) {
              case 1:
                  Scanner leer = new Scanner(System.in);
                  System.out.println("Ingrese la contraseña");
                  double contra= leer.nextDouble();
                  if (contra!=1234){
                      System.out.println("Contraseñaincorrecta");
                  }else{
                      MenusAdminCelulares ma = new MenusAdminCelulares();
                      ma.MenuAdmin();
                  }
                  break;
              case 2:
                  MenuCliente();
                  break;
              case 3:
                  System.out.println("Gracias por ingresar");
              default:
                  System.out.println("Opcion no encontrada");
          }
          
      }while(op!=3);
  }
  
  
  
  
  public void MenuCliente(){
    MenuCliente mc = new MenuCliente();
    
    int op;
    do {
       op = mc.MenuCliente();
        switch (op) {
           case 1:
                System.out.println("Modulo Celulares");
                ListarCelular lc = new ListarCelular();
                lc.Listar();
                break;
           case 2:
               RealizarCompra rc = new RealizarCompra();
               rc.RealizarCompras();
               break;
           case 3:
               System.out.println("Gracias por ingresar chao");
               break;
           default:
               System.out.println("Opcion no encontrada");
        }
    }while(op!=3);
  }
}
