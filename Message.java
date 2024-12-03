import java.time.LocalDate;

public class Message extends Billet {
    String contenu;
 public Message(LocalDate datePub, String auteur, String contenu){
    super(datePub,auteur);
    this.contenu=contenu;
 }
   String getContenu(){
    return this.contenu;
   } 
}
