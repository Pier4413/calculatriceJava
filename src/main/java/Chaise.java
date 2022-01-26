public class Chaise {
    
/// Attributs

    private int nombreDePieds;
    private boolean dossier;
    private int nombreAssise;
    private boolean accoudoirs;

/// Constructeur

    public Chaise(int pieds , boolean dossier , int assise , boolean accoudoirs){

        this.nombreDePieds=pieds;
        this.dossier=dossier;
        this.nombreAssise=assise;
        this.accoudoirs=accoudoirs;

    }



    public int getNombreDePieds() {
        return nombreDePieds;
    }


    public void setNombredePieds(int pieds){
        this.nombreDePieds = pieds;
    }

    public boolean getDossier() {
        return dossier;
    }

    public void setDossier(boolean dossier) {
        this.dossier = dossier;
    }

    public int getNombreAssise() {
        return nombreAssise;
    }

    public void setNombreAssise(int nombreAssise) {
        this.nombreAssise = nombreAssise;
    }

    public boolean isAccoudoirs() {
        return accoudoirs;
    }

    public void setAccoudoirs(boolean accoudoirs) {
        this.accoudoirs = accoudoirs;
    }


}
