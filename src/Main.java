import Conversor.MainControl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainControl control = new MainControl();
        double cantidad = 0;
        String moneda = "";
        String moneda2 = "";
        String marc = "*****";
        System.out.println("Bienvenida/o a nuestro conversor de divisas!");

        while (true){
            System.out.println(marc.repeat(6));
            System.out.println("""
                Elija una opcion:
                
                1) Dolar -> Peso mexicano
                2) Peso mexicano -> Dolar
                3) Dolar -> Peso argentino
                4) Peso argentino -> Dolar
                5) Dolar -> Real brasileño
                6) Real brasileño -> Dolar
                7) Otras
                8) Ver divisas
                9) Ver historial
                0) Salir
                """);
            System.out.print("Opcion: ");
            var opcion = sc.nextInt();

            if(opcion < 8 && opcion > 0) {
                if(opcion == 7){
                    System.out.print("Moneda: ");
                    moneda = sc.next();
                    System.out.print("Moneda a convertir: ");
                    moneda2 = sc.next();
                }
                System.out.print("Ingrese la cantidad: ");
                cantidad = sc.nextDouble();
                if (opcion < 7){
                    System.out.println("\n"+control.convertirOpcion(opcion,cantidad)+"\n");
                }else{
                    System.out.println("\n"+control.agregarDivisa(moneda,moneda2,cantidad)+"\n");
                }
            }else if (opcion == 8){
                System.out.println(control.verDivisas());
            }else if (opcion == 9){
                System.out.println(control.registros.toString());
            }else if (opcion == 0){
                break;
            }else{
                System.out.println("Inrgese una opcion valida!");
            }
            System.out.println(marc.repeat(6));
        }

    }

}
