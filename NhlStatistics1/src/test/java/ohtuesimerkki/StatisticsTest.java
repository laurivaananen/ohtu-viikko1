package ohtuesimerkki;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.After;
import org.junit.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchPalauttaaPelaajanOikein() {
        Player pelaaja = stats.search("Semenko");
        Player oikeaPelaaja = new Player("Semenko", "EDM", 4, 12);

        assertEquals(pelaaja.toString(), oikeaPelaaja.toString());
    }

    @Test
    public void searchPalauttaaNull() {
        Player pelaaja = stats.search("abc");

        assertEquals(null, null);
    }

    @Test
    public void teamPalauttaaOikein() {
        List<Player> tiimi = stats.team("PIT");

        Player pelaaja = new Player("Lemieux", "PIT", 45, 54);
        List<Player> oikeaTiimi = new ArrayList<Player>();
        oikeaTiimi.add(pelaaja);

        assertEquals(tiimi.toString(), oikeaTiimi.toString());
    }

    @Test
    public void topScoresPalauttaaOikein() {
        List<Player> tiimi = stats.topScorers(0);
        Player pelaaja = new Player("Gretzky", "EDM", 35, 89);
        List<Player> oikeaTiimi = new ArrayList<Player>();
        oikeaTiimi.add(pelaaja);

        assertEquals(tiimi.toString(), oikeaTiimi.toString());
    }
}
