package Vista.RealizarCompra;

import Controlador.Celular.ListarCelular;
import Controlador.ReporteVentasRealizadas;
import Dao.Celular.BuscarCelularDao;
import Dao.RegistrarCliente.RegistrarClienteDao;
import Vista.Validaciones.Validaciones;
import dao.Empleado.BuscarEmpleadoDao;
import dao.Empleado.ListarEmpleadoDao;
import Dao.RegistrarVenta.RegistrarVentaDao;
import modelo.Celular;
import modelo.Cliente;
import modelo.Empleado;

public class RealizarCompra {

    Validaciones v = new Validaciones();
    ListarCelular lc = new ListarCelular();
    BuscarCelularDao bcd = new BuscarCelularDao();
    ListarEmpleadoDao led = new ListarEmpleadoDao();
    BuscarEmpleadoDao bed = new BuscarEmpleadoDao();
    RegistrarClienteDao rcd = new RegistrarClienteDao();
    RegistrarVentaDao rvd = new RegistrarVentaDao();
    ReporteVentasRealizadas rvr = new ReporteVentasRealizadas();

    public void RealizarCompras() {
        System.out.println("Registro de datos Cliente");
        String nombre = v.validar_solo_letras("Ingrese su nombre");
        String cedula = v.validar_texto("Ingrese su cedula").trim();
        String correo = v.validar_texto("Ingrese correo").trim();
        String tele = v.validar_texto("Ingrese su numero de telefono").trim();

        Cliente cliente = new Cliente(nombre, cedula, correo, tele);
        String idCliente = rcd.registrarCliente(cliente);

        if (idCliente == null) {
            System.out.println("No se proceso la informacion del cliente");
            return;
        }

        System.out.println("Celulares Disponibles");
        lc.Listar();
        Celular celularSeleccionado = null;
        String idCelular;

        do {
            idCelular = v.validar_texto("Ingrese el id del celular que deseas comprar").trim();
            celularSeleccionado = bcd.buscar(idCelular);
            if (celularSeleccionado == null) {
                System.out.println("ID no encontrado, intenta de nuevo");
            }
        } while (celularSeleccionado == null);

        int cantidad;
        do {
            cantidad = v.validar_entero("Ingrese la cantidad a llevar");
            if (cantidad <= 0) {
                System.out.println("Ingrese una cantidad mayor a cero");
            } else if (cantidad > celularSeleccionado.getStock()) {
                System.out.println("Stock no disponible el disponible es: " + celularSeleccionado.getStock());
            }
        } while (cantidad <= 0 || cantidad > celularSeleccionado.getStock());

        double total = celularSeleccionado.getPrecio() * cantidad;
        System.out.println("El total de su compra fue " + total);

        System.out.println("Empleados: ");
        led.ListarEmpleados().forEach(e
                -> System.out.println("ID " + e.getId() + " NOMBRE: " + e.getNombre()));

        Empleado empleadoSeleccionado = null;
        String idEmpleado;
        do {
            idEmpleado = v.validar_texto("Ingrese el id del empleado que la atendio").trim();
            empleadoSeleccionado = bed.buscar(idEmpleado);
            if (empleadoSeleccionado == null) {
                System.out.println("empleado no encontrado intenta de nuevo");
            }
        } while (empleadoSeleccionado == null);

        boolean exitoVenta = rvd.procesarVenta(idCliente,
                empleadoSeleccionado.getId(),
                celularSeleccionado.getId(),
                cantidad,
                celularSeleccionado.getPrecio(),
                total);

        if (exitoVenta == true) {
            rvr.sincronizarGuardarEnDat();
        }
    }
}
