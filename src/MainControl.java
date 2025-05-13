import javax.print.attribute.standard.DateTimeAtProcessing;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainControl {
    public List<Registro> registros = new ArrayList<Registro>();

    public String conectar(int opcion, double monto) {
        String[] divisa = convertirOpcion(opcion);
        Double cambio = 0.0;
        double resultado = 0.0;

        Conexion con = new Conexion();
        BuscarCambio busca = new BuscarCambio();

        Conversion conversion = con.consultarConversion(divisa[0]);

        cambio = busca.busqueda(divisa[1], conversion);
        resultado = calcularCambio(monto, cambio);

        Registro registro = new Registro(divisa[0], divisa[1], monto, resultado, LocalDateTime.now());
        registros.add(registro);

        return "Conversion: " + monto + " " + divisa[0] + " = " + resultado + " " + divisa[1];
    }

    private String[] convertirOpcion(int option) {
        String[] arrayDiv = new String[2];

        switch (option) {
            case 1:
                arrayDiv[0] = "USD";
                arrayDiv[1] = "MXN";
                break;
            case 2:
                arrayDiv[0] = "MXN";
                arrayDiv[1] = "USD";
                break;
            case 3:
                arrayDiv[0] = "USD";
                arrayDiv[1] = "ARS";
                break;
            case 4:
                arrayDiv[0] = "ARS";
                arrayDiv[1] = "USD";
                break;
            case 5:
                arrayDiv[0] = "USD";
                arrayDiv[1] = "BRL";
                break;
            case 6:
                arrayDiv[0] = "BRL";
                arrayDiv[1] = "USD";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
        return arrayDiv;
    }

    private Double calcularCambio(double monto, Double cambio) {
        return monto * cambio;
    }
}
