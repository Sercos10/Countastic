package es.iesfranciscodelosrios.currency;

import java.util.Random;

public class Hucha {
    private int OneCent;
    private int TwoCent;
    private int FiveCent;
    private int TenCent;
    private int TwentyCent;
    private int FiftyCent;
    private int OneEuro;
    private int TwoEuro;
    private Integer[] Monedas;
    private int nMonedas;

    public Hucha(int monedas){
        this.nMonedas=monedas;
        Monedas = new Integer[8];
        Monedas[0]=0;
        Monedas[1]=0;
        Monedas[2]=0;
        Monedas[3]=0;
        Monedas[4]=0;
        Monedas[5]=0;
        Monedas[6]=0;
        Monedas[7]=0;
    }

    public int getnMonedas() {
        return nMonedas;
    }
    public Integer[] getMonedas() {
        return Monedas;
    }

    /**
     * Metodo en el que genera una de moneda de 1 cent,2 cent,5 cent,10 cent,20 cent,50 cent,1€,2€
     * y lo guarda en el buffer para que el contador pueda coger la moneda y resta una moneda del total
     * @return la moneda de 1,2,5,10,20,50,1€,2€
     */
    public synchronized int cogerMoneda(){
        if (nMonedas>0){
            Random randomGenerator=new Random();
            int tipo =randomGenerator.nextInt(8) + 1;
            int moneda= 0;
            switch (tipo){
                case 1: moneda=1;
                    break;
                case 2: moneda=2;
                    break;
                case 3: moneda=5;
                    break;
                case 4: moneda=10;
                    break;
                case 5: moneda=20;
                    break;
                case 6: moneda=50;
                    break;
                case 7: moneda=100;
                    break;
                case 8: moneda=200;
                    break;
                default:break;
            }
            nMonedas--;
            return moneda;
        }
        return 0;
    }

    public synchronized void CuentaMoneda(int moneda){
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
}
