import java.time.LocalDateTime;

public class Registro {
    private String primerDivisa;
    private String segundaDivisa;
    private double cantidadAconvertir;
    private double conversion;
    private LocalDateTime hora;

    public Registro(String primerDivisa, String segundaDivisa, double cantidadAconvertir, double conversion, LocalDateTime hora) {
        this.primerDivisa = primerDivisa;
        this.segundaDivisa = segundaDivisa;
        this.cantidadAconvertir = cantidadAconvertir;
        this.conversion = conversion;
        this.hora = hora;
    }

    public String getPrimerDivisa() {
        return primerDivisa;
    }

    public String getSegundaDivisa() {
        return segundaDivisa;
    }

    public double getCantidadAconvertir() {
        return cantidadAconvertir;
    }

    public double getConversion() {
        return conversion;
    }

    public LocalDateTime getHora() {
        return hora;
    }
}
