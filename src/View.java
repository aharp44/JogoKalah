import java.util.ArrayList;

public class View {
    public View() {}

    public void mostrarIniciarJogo() {
        System.out.print("Deseja iniciar jogo? (S/N): ");
    }

    public void mostrarIniciarJogoErro() {
        System.out.println("Insira S ou N apenas.");
    }

    public void escolherCava() {
        System.out.print("Escolha uma cava: ");
    }

    public void numeroInvalido() {
        System.out.println("Insira um numero entre 1 e 12 apenas: ");
    }

    public void acaoInvalida() {
        System.out.println("Insira um numero entre 1 e 3 apenas: ");
    }

    public void proximaAcao() {
        System.out.print("O que deseja fazer agora?\n\n 1 - Próxima Jogada\n 2 - Interromper Jogo\n ->  Ação: ");
    }

    public void capturarSementeCava() {
        System.out.print(
                "De qual cava você deseja capturar as sementes adversárias?\n Requisito: A quantidade de sementes na sua cava deve ser igual a 1!");
    }

    public void interromperJogo(){
        System.out.println("O jogo foi interrompido\n\n\n");
    }

    // Imprime tds as cavas e silos
    public void mostrarTabuleiro(ArrayList<CavaSimples> cavasSimples, Silo silo1, Silo silo2) {
        for (int i = 0; i < 12; i++) {
            int c = cavasSimples.get(i).getQntSementes();
            System.out.println("Cava [" + i + "]: " + c + " sementes");
        }

        int s1 = silo1.getQntSementes();
        int s2 = silo2.getQntSementes();
        System.out.println();
        System.out.println("Silo 1: " + s1 + " sementes");
        System.out.println("Silo 2: " + s2 + " sementes");
    }
}