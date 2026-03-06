import java.util.Scanner;

class TrianguloRetangulo {

    double h;
    double c1;
    double c2;

    // Método para calcular a hipotenusa
    double calculaHipotenusa(double c1, double c2) {
        h = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
        return h;
    }

    // Método para calcular a área
    double calculaArea(double c1, double c2) {
        double area = (c1 * c2) / 2;
        return area;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        TrianguloRetangulo t = new TrianguloRetangulo();

        System.out.print("Digite o valor do cateto 1: ");
        double c1 = teclado.nextDouble();

        System.out.print("Digite o valor do cateto 2: ");
        double c2 = teclado.nextDouble();

        double hipotenusa = t.calculaHipotenusa(c1, c2);
        double area = t.calculaArea(c1, c2);

        System.out.println("Hipotenusa = " + hipotenusa);
        System.out.println("Área do triângulo = " + area);
    }
}