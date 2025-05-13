import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainControl control = new MainControl();
        double cantidad = 0;
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
                7) Salir
                """);
            System.out.print("Opcion: ");
            var opcion = sc.nextInt();

            if(opcion < 7 && opcion > 0) {
                System.out.print("Ingrese la cantidad: ");
                cantidad = sc.nextDouble();
                System.out.println("\n" + control.conectar(opcion, cantidad));
            }else if (opcion == 7){
                break;
            }else{
                System.out.println("Inrgese una opcion valida!");
            }
            System.out.println(marc.repeat(6));
        }

        System.out.println(control.registros);
    }

}
