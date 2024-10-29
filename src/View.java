import java.util.ArrayList;

public class View
{

    
    public View()
    {
        
    }

    public void mostrarIniciarJogo(){
        System.out.println("Deseja iniciar jogo? (S/N): ");
    }
    
    public void mostrarIniciarJogoErro(){
        System.out.println("Insira S ou N apenas.");
    }
    
    public void escolherCava(){
        System.out.println("Escolha uma cava: ");
    }
    
    public void numeroInvalido(){
        System.out.println("Insira um numero entre 1 e 12 apenas: ");
    }
    
    // Imprime tds as cavas e silos
    public void mostrarTabuleiro(ArrayList<CavaSimples> cavasSimples, Silo silo1, Silo silo2){
        for(int i=0; i<12; i++){
            int c = cavasSimples.get(i).getQntSementes();
            System.out.println("Cava [" + i + "]: " + c + " sem");
        }
        int s1 = silo1.getQntSementes();
        System.out.println("Silo 1: " + s1 + " sem");
        int s2 = silo2.getQntSementes();
        System.out.println("Silo 2: " + s2 + " sem");
    }
}
