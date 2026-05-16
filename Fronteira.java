import java.util.Scanner;
import java.io.IOException;

public class Fronteira{

    public static void main(String args[]){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu número de celular: ");
        String numero = scanner.nextLine();
        
        Controler controle = new Controler();
        controle.criarAssinante(numero);

        while(true){
            System.out.println("\nDigite o codigo SMS enviado para você: ");
            int codigo = scanner.nextInt();

            if(controle.validaCodigo(codigo)){
                break;
            } else {
                System.out.println("\nCodigo incorreto, tente novamente");
            }
        }

        while(true){
            System.out.println("\nDigite o id de um plano para o selecionar: ");
            int id = scanner.nextInt();

            if(controle.armazenaPlano(id)){
                break;
            } else {
                System.out.println("\nPlano inexistente");
            }
        }

        int[] limites = controle.getLimites();

        for(int i = 0; i < 3; i++){

            switch(i){
                case(0):
                    System.out.println("-------------------");
                    System.out.println("Limite frutas = " + limites[0]);
                    System.out.println("-------------------\n");
                    while(true){
                        controle.printProdutoCategoria("fruta");
                        System.out.println("\nDigite o id do produto: ");
                        int id = scanner.nextInt();

                        System.out.println("\nDigite a quantidade a adicionar ou remover do produto: ");
                        int quantidade = scanner.nextInt();

                        boolean adicionado = controle.adicionarItem(id, quantidade);
                        if(adicionado){
                            System.out.println("\nItem adicionado");
                        }

                        if(controle.checaLimite("fruta")){
                            break;
                        }
                    }
                    break;
                case(1):
                    System.out.println("-------------------");
                    System.out.println("Limite verduras = " + limites[1]);
                    System.out.println("-------------------\n");
                    while(true){
                        controle.printProdutoCategoria("verdura");
                        System.out.println("\nDigite o id do produto: ");
                        int id = scanner.nextInt();

                        System.out.println("\nDigite a quantidade a adicionar ou remover do produto: ");
                        int quantidade = scanner.nextInt();

                        boolean adicionado = controle.adicionarItem(id, quantidade);
                        if(adicionado){
                            System.out.println("\nItem adicionado");
                        }

                        if(controle.checaLimite("verdura")){
                            break;
                        }
                    }
                    break;
                case(2):
                    System.out.println("-------------------");
                    System.out.println("Limite legumes = " + limites[2]);
                    System.out.println("-------------------\n");
                    while(true){
                        controle.printProdutoCategoria("legume");
                        System.out.println("\nDigite o id do produto: ");
                        int id = scanner.nextInt();

                        System.out.println("\nDigite a quantidade a adicionar ou remover do produto: ");
                        int quantidade = scanner.nextInt();

                        boolean adicionado = controle.adicionarItem(id, quantidade);
                        if(adicionado){
                            System.out.println("\nItem adicionado");
                        }

                        if(controle.checaLimite("legume")){
                            break;
                        }
                    }
                    break;
                default:
                    continue;
            }
        }

        System.out.println("----------------------------------");
        System.out.println("  Itens adicionados com sucesso");
        System.out.println("----------------------------------\n");

        controle.printItens();

        System.out.println("\nDigite seu cep: ");
        int cep = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\nDigite sua cidade: ");
        String cidade = scanner.nextLine();
        System.out.println("\nDigite seu bairro: ");
        String bairro = scanner.nextLine();
        System.out.println("\nDigite sua rua: ");
        String rua = scanner.nextLine();
        System.out.println("\nDigite o numero de sua residencia: ");
        int numeroResidencia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\nDigite o complemento: ");
        String complemento = scanner.nextLine();

        controle.defineEntrega(cep, cidade, bairro, rua, numeroResidencia, complemento);

        System.out.println("----------------------------------");
        System.out.println("         Entrega Definida");
        System.out.println("----------------------------------\n");

        System.out.println("\nDigite o metodo de pagamento (Credito/Debito): ");
        String metodo = scanner.nextLine();
        controle.definePagamento(metodo);
        
        while(true){
            System.out.println("\nDigite o numero do cartao: ");
            String nCartao = scanner.nextLine();
            System.out.println("\nDigite o cvv do cartao: ");
            String cvv = scanner.nextLine();
            System.out.println("\nDigite a validade do cartao: ");
            String validade = scanner.nextLine();
            System.out.println("\nDigite o titular do cartao: ");
            String titular = scanner.nextLine();
            System.out.println("\nDigite a agencia do cartao: ");
            String agencia = scanner.nextLine();
            if(controle.registraCartao(validade, cvv, numero, titular, agencia)){
                
                break;
            } else {
                System.out.println("\nCartao invalido");
            }
        }
    }
}