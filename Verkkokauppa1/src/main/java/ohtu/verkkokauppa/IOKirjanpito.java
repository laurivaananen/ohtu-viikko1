package ohtu.verkkokauppa;

import java.util.ArrayList;;

public interface IOKirjanpito {
    void lisaaTapahtuma(String tapahtuma);
    ArrayList<String> getTapahtumat();
}