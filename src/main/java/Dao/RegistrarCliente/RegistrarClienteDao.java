package Dao.RegistrarCliente;

import dao.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import modelo.Cliente;

public class RegistrarClienteDao {

    Conexion c = new Conexion();

    public String registrarCliente(Cliente cliente) {
        String sql = "{call RegistrarCliente(?, ?, ?, ?, ?, ?)}";
        String idCliente = null;

        try (Connection con = c.conexion(); CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, cliente.getId());
            cs.setString(2, cliente.getNombre());
            cs.setString(3, cliente.getCedula());
            cs.setString(4, cliente.getCorreo());
            cs.setString(5, cliente.getTelefono());
            cs.registerOutParameter(6, Types.VARCHAR);

            cs.execute();
            idCliente = cs.getString(6);

        } catch (SQLException e) {
            System.out.println("Error al registrar cliente: " + e.getMessage());
        }
        return idCliente;
    }
}
