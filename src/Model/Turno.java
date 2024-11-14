package Model;
public enum Turno {
    FAZENDEIRO_A,
    FAZENDEIRO_B;

    // Método para alternar o turno
    public Turno alternarTurno() {
        return this == FAZENDEIRO_A ? FAZENDEIRO_B : FAZENDEIRO_A;
    }
}