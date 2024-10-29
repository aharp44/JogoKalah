public class Kalah
{
    
    Fazenda fazenda = new Fazenda();
    Input input = new Input();
    
    public static void main(String[] args){
        Kalah temp = new Kalah();
        temp.Jogo();
    }
    
    void Jogo()
    {
       if (input.iniciarJogo()){
           fazenda.iniciarJogo();
           fazenda.distribuirSementes(input.escolherCava());
           
       }
       
       input.mostrarTabuleiro(fazenda.getArrayCavas(), fazenda.getSilo1(), fazenda.getSilo2());

    }

    
}
