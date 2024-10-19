import java.io.*;

public class Acceso {

    public static void main(String[] args){

        String rutaArchivo = "archivo.txt";

        escribirEnArchivo(rutaArchivo,"Hola, este es un ejemplo de escritura en un archivo de texto.");

        String contenidoLeido = leerArchivo(rutaArchivo);
        System.out.println("Contenido del archivo:");
        System.out.println(contenidoLeido);


    }

    public static void  escribirEnArchivo(String rutaArchivo, String contenido){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))){
            writer.write(contenido);
        }catch (IOException e){
            System.err.println("Error al escribir en el archivo: "+ e.getMessage());
        }
    }

    public static String leerArchivo(String rutaArchivo){
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            while ((linea = reader.readLine()) != null){
                contenido.append(linea).append("\n");
            }
        }catch (IOException e){
            System.err.println("Error al leer el archivo: "+e.getMessage());
        }
        return contenido.toString();
    }

}
