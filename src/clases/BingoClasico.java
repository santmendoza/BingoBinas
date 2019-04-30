package clases;

import java.util.LinkedList;

public class BingoClasico extends Bingo {

    private final int limiteCartones;
    private int numCartonesGenerados;

    public BingoClasico(int limiteCartones) {
        super(90, 15);
        this.limiteCartones = limiteCartones;
        this.numCartonesGenerados = 0;
    }

    //METODOS
    @Override
    public boolean esAceptable(Carton carton) {
        LinkedList<Integer> numeros = carton.getNumerosCarton();
        for (int i = 0; i < this.tamañoCarton; i++) {
            if (numeros.get(i) == numeros.get(i + 1) - 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Carton generarCarton() {
        if (this.numCartonesGenerados < this.limiteCartones) {
            this.numCartonesGenerados++;
            return super.generarCarton();
        }
        return null;
    }
}
