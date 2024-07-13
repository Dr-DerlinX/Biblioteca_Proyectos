package org.example;

import clases.FileManage;
import clases.PasswordGenerator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Nota...
            *Opciones a agregar en un futuro.

             1- Eliminar contraseña.
             2- Generar nueva lista de contraseña.
             3- Modificar contraseña.
             *
              - Verificar la entrada de usuarios.
        */

        //Password manager
        /*Aplicación para general y guardas contraseñas...*/

        int length = 25;
        boolean useUppercase = true;
        boolean useLowercase = true;
        boolean useDigits = true;
        boolean useSymbols = true;

        String opcion = "";
        try(Scanner scanner = new Scanner(System.in)){
            FileManage file = new FileManage(scanner);

            while (!opcion.equals("3")){
                menu();
                opcion = scanner.nextLine();

                switch (opcion){
                    case "1" :
                        String password = PasswordGenerator.generatePassword(length, useUppercase, useLowercase, useDigits, useSymbols);
                        System.out.println("La contraseña es : " + password);
                        System.out.println("Guardar contraseña : s/n");
                        opcion = scanner.nextLine();
                        if (opcion.equals("s")){
                            file.writeFile("ListPassword", password);
                            System.out.println("Contraseña guardada correctamente...");
                        }else {
                            System.out.println("Contraseña no guardada");
                        }
                        break;

                    case "2" :
                        System.out.println("/////Lista de contraseñas//////");
                        file.readerFile("ListPassword");
                        break;

                    case "3" :
                        System.out.println("Cerrando aplicación....");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                        break;
                }

            }
        }



    }

    public static void menu(){
        System.out.println("//PASSWORD MANAGER////");
        System.out.println();
        System.out.println("Generar nueva contraseña / 1");
        System.out.println("Ver lista de Contraseña / 2");
        System.out.println("Salir de la aplicación / 3");
    }
}