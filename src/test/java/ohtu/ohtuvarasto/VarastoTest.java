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
    public void eiPystyLisataEnemmanKuinMahtuu() {
        varasto.lisaaVarastoon(20);

        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void eiPytyOttamaanLiikaa() {
        double maara = varasto.otaVarastosta(5.0);

        assertEquals(0.0, maara, vertailuTarkkuus);
    }

    @Test
    public void eiPystyTayttamaanLiikaa() {
        Varasto varasto = new Varasto(10.0, 20.0);

        assertEquals(10.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void eiPystyOttamaanNegatiivistaMaaraa() {
        double maara = varasto.otaVarastosta(-5.0);

        assertEquals(0.0, maara, vertailuTarkkuus);
    }

    @Test
    public void eiPystyLisataNegatiivistaMaaraa() {
        varasto.lisaaVarastoon(-10.0);

        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void tulostusOnOikein() {
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }

    @Test
    public void eiPystyTehdaVarastoaNegatiivisellaSaldolla() {
        Varasto varasto = new Varasto(-10.0);

        assertEquals(0.0, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void eiPystyTekemaanVarastoaNegatiivisellaSaldolla() {
        Varasto varasto = new Varasto(-10.0, 0.0);

        assertEquals(0.0, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void eiPystyTekemaanVarastoaNegatiivisellaSadola() {
        Varasto varasto = new Varasto(10.0, -10.0);

        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void pystyyTekemaanVarastonSaldolla() {
        Varasto varasto = new Varasto(10.0, 5.0);

        assertEquals(5.0, varasto.getSaldo(), vertailuTarkkuus);
    }
}
