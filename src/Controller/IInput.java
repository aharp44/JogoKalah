package Controller;

import java.util.ArrayList;

import Model.CasaSimples;
import Model.Silo;
import Model.Turno;

public interface IInput {
  public boolean checarCasaVazia(ArrayList<CasaSimples> casasSimples, int posicao);
  public int escolherCasa(Turno turnoAtual, ArrayList<CasaSimples> casasSimples);
  public void mostrarTabuleiro(ArrayList<CasaSimples> casasSimples, Silo silo1, Silo silo2, Turno turnoAtual);
  public int sistemaDecisao();
}