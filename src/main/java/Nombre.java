public class Nombre {
    
    private int value = 0;

    /**
     * Constructeur
     * @param v : Valeur que l'on donne au nombre
     */
    public Nombre(int v) {
        this.value = v;
    }

    /**
     * Override de toString
     */
    @Override
    public String toString() {
        return "Valeur : "+this.value;
    }

    /**
     * Getter de la valeur
     * @return La valeur
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Setter de la valeur
     * @param v : La valeur
     */
    public void setValue(int v) {
        this.value = v;
    }
}