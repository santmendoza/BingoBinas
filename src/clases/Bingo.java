package clases;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class Bingo {
    private final int bolaMayor;
    private LinkedList <Integer> bombo;
    private LinkedList <Integer> bolasExtraidas;
    protected int ultimaBola;
    protected final int tamañoCarton;
    private HashSet <Carton> cartonesGenerados;
    private HashSet <Carton> cartonesBingo;
    public boolean finalizado;

    //constructor
    protected Bingo(int bolaMayor, int tamañoCarton) {
        this.bolaMayor = bolaMayor;
        this.bombo = new LinkedList<>();
        this.bolasExtraidas = new LinkedList<>();
        this.tamañoCarton = tamañoCarton;
        this.ultimaBola = 0;
        this.cartonesGenerados = new HashSet<>();
        this.cartonesBingo = new HashSet<>();
        for(int i = 1; i <= this.bolaMayor; i++) {
            this.bombo.add(i);
        }
    }
    

    public HashSet<Carton> getCartonesGenerados() {
        return new HashSet<>(this.cartonesGenerados);
    }

    //METODOS
    public int girar() {
        Collections.shuffle(this.bombo);
        int bola = this.bombo.removeFirst();
        this.ultimaBola = bola;
        this.bolasExtraidas.add(bola);
        for(Carton crt : this.cartonesGenerados) {
            if(crt.isBingo(this.bolasExtraidas)) {
                this.cartonesBingo.add(crt);
            }
        }
        return bola;
    }
    
    
    protected abstract boolean esAceptable(Carton carton);
    public Carton generarCarton() {
        Carton carton;
        LinkedList<Integer> numerosCarton = new LinkedList<>();
        do {
            Collections.shuffle(this.bombo);
            for(int i = 0; i < this.tamañoCarton; i++) {
                numerosCarton.add(this.bombo.get(i));
            }
            carton = new Carton(numerosCarton, this.tamañoCarton);
        } while(this.cartonesGenerados.contains(carton) && esAceptable(carton));
        this.cartonesGenerados.add(carton);
        return carton;
    }
}
