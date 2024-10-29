import java.util.ArrayList;

public class Fazendeiro {
    public Fazendeiro() {
    }

    // Distribui as sementes da cava escolhida
    public ArrayList distribuirSementes(int cavaEscolhida, ArrayList<CavaSimples> cavasSimples) {
        CavaSimples inicial = cavasSimples.get(cavaEscolhida);
        int cavaAtual = cavaEscolhida;
        // Distribui 1 semente em cada cava seguinte ateh o numero de sementes acabar
        for (int i = 0; i < inicial.getQntSementes(); i++) {
            cavaAtual++; // Move posicao 1 pra frente
            if (cavaAtual > 11) {
                cavaAtual = 0; // Move posicao de volta pro 0
            }
            cavasSimples.get(cavaAtual).addSementes(1);
        }
        inicial.removerTdsSementes(); // Remove tds as sementes da cava escolhida
        return cavasSimples; // Retorna todo o array cavas novo
    }

    // Pega as sementes da casa oposta
    public void capturarSementes(int cavaEscolhida, ArrayList<CavaSimples> cavaSimples, Silo siloJogador) {
        // Informações necessárias para aquela cava
        CavaSimples cava = cavaSimples.get(cavaEscolhida);

        // Verifica se a cava selecionada permite capturar a sementes do adversário
        if (cava.getQntSementes() == 1) { // Se positivo, pega todas as sementes da casa oposta, incluindo a da própira semeadura e joga para o silo daquele jogador que executou a jogada
            CavaSimples cavaAdversaria = cavaSimples.get(cava.cavaOposta(cavaEscolhida));
            int qtdSementesAdversaria = cavaAdversaria.getQntSementes();

            if (qtdSementesAdversaria > 0) { // Verifica se o adversário tem alguma semente a ser capturada
                siloJogador.addSementes(qtdSementesAdversaria + 1);
                cava.removerTdsSementes();
                cavaAdversaria.removerTdsSementes();
            }else{
                System.out.println("O adversário precisa ter sementes na casa oposta a sua para executar esta ação de captura");
            }
        } else { // Exibe uma mensagem ao usuário dizendo que a jogada é inválida caso não sacie a condição necessária
            System.out.println("Você precisa ter apenas uma semente em sua cava para executar esta ação de captura");
        }
    }
}