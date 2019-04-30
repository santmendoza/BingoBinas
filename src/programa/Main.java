package programa;

import clases.Bingo;
import clases.BingoAmericano;
import clases.BingoClasico;
import clases.Carton;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Bingo> bingos = new ArrayList<>();
        BingoClasico bingoC = new BingoClasico(5);
        BingoAmericano bingoAm = new BingoAmericano();
        bingos.add(bingoAm);
        bingos.add(bingoC);

        ArrayList<Carton> CartonClasico = new ArrayList<>();
        ArrayList<Carton> CartonAmericano = new ArrayList<>();

        for (int i = 0; i < bingos.size(); i++) {
            for (int y = 0; y < 5; y++) {
                if (bingos.get(i).getClass() == BingoClasico.class) {
                    CartonClasico.add(bingos.get(i).generarCarton());
                } else {
                    CartonAmericano.add(bingos.get(i).generarCarton());
                }
            }
        }

        for (int i = 0; i < CartonClasico.size(); i++) {
            System.out.println(CartonClasico.get(i).toString());
        }
        for (int i = 0; i < CartonAmericano.size(); i++) {
            System.out.println(CartonClasico.get(i).toString());
        }
        for (int i = 0; i < bingos.size(); i++) {
            while (bingos.get(i).finalizado) {
                System.out.println(bingos.get(i).girar());
            }
        }
    }

}
