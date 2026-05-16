public class Endereco{

    private int cep;
    private String cidade;
    private String bairro;
    private String rua;
    private int numeroResidencia;
    private String complemento;

    public Endereco(int cep, String cidade, String bairro, String rua, int numeroResidencia, String complemento){
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroResidencia = numeroResidencia;
        this.complemento = complemento;
    }

    // gera string de dados para registro do protocolo
    public String geraConjuntoProtocolo(){
        return (Integer.toString(cep) + "_" + cidade + "_" + bairro + "_" + rua + "_" + Integer.toString(numeroResidencia) + "_" + complemento + "_");
    }

    // print de dados de endereco para report da entrega
    public void printEndereco(){
        System.out.println("CEP: " + cep);
        System.out.println("Numero: " + numeroResidencia);
        System.out.println("Complemento: " + complemento);
    }
}