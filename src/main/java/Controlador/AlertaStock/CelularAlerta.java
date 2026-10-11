package Controlador.AlertaStock;

import Dao.Celular.ListarCelularDao;
import java.util.List;
import modelo.Celular;

public class CelularAlerta {
    ListarCelularDao lcd = new ListarCelularDao();
    EstrategyAlertaStock eas = new AlertaStockMinimo();

    
}
