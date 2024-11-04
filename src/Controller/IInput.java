package Controller;

import java.util.ArrayList;

import Model.CasaSimples;
import Model.Silo;

public interface IInput {
  public boolean iniciarJogo();
  public boolean checarCasaVazia(ArrayList<CasaSimples> casasSimples, int posicao);
  public int escolherCasa(int fazendeiro, ArrayList<CasaSimples> casasSimples);
  public void mostrarTabuleiro(ArrayList<CasaSimples> casasSimples, Silo silo1, Silo silo2, int fazendeiro);
  public int sistemaDecisao();
}