package es.iesfranciscodelosrios.currency;

import javafx.beans.property.SimpleIntegerProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Contador extends Thread{
    private int OneCent;
    private int TwoCent;
    //SimpleIntegerProperty;
    private int FiveCent;
    private int TenCent;
    private int TwentyCent;
    private int FiftyCent;
    private int OneEuro;
    private int TwoEuro;
    private int cuentaParcial;
    private Productor pro;
    private ContadorTotal contTotal;
    private Integer[] Monedas;
    private Object cand;
    private Boolean canIEnter;
    
    public Contador() {
    	
    }

    public Contador(Productor p, ContadorTotal ct, Object candado){
        this.pro=p;
        this.contTotal=ct;
        Monedas = new Integer[8];
        Monedas[0]=0;
        Monedas[1]=0;
        Monedas[2]=0;
        Monedas[3]=0;
        Monedas[4]=0;
        Monedas[5]=0;
        Monedas[6]=0;
        Monedas[7]=0;
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

    public Integer[] getMonedas() {
        return Monedas;
    }

    public int getCuentaParcial() {
        return cuentaParcial;
    }

    public void setCuentaParcial(int cuentaParcial) {
        this.cuentaParcial = cuentaParcial;
    }

    public void CuentaMoneda(int moneda){
        switch (moneda){
            case 1: 
            		Monedas[0]= ++OneCent;
                System.out.println("1 cent");
            		break;
            case 2:
                Monedas[1]= ++TwoCent;
                System.out.println("2 cent");
            		break;
            case 5:
                Monedas[2]= ++FiveCent;
                System.out.println("5 cent");
                	break;
            case 10:
                Monedas[3]= ++TenCent;
                System.out.println("10 cent");
            		break;
            case 20:
                Monedas[4]= ++TwentyCent;
                System.out.println("20 cent");
            		break;
            case 50:
                Monedas[5]= ++FiftyCent;
                System.out.println("50 cent");
                	break;
            case 100:
                Monedas[6]= ++OneEuro;
                System.out.println("100 cent");
                	break;
            case 200:
                Monedas[7]= ++TwoEuro;
                System.out.println("200 cent");
            		break;
            default: break;
        }
    }

    public void asignarMonedas(){
        Monedas[0]=this.OneCent;
        Monedas[1]=this.TwoCent;
    }

    @Override
    public void run() {
        pro.start();
        try {
            while(pro.getnMonedas()>0){
                synchronized (cand){
                    cand.wait();
                }
                CuentaMoneda(pro.getBuffer());
                cuentaParcial= pro.getBuffer();
                synchronized (cand){
                    Thread.sleep(1000);
                    cand.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
