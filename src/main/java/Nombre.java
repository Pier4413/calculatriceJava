public class Nombre {
    
    private float value = 0;

    /**
     * Constructeur
     * @param v : Valeur que l'on donne au nombre
     */
    public Nombre(float v) {
        this.value = v;
    }

    /**
     * Override de toString
     */
    @Override
    public String toString() {
        return String.format("%.06f", this.value);
    }

    /**
     * Getter de la valeur
     * @return La valeur
     */
    public float getValue() {
        return this.value;
    }

    /**
     * Setter de la valeur
     * @param v : La valeur
     */
    public void setValue(float v) {
        this.value = v;
    }

    /**
     * Additionne deux nombres entre eux
     * @param other : le nombre a additionné
     * @return Le resultat dans un nombre
     */
    public Nombre addition(Nombre other) {
         return new Nombre(this.value + other.value);
    }
    
    /**
     * Divise le nombre courant par un autre nombre
     * @param other : Le nombre diviseur
     * @return Le resultat dans un nombre
     */
    public Nombre division(Nombre other) {
        if(other.value != 0)
        {
            return new Nombre(this.value / other.value);
        }
        return new Nombre(0);
    }

    /**
     * Soustrait un nombre au nombre courant
     * @param other : Le nombre
     * @return Le resultat dans un nombre
     */
    public Nombre soustraction(Nombre other) {
        return new Nombre(this.value - other.value);
    }

    /**
     * Multiplie un nombre avec le nombre courant
     * @param other : L'autre nombre
     * @return Le resultat dans un nombre
     */
    public Nombre multiplication(Nombre other) {
        return new Nombre(this.value * other.value);
    }

    /**
     * Calcule un pourcentage par un autre nombre
     * @param other : L'autre nombre
     * @return Le resultat dans un nombre
     */
    public Nombre pourcentage(Nombre other) {
        return new Nombre(this.division(other).getValue() * 100);
    }

    /**
     * Ajoute un nombre a la fin du nombre actuel
     * @param v : Le nombre a ajouter
     */
    public void addToEnd(float v) {
        // TODO Faire le calcul tel que si la valeur courant est 4 et que la valeur a ajouter est 3 alors la nouvelle valeur dans l'objet courant est 43
        /*Nombre multiplicateurPar10 = new Nombre(10);
        Nombre resultat = this.multiplication(multiplicateurPar10);
        this.value = resultat.getValue();*/

        // Exemple : Départ Valeur courante = 4
        this.value = multiplication(new Nombre(10)).getValue();
        // Exemple : Ici Valeur courante = 40
        this.value = addition(new Nombre(v)).getValue();
        // Exemple : Ici Valeur courante = 43
        //this.value = this.value * 10 + v;
    }

}

