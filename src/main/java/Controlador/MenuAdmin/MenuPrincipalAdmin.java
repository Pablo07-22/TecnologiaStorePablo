package Controlador.MenuAdmin;

import Controlador.GestionMenuPrincipal;
import Controlador.ReporteVentasRealizadas;
import Vista.MenuPrincipalAdmin.MenuPrincipalAdministrador;
import Vista.MenuPrincipalCelulares.MenuAdminCelulares;

public class MenuPrincipalAdmin {

    public void MenuPrincipalAdmin() {
        MenuPrincipalAdministrador mpa = new MenuPrincipalAdministrador();
        int op;
        do {
            op = mpa.MenuPrincipalAdmins();
            switch (op) {
                case 1:
                    MenusAdminCelulares mac = new MenusAdminCelulares();
                    mac.MenusAdminCelulares();
                    break;
                case 2:
                    MenuAdminEmpleados mae = new MenuAdminEmpleados();
                    mae.MenuAdminEmpleados();
                    break;
                case 3:
                    ReporteVentasRealizadas rvr = new ReporteVentasRealizadas();
                    rvr.mostrarReportesDesdeDat();
                    break;
                case 4:
                    System.out.println("Informacion Celulares");
                    break;
                case 5:
                    System.out.println("============Regresando===========");
                    GestionMenuPrincipal gmp = new GestionMenuPrincipal();
                    gmp.RespuestaMenuPrincipal();
                    break;
                default:
                    System.out.println("Opcion no encontrada");
            }
        } while (op != 5);
    }
}
