import java.io.*;

public class Principal {

    public static void main(String[] args) throws IOException {
        File fichero = null;
        FileReader flujoEntrada = null;
        BufferedReader buffer = null;

        fichero = new File("fichero.txt");
        flujoEntrada = new FileReader(fichero);
        buffer = new BufferedReader(flujoEntrada);

        File copia = new File("copia-2.txt");
        FileWriter flujoSalida = new FileWriter(copia);

        String linea = null;
        int contador = 0;
        while ((linea = buffer.readLine()) != null){
            //Remplazar las "a" por "0"
            linea = linea.replaceAll("a","0");
            //Poner todas mayus
            linea = linea.toUpperCase();
            System.out.println(linea);
            flujoSalida.write(linea+"\n");
            contador++;
        }
        System.out.println(contador);
        flujoSalida.close();

    }

}
