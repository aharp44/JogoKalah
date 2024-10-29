import java.util.ArrayList;

public class Fazendeiro
{
    
    public Fazendeiro()
    {
    
    }
    
    // Distribui as sementes da cava escolhida
    public ArrayList distribuirSementes(int cavaEscolhida, ArrayList<CavaSimples> cavasSimples){
        CavaSimples inicial = cavasSimples.get(cavaEscolhida);
        int cavaAtual = cavaEscolhida;
        // Distribui 1 semente em cada cava seguinte ateh o numero de sementes acabar
        for (int i=0; i < inicial.getQntSementes(); i++){
            cavaAtual++;             // Move posicao 1 pra frente
            if (cavaAtual > 11){
                cavaAtual = 0;       // Move posicao de volta pro 0
            }
            cavasSimples.get(cavaAtual).addSementes(1);
        }
        inicial.removerTdsSementes();   // Remove tds as sementes da cava escolhida
        return cavasSimples;            // Retorna todo o array cavas novo
    }


}
