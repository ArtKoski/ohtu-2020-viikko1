package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void varastoTilavuusAlleNolla() {
    	Varasto varasto = new Varasto(-5);
    	assertEquals(varasto.getTilavuus(), 0.0, vertailuTarkkuus);
    }
    
    @Test
    public void konstruktori2TilaavuusYliNolla() {
    	Varasto varasto2 = new Varasto(10, 5.0);
        assertEquals(varasto2.getTilavuus(), 10.0, vertailuTarkkuus);
        
    }
    
    @Test
    public void konstruktori2SaldoAlleTilavuuden() {
    	Varasto varasto2 = new Varasto(10, 5.0);
    	assertEquals(varasto2.getSaldo(), 5.0, vertailuTarkkuus);
    	        
    }
    
    @Test
    public void konstruktori2TilavuusAlleNolla() {
    	Varasto varasto2 = new Varasto(-10, 5.0);
        assertEquals(varasto2.getTilavuus(), 0.0, vertailuTarkkuus);	        
    }
    
    @Test
    public void konstruktori2SaldoAlleNolla() {
    	Varasto varasto2 = new Varasto(10, -5.0);
        assertEquals(varasto2.getSaldo(), 0.0, vertailuTarkkuus);	        
    }
     
    @Test
    public void konstruktori2SaldoYliTilavuuden() {
    	Varasto varasto2 = new Varasto(10, 15.0);
        assertEquals(varasto2.getSaldo(), 10.0, vertailuTarkkuus);	        
    }
        
    @Test
    public void lisaaVarastoonAlleNolla() {
    	double tmpr = varasto.getSaldo();
    	varasto.lisaaVarastoon(-5);
    	assertEquals(tmpr, varasto.getSaldo(), vertailuTarkkuus);
    	
    }
    
    @Test
    public void otaVarastostaAlleNolla() {
    	assertEquals(varasto.otaVarastosta(-5), 0.0, vertailuTarkkuus);
    }
    
    @Test
    public void lisaaVarastoonEnemmanKuinMahtuu() {
    	double tmpr = varasto.paljonkoMahtuu();
    	varasto.lisaaVarastoon((tmpr+2));
    	assertEquals(varasto.getSaldo(), varasto.getTilavuus(), vertailuTarkkuus);	
    }
    
    @Test
    public void otaVarastostaKaikki() {
    	double tmpr = varasto.getSaldo();
    	assertEquals(
    	    	varasto.otaVarastosta((varasto.getSaldo()+1)), tmpr, vertailuTarkkuus);
    	
    }
    
    @Test
    public void toStringTest() {
    	double saldo = varasto.getSaldo();
    	double tilaa = varasto.paljonkoMahtuu();
    	assertEquals(varasto.toString(), "saldo = " + saldo + ", vielä tilaa" + tilaa);
    }
    

}