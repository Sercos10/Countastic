package es.iesfranciscodelosrios.currency;

import java.util.ArrayList;
import java.util.Random;

public class Contador extends Thread{
    private int OneCent;
    private int TwoCent;
    private int FiveCent;
    private int TenCent;
    private int TwentyCent;
    private int FiftyCent;
    private int OneEuro;
    private int TwoEuro;
    private int cuentaParcial;
    private Productor pro;
    private ContadorTotal contTotal;
    private ArrayList<Integer> Monedas;
    private Object cand;

    private Contador(Productor p, ContadorTotal ct, Object candado){
        this.pro=p;
        this.contTotal=ct;
        Monedas= new ArrayList<>();
        this.cand=candado;
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

    public void CuentaMoneda(int moneda){
        switch (moneda){
            case 1: 
            		Monedas.add(0, OneCent++);
            		break;
            case 2: 
            		Monedas.add(1, TenCent++);
            		break;
            case 5: 
            		Monedas.add(2, FiveCent++);
                	break;
            case 10: 
            		Monedas.add(3, TenCent++);
            		break;
            case 20: 
            		Monedas.add(4, TwentyCent++);
            		break;
            case 50:
            		Monedas.add(5, FiftyCent++);
                	break;
            case 100: 
            		Monedas.add(6, OneEuro++);
                	break;
            case 200: 
            		Monedas.add(7, TwoEuro++);
            		break;
        }
    }

    @Override
    public void run() {
        pro.start();
        try {
            Random randomGenerator=new Random();
            while(pro.getnMonedas()>0){
                int tipo =randomGenerator.nextInt(1000) + 500;
                cand.wait();
                CuentaMoneda(pro.getBuffer());
                cuentaParcial= pro.getBuffer();
                Thread.sleep(tipo);
                cand.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
