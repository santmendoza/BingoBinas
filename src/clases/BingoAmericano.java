package clases;

import java.util.LinkedList;

public class BingoAmericano extends Bingo {
    
    public BingoAmericano() {
        super(75, 25);
    }

    //METODOS
    
    @Override
    protected boolean esAceptable(Carton carton) {
        LinkedList <Integer> numeros = carton.getNumerosCarton();
        int suma = 0; double promedio;
        for(int i = 0; i < this.tamañoCarton; i++) {
            suma += numeros.get(i);
        }
        promedio = (double) (suma / this.tamañoCarton);
        return (promedio > 50);
    }

    @Override
    public int girar() {
        int extraer;
        do {
            extraer = super.girar();
        } while(extraer == this.ultimaBola + 1);
        return extraer;
    }
}