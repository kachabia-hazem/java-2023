import java.time.LocalDate;

public class Billet implements Publiable {
     LocalDate dateP;
     String auteur;

public Billet(LocalDate datep,String a){
    this.dateP=datep;
    this.auteur=a;

}
public String toString(){
    return ("lauteur est"+this.auteur+"la date de publication est"+this.dateP);
}
@Override
public LocalDate getDatePublication() {
    return this.dateP;
    
}
@Override
public String getAuteur() {
    return this.auteur;
}




}
    
