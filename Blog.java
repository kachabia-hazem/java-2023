import java.time.LocalDate;

public class Blog {
    private String titre;
    private Publiable[] lbillet;
    private int nbbillet;

    public Blog(String titre, int capacite) {
        this.titre = titre;
        lbillet = new Publiable[capacite];
        nbbillet = 0; // Initialisation à zéro
    }

    public void post(Publiable billet) throws InvalidUrlException {
        if (nbbillet < lbillet.length) {
            if (billet instanceof Video) {
                Video video = (Video) billet;
                if (video.getUrl().startsWith("https")) {
                    lbillet[nbbillet] = billet;
                    nbbillet++;
                } else {
                    throw new InvalidUrlException("URL n'est pas valide");
                }
            } else {
                lbillet[nbbillet] = billet;
                nbbillet++;
            }
        } else {
            System.out.println("Le blog est complet.");
        }
    }

    public Publiable[] rechercheBilletsTaggablesParAuteur(String auteur) {
        Publiable[] tp = new Publiable[nbbillet];
        int j = 0;

        for (int i = 0; i < nbbillet; i++) {
            if ((lbillet[i] instanceof Taggable) &&
                lbillet[i].getAuteur().equalsIgnoreCase(auteur)) {
                tp[j] = lbillet[i];
                j++;
            }
        }

        // Réduire la taille du tableau pour ne pas inclure les `null`
        Publiable[] result = new Publiable[j];
        System.arraycopy(tp, 0, result, 0, j);
        return result;
    }

    public Publiable getPlusRécentBillet() {
        if (nbbillet == 0) {
            return null; // Aucun billet disponible
        }

        Publiable plusRecent = lbillet[0];
        for (int i = 1; i < nbbillet; i++) {
            if (lbillet[i].getDatePublication().isAfter(plusRecent.getDatePublication())) {
                plusRecent = lbillet[i];
            }
        }
        return plusRecent;
    }
}

// Hypothèses : Interfaces ou classes externes nécessaires
interface Publiable {
    String getAuteur();
    LocalDate getDatePublication();
}

interface Taggable {}

class Video implements Publiable {
    private String url;
    private String auteur;
    private LocalDate datePublication;

    public Video(String url, String auteur, LocalDate datePublication) {
        this.url = url;
        this.auteur = auteur;
        this.datePublication = datePublication;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String getAuteur() {
        return auteur;
    }

    @Override
    public LocalDate getDatePublication() {
        return datePublication;
    }
}

class InvalidUrlException extends Exception {
    public InvalidUrlException(String message) {
        super(message);
    }
}
