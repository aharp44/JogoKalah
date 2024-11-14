package Model;
import java.util.ArrayList;

import Controller.Input;

public class Fazenda{
    ArrayList<CasaSimples> ListCasasSimples = new ArrayList<CasaSimples>();
    Silo silo1 = new Silo();
    Silo silo2 = new Silo();
    Fazendeiro fazendeiro = new Fazendeiro();
    Input inp = new Input();
    
    public Fazenda(){}
    
    // Coloca 12 casas com 4 sementes no array ListCasasSimples
    public void iniciarJogo(){
        for (int i = 0; i < 12; i++){
            CasaSimples cs = new CasaSimples();
            ListCasasSimples.add(cs);
        }
    }
    
    // Instancia a func distribuirSementes em Fazendeiro
    @SuppressWarnings("unchecked")
    public void distribuirSementes(int casaEscolhida, Turno turnoAtual){
        // Calcula a nova qnt de sementes em cada casa e cada silo
        ListCasasSimples = fazendeiro.distribuirSementes(casaEscolhida, ListCasasSimples, turnoAtual);
        silo1.addSementes(fazendeiro.getQntSementesAdicionaisS1());
        silo2.addSementes(fazendeiro.getQntSementesAdicionaisS2());
    }

    // Retorna TRUE caso o jogo tenha terminado
    public boolean fimDeJogo(){
        return fazendeiro.fimDeJogo(ListCasasSimples);
    }

    public int getVencedor(){
        return fazendeiro.getVencedor(silo1, silo2);
    }

    // Retorna TRUE caso o jogador ganhe mais uma jogada
    public boolean getMaisUmaJogada(){
        return fazendeiro.getMaisUmaJogada();
    }
    
    // Retorna o array ListCasasSimples
    public ArrayList<CasaSimples> getArrayCasas(){
        return ListCasasSimples;
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