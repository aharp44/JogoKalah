import java.util.ArrayList;

public class Fazenda
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    ArrayList<CavaSimples> cavasSimples = new ArrayList<CavaSimples>();
    Silo silo1 = new Silo();
    Silo silo2 = new Silo();
    Fazendeiro fazendeiro1 = new Fazendeiro();
    Fazendeiro fazendeiro2 = new Fazendeiro();
    Input inp = new Input();
    
    public Fazenda(){}
    
    // Coloca 12 cavas com 4 sementes no array cavasSimples
    public void iniciarJogo(){
        for (int i = 0; i < 12; i++){
            CavaSimples cs = new CavaSimples();
            cs.addSementes(4);
            cavasSimples.add(cs);
        }
    }
    
    // Instancia a func distribuirSementes em Fazendeiro
    @SuppressWarnings("unchecked")
    public void distribuirSementes(int cavaEscolhida, int fazendeiro){
        if(fazendeiro == 1 && cavaEscolhida >= 0 && cavaEscolhida < 6){
            cavasSimples = fazendeiro1.distribuirSementes(cavaEscolhida, cavasSimples);
        }else{
            if(fazendeiro == 2 && cavaEscolhida >= 6 && cavaEscolhida < 12){
                cavasSimples = fazendeiro2.distribuirSementes(cavaEscolhida, cavasSimples);
            }else{
                if(fazendeiro == 1){
                    System.out.println("Fazendeiro 1, escolha uma cava entre 0 e 5");
                }else{
                    System.out.println("Fazendeiro 2, escolha uma cava entre 6 e 11");
                }
            }
        }
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