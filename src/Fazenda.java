import java.util.ArrayList;


public class Fazenda
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    
    ArrayList<CavaSimples> cavasSimples = new ArrayList<CavaSimples>();
    Silo silo1 = new Silo();
    Silo silo2 = new Silo();
    Fazendeiro player1 = new Fazendeiro();
    Fazendeiro player2 = new Fazendeiro();
    
    public Fazenda()
    {
        
    }
    
    // Coloca 12 cavas com 4 sementes no array cavasSimples
    public void iniciarJogo(){
        
        for (int i=0; i<12; i++){
            CavaSimples s = new CavaSimples();
            //System.out.println(s.getQntSementes);
            s.addSementes(4);
            cavasSimples.add(s);
        }
        
    }
    
    // Instancia a func distribuirSementes em Fazendeiro
    public void distribuirSementes(int cavaEscolhida){
        cavasSimples = player1.distribuirSementes(cavaEscolhida, cavasSimples);
    }
    
    // Retorna o array cavasSimples
    public ArrayList<CavaSimples> getArrayCavas(){
        return cavasSimples;
    }
    
    // Retorna o silo 1
    public Silo getSilo1(){
        return silo1;
    }
    
    // Retorna o silo 2
    public Silo getSilo2(){
        return silo2;
    }

    
    
}
