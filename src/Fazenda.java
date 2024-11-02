import java.util.ArrayList;

public class Fazenda
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    ArrayList<CasaSimples> cavasSimples = new ArrayList<CasaSimples>();
    Silo silo1 = new Silo();
    Silo silo2 = new Silo();
    Fazendeiro fazend = new Fazendeiro();
    Input inp = new Input();
    
    public Fazenda(){}
    
    // Coloca 12 casas com 4 sementes no array cavasSimples
    public void iniciarJogo(){
        for (int i = 0; i < 12; i++){
            CasaSimples cs = new CasaSimples();
            cs.addSementes(4);
            cavasSimples.add(cs);
        }
    }
    
    // Instancia a func distribuirSementes em Fazendeiro
    @SuppressWarnings("unchecked")
    public void distribuirSementes(int cavaEscolhida, int fazendeiro){
        // Calcula a nova qnt de sementes em cada casa e cada silo
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
    public ArrayList<CasaSimples> getArrayCasas(){
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