package P47;

import P47.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) {
        ArrayList<Empresas> listaEmpresas = new ArrayList<Empresas>();
        
        listaEmpresas.add(new Empresas("Id1", "Nom1", "Pepe Pérez","Empresario", "ModeloCarta1", "n1@example.com"));
        listaEmpresas.add(new Empresas("Id2", "Nom2", "Lolo López","Mensajero", "ModeloCarta2", "n2@sample.com"));
        listaEmpresas.add(new Empresas("Id3", "Nom3", "Pedro ","Motorista Fantasma", "ModeloCarta2", "n3@ejemplo.com"));
        Boolean Console = true;
        Cartas carta = new Cartas();
        while (Console) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Elige un número de entre las opciones disponibles");
            System.out.println("1. Crear y enviar cartas");
            System.out.println("2. Eliminar archivos");
            System.out.println("3. Cerrar el programa");
            int opcion = sc.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        try {
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("Ingrese el número de la empresa: ");
                            for (int i = 0; i < listaEmpresas.size(); i++) {
                                System.out.println((i + 1) + listaEmpresas.get(i).getNomEmpresa());
                            }
                            int n = scanner.nextInt() - 1;
                            String modelo = carta.CartaS(listaEmpresas.get(n));
                            ArrayList<String> listanulidades = carta.Carpeta(listaEmpresas.get(n));
                            for (String nulidad : listanulidades) {
                                ArrayList<Proveedores> listaproveedores = carta.crear_proveedores(nulidad);
                                carta.crear_cartas(listaproveedores, listaEmpresas.get(n), modelo);
                            }
                        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Ingrese un número entero que esté en la lista:");
                        }
                        break;
                        
                    case 2:
                    	carta.Borrar();break;
                    case 3:
                        Console = false;   
                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Ingrese un número disponible:");
            }
        }
    }
}
