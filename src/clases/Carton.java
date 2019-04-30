package clases;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class Carton {
    private final LinkedList <Integer> numeros;
    private int tamaño;
    
    public Carton(LinkedList<Integer> numeros, int tamaño) {
        Collections.sort(numeros);
        this.numeros = new LinkedList<>(numeros);
        this.tamaño = tamaño;
    }
    
    //METODOS GETTER
    public LinkedList<Integer> getNumerosCarton() {
        return new LinkedList<>(this.numeros);
    }
    
    //FUNCIONALIDAD
    public boolean isBingo(LinkedList <Integer> bolasExtraidas) {
        return this.numeros.containsAll(bolasExtraidas);
    }

    //Metodos de la Clase Object
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.numeros);
        hash = 73 * hash + this.tamaño;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carton other = (Carton) obj;
        if (this.tamaño != other.tamaño) {
            return false;
        }
        if (!Objects.equals(this.numeros, other.numeros)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carton {" + "Numeros = " + numeros + ", Tamano =" + tamaño + '}';
    }
}