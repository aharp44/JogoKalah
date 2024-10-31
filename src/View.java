import java.util.ArrayList;

public class View {
    public View() {}

    public void mostrarIniciarJogo() {
        System.out.print("Deseja iniciar jogo? (S/N): ");
    }

    public void mostrarIniciarJogoErro() {
        System.out.println("Insira S ou N apenas.");
    }

    public void escolherCava(int faz) {
        if(faz == 1){
            System.out.print("Escolha uma cava entre 0 e 5: ");
        }else{
            System.out.print("Escolha uma cava entre 6 e 11: ");
        }
    }

    public void valorInvalido() {
        System.out.println("Insira um valor numerico. ");
    }

    public void numeroInvalido(int faz) {
        if(faz == 1){
            System.out.println("Insira um numero entre 0 e 5 apenas. ");
        }else{
            System.out.println("Insira um numero entre 6 e 11 apenas. ");
        }
    }

    public void acaoInvalida() {
        System.out.println("Insira um 1 ou 2 apenas.");
    }

    public void proximaAcao() {
        System.out.print("O que deseja fazer agora?\n\n 1 - Proxima Jogada\n 2 - Interromper Jogo\n ->  Acao: ");
    }

    public void capturarSementeCava() {
        System.out.print(
                "De qual cava você deseja capturar as sementes adversarias?\n Requisito: A quantidade de sementes na sua cava deve ser igual a 1!");
    }

    public void interromperJogo(){
        System.out.println("O jogo foi interrompido\n\n");
    }

    public void fimDeJogo(int vencedor){
        System.out.println("Fim de jogo! Vencedor: ");
        // Verifica se houve empate
        if (vencedor == 0){
            System.out.print("nao ha vencedores, houve empate!");
        }else{
            System.out.print(vencedor);
        }
    }

    // Mostra visualmente qual fazendeiro ira jogar agora
    public void vezJogador(int fazendeiro){
        if(fazendeiro == 1){
            System.out.println("\nVez do Fazendeiro 1");
        }else{
            System.out.println("\nVez do Fazendeiro 2");
        }
    }

    // Imprime tds as cavas e silos
    public void mostrarTabuleiro(ArrayList<CavaSimples> cavasSimples, Silo silo1, Silo silo2, int fazendeiro) {
        for (int i = 0; i < 12; i++) {
            int c = cavasSimples.get(i).getQntSementes();
            System.out.println("Cava [" + i + "]: " + c + " sementes");
        }

        int s1 = silo1.getQntSementes();
        int s2 = silo2.getQntSementes();
        System.out.println("Silo 1: " + s1 + " sementes");
        System.out.println("Silo 2: " + s2 + " sementes");
    }
}