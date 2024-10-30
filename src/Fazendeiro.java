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
            cavaAtual++;                    // Move posicao da cavaAtual 1 pra frente
            if (cavaAtual > 11){
                cavaAtual = 0;              // Se necessario, Move posicao da cavaAtual de volta pro 0
            }
            cavasSimples.get(cavaAtual).addSementes(1);     // Adiciona 1 semente a cava atual
        }
        inicial.removerTdsSementes();       // Remove tds as sementes da cava escolhida
        return cavasSimples;                // Retorna todo o array de cavas novo
    }


}
