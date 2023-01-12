package es.iesfranciscodelosrios.currency;

import java.util.ArrayList;

public class Contador extends Thread{
    private int OneCent;
    private int TwoCent;
    private int FiveCent;
    private int TenCent;
    private int TwentyCent;
    private int FiftyCent;
    private int OneEuro;
    private int TwoEuro;
    private Productor pro;
    private ContadorTotal contTotal;
    private ArrayList<Integer> Monedas;

    private Contador(Productor p, ContadorTotal ct){
        this.pro=p;
        this.contTotal=ct;
        Monedas= new ArrayList<>();
    }

    public void CuentaMoneda(int moneda){
        switch (moneda){
            case 1: OneCent++;
                break;
            case 2: TenCent++;
                break;
            case 5: FiveCent++;
                break;
            case 10: TenCent++;
                break;
            case 20: TwentyCent++;
                break;
            case 50: FiftyCent++;
                break;
            case 100: OneEuro++;
                break;
            case 200: TwoEuro++;
                break;
        }
    }

    public int getOneCent() {
        return OneCent;
    }

    public int getTwoCent() {
        return TwoCent;
    }

    public int getFiveCent() {
        return FiveCent;
    }

    public int getTenCent() {
        return TenCent;
    }

    public int getTwentyCent() {
        return TwentyCent;
    }

    public int getFiftyCent() {
        return FiftyCent;
    }

    public int getOneEuro() {
        return OneEuro;
    }

    public int getTwoEuro() {
        return TwoEuro;
    }

    public Productor getPro() {
        return pro;
    }

    public ContadorTotal getContTotal() {
        return contTotal;
    }

    public ArrayList<Integer> getMonedas() {
        return Monedas;
    }

    @Override
    public void run() {
        CuentaMoneda(pro.cogerMoneda());
        contTotal.IncrementarDine(Monedas);
    }
}
