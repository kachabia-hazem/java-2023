import java.time.LocalDate;
import java.util.Arrays;


public class BilletTaggable extends Billet implements Taggable {
     String[] ltags;
     int nbtags;
     public BilletTaggable(LocalDate datePub, String auteur, int capacite){
        super(datePub,auteur);
        ltags=new String[capacite];
     }
     public void  listerBilletTaggable(){
        for(int i=0;i<ltags.length;i++){
            System.out.println(ltags[i]+"|");
        }
     }
     public String toString(){
        return(super.toString()+"la liste est"+Arrays.toString(ltags)+"le nombre de billet est"+this.nbtags);
     }
     public void ajoutTag(String tag){
        if(nbtags<ltags.length){
            boolean test=false;
            int i=0;
            while(i<ltags.length && test==false){
                if(ltags[i]==tag){
                    test=true;
                    break;
                }
                else{
                    i++;
                };

            }
            if(test==false){
            nbtags++;
            ltags[nbtags]=tag;
            }
        }
        else{
            System.out.println("est complet");
        }
     }
     public void supprimeTag(String tag){
        boolean test=false;
        int i=0;
        int j=0;
        while(i<ltags.length && test==false){
            if(ltags[i]==tag){
                test=true;
                for(j=i;j<=ltags.length;j++){
                    ltags[j]=ltags[j+1];
                    nbtags--;
                }
            }
            else{
                i++;
            }
        }
     }
     public int nombreTags(){
        return ltags.length;
     }
     public int rechercheTag(String tag){
        boolean test=false;
        int  i=0;
        while(i<ltags.length && test==false){
            if(ltags[i]==tag){
                return i;
            }
            else{
                i++;
            }
        }
        if(i==ltags.length && test==false){
            return -1;
        }
                return i;

     }

    
}
