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
        return String.format("%f", this.value);
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
     * @return le résultat
     */
    public Nombre addition(Nombre other) {
         return new Nombre(this.value + other.value);
    }
    
    public Nombre division(Nombre other) {
        if(other.value != 0)
        {
            return new Nombre(this.value / other.value);
        }
    return new Nombre(0);
    }

    public Nombre soustraction(Nombre other) {
        return new Nombre(this.value - other.value);
    }

    public Nombre multiplication(Nombre other) {
        return new Nombre(this.value * other.value);
    }

    public Nombre pourcentage(Nombre other) {
        return new Nombre(this.division(other).getValue() * 100);
    }

    public void addToEnd(int v) {
        this.value *= 10;
        this.value += v;
    }

}

