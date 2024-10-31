import java.util.ArrayList;

public class Fazendeiro {

    private int semsAAdicionarS1;
    private int semsAAdicionarS2;

    public Fazendeiro() {
        
    }

    // Distribui as sementes da cava escolhida
    @SuppressWarnings("rawtypes")
    public ArrayList distribuirSementes(int cavaEscolhida, ArrayList<CavaSimples> cavasSimples) {
        System.out.println("aXXXXXXXX");

        CavaSimples inicial = cavasSimples.get(cavaEscolhida);
        int cavaAtual = cavaEscolhida;
        boolean emSilo = false;
        semsAAdicionarS1 = 0;
        semsAAdicionarS2 = 0;
        // Distribui 1 semente em cada cava seguinte ateh o numero de sementes acabar
        for (int i=0; i < inicial.getQntSementes(); i++){
            cavaAtual++;
            System.out.println("add em silo 1: " + semsAAdicionarS1);
            System.out.println("add em silo 2: " + semsAAdicionarS2);

            // Reseta a posicao qnd chega no fim das cavas
            if(cavaAtual == 12){
                cavaAtual = 0;
            }

            // Verifica se esta ou nao em um silo
            if(cavaAtual == 6 && emSilo == false){
                // Adiciona 1sem pro silo 1
                emSilo = true;
                semsAAdicionarS1++;
                cavaAtual--;
            } else if (cavaAtual == 0 && emSilo == false){
                // Adiciona 1sem pro silo 2
                emSilo = true;
                semsAAdicionarS2++;
                cavaAtual--;
            } else{
                // Adiciona 1sem na cava atual
                emSilo = false;
                cavasSimples.get(cavaAtual).addSementes(1);
            }
        }
        inicial.removerTdsSementes();       // Remove tds as sementes da cava escolhida
        return cavasSimples;                // Retorna todo o array de cavas novo
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
                System.out.println("O adversario precisa ter sementes na casa oposta a sua para executar esta acao de captura");
            }
        } else { // Exibe uma mensagem ao usuário dizendo que a jogada é inválida caso não sacie a condição necessária
            System.out.println("Voce precisa ter apenas uma semente em sua cava para executar esta acao de captura");
        }
    }

    // Retorna TRUE caso o jogo tenha terminado
    public boolean fimDeJogo(ArrayList<CavaSimples> cavasSimples){
        boolean ret = true;
        // roda as 12 cavas verificando se estao tds vazias
        for(int i=0; i<=11; i++){
            if(cavasSimples.get(i).getQntSementes() != 0){
                ret = false;
                break;
            }
        }
        return ret;
    }

    // Retorna qm foi o vencedor
    public int getVencedor(Silo silo1, Silo silo2){
        int ret;
        // Retorna 1 se o silo1 tiver mais sementes
        if(silo1.getQntSementes() > silo2.getQntSementes()){
            ret = 1;
        } 
        // Retorna 2 se o silo2 tiver mais sementes
        else if (silo1.getQntSementes() < silo2.getQntSementes()){
            ret = 2;
        } 
        // Retorna 0 se os 2 silos tiverem a msm qnt
        else{
            ret = 0;
        }
        return ret;
    }

    // Retorna a qnt de sementes a ser adicionado ao silo1
    public int getQntSementesAdicionaisS1(){
        return semsAAdicionarS1;
    }
    // Retorna a qnt de sementes a ser adicionado ao silo2
    public int getQntSementesAdicionaisS2(){
        return semsAAdicionarS2;
    }


}