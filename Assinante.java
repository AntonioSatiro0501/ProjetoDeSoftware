import java.util.Random;

public class Assinante{

    private String celular;
    private int codigo = -1;

    public Assinante( String celular){
        this.celular = celular;
    }

    // retorna numero
    public String getNumero(){
        return celular;
    }

    // geracodigo SMS
    public void geraCodigo(){
        Random gerador = new Random();
        codigo = gerador.nextInt(999);
        System.out.println("\n\n" + codigo + "\n\n");
    }

    // valida codigo SMS
    public boolean validaCodigo(int codigo){
        if(codigo == this.codigo){
            return true;
        }

        return false;
    }
}