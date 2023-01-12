package es.iesfranciscodelosrios.currency;

import java.util.ArrayList;

public class ContadorTotal {
    private int TotalDine;

    public synchronized void IncrementarDine(ArrayList<Integer> Monedas){
        ArrayList<Integer> TipoMoneda= new ArrayList<>();

        if (Monedas.get(0)>0){
            TipoMoneda.add(0,Monedas.get(0));
        }
        if (Monedas.get(1)>0){
            TipoMoneda.add(1,Monedas.get(1));
        }
        if (Monedas.get(2)>0){
            TipoMoneda.add(2,Monedas.get(2));
        }
        if (Monedas.get(3)>0){
            TipoMoneda.add(3,Monedas.get(3));
        }
        if (Monedas.get(4)>0){
            TipoMoneda.add(4,Monedas.get(4));
        }
        if (Monedas.get(5)>1){
            TipoMoneda.add(5,Monedas.get(5));
        }
        if (Monedas.get(6)>1){
            TipoMoneda.add(6,Monedas.get(6));
        }
        if (Monedas.get(7)>1){
            TipoMoneda.add(7,Monedas.get(7));
        }
    }
}
