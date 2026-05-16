import java.util.Hashtable;
import java.util.Collection;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GerenciadorProtocolos{

    public GerenciadorProtocolos(){}

    // armazena novo protocolo e retorna o id
    public int armazenaProtocolo(Assinante assinante, Entrega entrega, Cesta cesta){
        try{
            
            FileWriter protocolos = new FileWriter("Protocolos.txt" , true);
            BufferedWriter escreverProtocolo = new BufferedWriter(protocolos);

            Random geraId = new Random();
            int id = geraId.nextInt(999999);    

            escreverProtocolo.newLine();
            escreverProtocolo.write(id + "_" + assinante.getNumero() + "_");

            Endereco endereco = entrega.getEndereco();
            escreverProtocolo.write(endereco.geraConjuntoProtocolo());

            Hashtable<Integer, ItemProduto> hash = cesta.getItems();
            int idPlano = cesta.getIdPlano();

            Collection<ItemProduto> itens = hash.values();
            for(ItemProduto item : itens){
                escreverProtocolo.write(item.getIdProduto() + "_" + item.getQuantidade() + "_");
            }

            escreverProtocolo.write(Integer.toString(idPlano));

            escreverProtocolo.close();
            protocolos.close();
            return id;
        } catch(IOException e){
            System.err.printf(e.getMessage());
            return 1;
        }
    }
}