import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Collection;

public class ColecaoPlanos {

    public Hashtable<Integer, Plano> hash = new Hashtable<>();

    public ColecaoPlanos(){

        // fetche dos planos
        try{
            FileReader planos = new FileReader("Planos.txt");
            BufferedReader lerPlanos = new BufferedReader(planos);
            String linha = lerPlanos.readLine();
            while (linha != null) {
            
                String[] atriPlano = linha.split("_");
                Plano plano = new Plano(Integer.parseInt(atriPlano[0]), atriPlano[1], Double.parseDouble(atriPlano[2]), Integer.parseInt(atriPlano[3]), Integer.parseInt(atriPlano[4]), Integer.parseInt(atriPlano[5]));
                hash.put(Integer.parseInt(atriPlano[0]), plano);
                linha = lerPlanos.readLine();
            }

            planos.close();
        } catch(IOException e){
            System.err.printf(e.getMessage());
        }
    }

    // retorna plano por id
    public Plano getPlano(int id){
        return hash.get(id);
    }

    // print de todos os planos
    public void buscaPlanos(){
        Collection<Plano> planos = hash.values();
        for(Plano plano : planos){
            plano.printPlano();
        }
    }
}