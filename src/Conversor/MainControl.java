package Conversor;

import Models.SupportedCodes;
import Models.Conversion;
import Models.Registro;
import apiController.Conexion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainControl {
    public List<Registro> registros = new ArrayList<Registro>();
    private String[] arrayDiv = new String[2];

    public String conectar(double monto) {
        Double cambio = 0.0;
        double resultado = 0.0;

        Conexion con = new Conexion();
        BuscarCambio busca = new BuscarCambio();

        Conversion conversion = con.consultarConversion(arrayDiv[0]);

        cambio = busca.busqueda(arrayDiv[1], conversion);
        resultado = calcularCambio(monto, cambio);

        Registro registro = new Registro(arrayDiv[0], arrayDiv[1], monto, resultado, LocalDateTime.now());
        registros.add(registro);

        return "Conversion: " + monto + " " + arrayDiv[0] + " = " + resultado + " " + arrayDiv[1];
    }

    public String convertirOpcion(int option, double monto) {
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
        return conectar(monto);
    }

    public String agregarDivisa(String divisa, String divisa2, double monto) {
        arrayDiv[0] = divisa;
        arrayDiv[1] = divisa2;
        return conectar(monto);
    }

    private Double calcularCambio(double monto, Double cambio) {
        return monto * cambio;
    }

    public String verDivisas(){
        Conexion con = new Conexion();
        BuscarCambio busca = new BuscarCambio();

        SupportedCodes codes = con.consultarDivisas();
        return busca.verDivisas(codes);
    }
}
