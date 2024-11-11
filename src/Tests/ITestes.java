package Tests;

import java.util.ArrayList;

import Model.CasaSimples;
import Model.Fazenda;
import Model.Silo;

public interface ITestes {
  public void rouboDeSementes(ArrayList<CasaSimples> casasSimples, Fazenda fazenda);
  public void casaVaziaEscolhida(ArrayList<CasaSimples> casasSimples);
  public void decisaoVencedor(Silo silo1, Silo silo2);
}