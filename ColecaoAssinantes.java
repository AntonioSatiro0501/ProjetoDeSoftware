import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Hashtable;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ColecaoAssinantes {

    public Hashtable<String, Assinante> hash = new Hashtable<>();

    public ColecaoAssinantes(){

        try{
            FileReader assinantes = new FileReader("Assinantes.txt");
            BufferedReader lerAssinantes = new BufferedReader(assinantes);
            String linha = lerAssinantes.readLine();
            while (linha != null) {
            
                Assinante assinante = new Assinante(linha);
                hash.put(linha, assinante);
                linha = lerAssinantes.readLine();
            }

            assinantes.close();
        } catch(IOException e){
            System.err.printf(e.getMessage());
        }
    }

    public Assinante getAssinante(String numero){
        return hash.get(numero);
    }

    public void adicionarAssinante(Assinante assinante){

        try{

            FileWriter assinantes = new FileWriter("Assinantes.txt" , true);
            BufferedWriter escreverAssinantes = new BufferedWriter(assinantes);
            escreverAssinantes.newLine();
            escreverAssinantes.write(assinante.getNumero());
            escreverAssinantes.close();
            assinantes.close();

        } catch(IOException e){
            System.err.printf(e.getMessage());
        }

    }
}