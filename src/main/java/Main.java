public class Main {
    public static void main(String args[])  //static method  
    {  
        System.out.println("Static method");

        Nombre number1 = new Nombre(3);
        Nombre number2 = new Nombre(5);
        Nombre number3 = number1.addition(number2);
        Nombre number4 = number2.division(number2);
        Nombre number5 = number2.pourcentage(number1);



        System.out.println(number3);
        System.out.println(number4);
        System.out.println(number5);
    } 

}
