package Controlador;

import actividad.DatosVenta;
import dao.Venta.ListarVentas;
import java.util.List;
import modelo.ReporteVenta;

public class ReporteVentasRealizadas {

    private ListarVentas lv = new ListarVentas();
    private DatosVenta dv = new DatosVenta();

    // 1. Trae de la BD, usa Streams y guarda en ventas.dat
    public void sincronizarYGuardarEnDat() {
        List<ReporteVenta> rv = lv.obtenerTodasLasVentasBD();

        if (rv.isEmpty()) {
            System.out.println("No hay ventas registradas");
            return;
        }

        // Aplicamos Stream API para mostrar en consola las ventas cargadas
        System.out.println("VENTAS ENCONTRADAS");
        rv.stream().forEach(System.out::println);

        // Guardar la lista entera en el archivo ventas.dat
        dv.guardarVentas(rv);
        System.out.println("Ventas guardadas exitosamente");
    }

    // 2. Procesa y analiza las ventas almacenadas en el .dat usando la API de Stream
    public void mostrarReportesDesdeDat() {
        List<ReporteVenta> listaDat = dv.getObtenerLista();

        if (listaDat.isEmpty()) {
            System.out.println("Esta vacio o no existe");
            return;
        }

        System.out.println("REPORTE");

        // A. Listar todas las ventas del archivo con referencias a métodos ::
        System.out.println("1.Todas las Ventas");
        listaDat.stream().forEach(System.out::println);

        // B. Filtrar ventas mayores a $1,000,000
        System.out.println("2.Ventas Mayores a $1,000,000 ");
        listaDat.stream()
                .filter(v -> v.getTotal() > 1000000)
                .forEach(System.out::println);

        // C. Obtener solo los nombres de los clientes que compraron (Map & Distinct)
        System.out.println("3.Clientes que han comprado (Sin repetir)");
        listaDat.stream()
                .map(ReporteVenta::getNombreCliente)
                .distinct()
                .forEach(nombre -> System.out.println("Cliente: " + nombre));

        // D. Calcular la suma Total de todas las ventas con Stream
        double totalGlobal = listaDat.stream()
                .mapToDouble(ReporteVenta::getTotal)
                .sum();
        System.out.println("4.Recaudo Total de Ventas: " + totalGlobal);
    }
}
