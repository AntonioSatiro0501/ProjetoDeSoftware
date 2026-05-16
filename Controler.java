import java.io.IOException;

public class Controler {

    private Assinante assinante = null;
    private Assinatura assinatura = null;

    public Controler(){}

    // cria assinante
    public void criarAssinante(String celular){

        try{
            ColecaoAssinantes colecaoAssinantes = new ColecaoAssinantes();
            assinante = colecaoAssinantes.getAssinante(celular);
    
            if(assinante == null){
                assinante = new Assinante(celular);
                colecaoAssinantes.adicionarAssinante(assinante);
            }

            assinante.geraCodigo();
        } catch(Exception e){
            System.err.printf(e.getMessage());
        }
    }

    // valida codigo SMS
    public boolean validaCodigo(int codigo){
        if(assinante.validaCodigo(codigo)){
            System.out.println("\nConta validada!!!\n");
            ColecaoPlanos planos = new ColecaoPlanos();
            planos.buscaPlanos();
            return true;
        }
        return false;
    }

    // armazena o plano selecionado
    public boolean armazenaPlano(int id){
        ColecaoPlanos planos = new ColecaoPlanos();
        Plano plano = planos.getPlano(id);

        if(plano == null){
            return false;
        }
        
        assinatura = new Assinatura(plano);
        return true;
    }

    // adiciona item a cesta
    public boolean adicionarItem(int id, int quantidade){
        return assinatura.adicionarItem(id, quantidade);
    }

    // print de todos os produtos de certa categoria
    public void printProdutoCategoria(String categoria){
        ColecaoProdutos produtos = new ColecaoProdutos();
        produtos.printPorCategoria(categoria);
    }

    // checa limite de itens cesta
    public boolean checaLimite(String categoria){
        return assinatura.checaLimite(categoria);
    }

    // cria entrega
    public void defineEntrega(int cep, String cidade, String bairro, String rua, int numeroResidencia, String complemento){
        assinatura.defineEntrega(cep, cidade, bairro, rua, numeroResidencia, complemento, assinante);
    }

    // cria pagamento
    public void definePagamento(String metodo){
        assinatura.definePagamento(metodo);
    }

    public boolean registraCartao(String validade, String cvv, String numero, String titular, String agencia){
        return assinatura.registraCartao(validade, cvv, numero, titular, agencia);
    }

    public void printItens(){
        assinatura.printItens();
    }
}