import es.iesfranciscodelosrios.currency.Contador;
import es.iesfranciscodelosrios.currency.ContadorTotal;
import es.iesfranciscodelosrios.currency.Productor;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void TestContarHijos() throws InterruptedException {
        ContadorTotal ct= new ContadorTotal();
        Object candado1= new Object();
        Productor p1 = new Productor(candado1);
        Contador c1 = new Contador(p1,ct,candado1);
        c1.start();
        c1.join();
    }
}
