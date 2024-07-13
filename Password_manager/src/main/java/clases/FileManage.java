package clases;

import java.io.*;
import java.util.Scanner;

public class FileManage {

    private final Scanner scanner;

    public FileManage(Scanner scanner) {
        this.scanner = scanner;
    }

    public void writeFile(String nameFile, String password){

       File file = new File(nameFile+".txt");

       if (file.exists()){
           try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
               System.out.println("Nombre de Usuario o Correo : ");
               String text = scanner.nextLine();
               bw.write(text + " : " +  password);
               bw.newLine();
           } catch (IOException e) {
               System.out.println("Error al escribir en el archivo");
               throw new RuntimeException(e.getMessage());
           }
       }else {
           try {
               file.createNewFile();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }

    }

    public  void readerFile(String nameFile){

        File file = new File(nameFile+".txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))){

            String line;

            while ((line = br.readLine()) != null) System.out.println(line);

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }


    }

}
