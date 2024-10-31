import java.util.ArrayList;

public class Fazenda
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    ArrayList<CavaSimples> cavasSimples = new ArrayList<CavaSimples>();
    Silo silo1 = new Silo();
    Silo silo2 = new Silo();
    Fazendeiro fazend = new Fazendeiro();
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
        // Calcula a nova qnt de sementes em cada cava e cada silo
        cavasSimples = fazend.distribuirSementes(cavaEscolhida, cavasSimples, fazendeiro);
        silo1.addSementes(fazend.getQntSementesAdicionaisS1());
        silo2.addSementes(fazend.getQntSementesAdicionaisS2());
    }

    // Retorna TRUE caso o jogo tenha terminado
    public boolean fimDeJogo(){
        return fazend.fimDeJogo(cavasSimples);
    }

    public int getVencedor(){
        return fazend.getVencedor(silo1, silo2);
    }

    // Retorna TRUE caso o jogador ganhe mais uma jogada
    public boolean getMaisUmaJogada(){
        return fazend.getMaisUmaJogada();
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