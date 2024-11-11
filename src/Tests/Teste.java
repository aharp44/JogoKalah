package Tests;

import java.util.ArrayList;

import Controller.IInput;
import Controller.Input;
import Model.CasaSimples;
import Model.Fazenda;
import Model.Silo;
import View.View;

public class Teste implements ITestes {
  View visual = new View();
  IInput input = new Input();
  int fazendeiro = 1;

  // Simula a situação de roubo de sementes
  public void rouboDeSementes(ArrayList<CasaSimples> casasSimples, Fazenda fazenda) {
    CasaSimples casa1 = casasSimples.get(2);
    CasaSimples casa2 = casasSimples.get(3);

    casa1.zerarSementes();
    casa2.zerarSementes();

    casa1.addUmaSemente();

    visual.mostrarTabuleiro(casasSimples, fazenda.getSilo1(), fazenda.getSilo2(), 1);
    fazenda.distribuirSementes(2, 1);
  }

  // Simula a situação de se o jogador escolher uma
  public void casaVaziaEscolhida(ArrayList<CasaSimples> casasSimples) {
    int posicao = 5;
    CasaSimples casa = casasSimples.get(posicao);

    casa.zerarSementes();
    boolean vazia = input.checarCasaVazia(casasSimples, posicao);
    if (vazia)
      visual.casaVazia();
  }

  // Simula a vitória de um dos jogadores ou empate
  public void decisaoVencedor(Silo silo1, Silo silo2) {
    silo1.addSementes(20);
    silo2.addSementes(18);

    if (silo1.getQntSementes() > silo2.getQntSementes()) {
      visual.fazendeiroVencedor(1);
    } else if (silo2.getQntSementes() > silo1.getQntSementes()) {
      visual.fazendeiroVencedor(2);
    } else {
      visual.fazendeiroVencedor(0);
    }
  }
}