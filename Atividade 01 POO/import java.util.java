import java.util.Scanner;

class TrianguloRetangulo {

    double h;
    double c1;
    double c2;

    // Calcula a hipotenusa ao quadrado (h²)
    public double CalculaHipotenusa() {
        h = (c1 * c1) + (c2 * c2);
        return h;
    }

    // Calcula a área
    public double CalculaArea() {
        return (c1 * c2) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TrianguloRetangulo t = new TrianguloRetangulo();

        System.out.print("Digite o cateto 1: ");
        t.c1 = sc.nextDouble();

        System.out.print("Digite o cateto 2: ");
        t.c2 = sc.nextDouble();

        System.out.println("Hipotenusa ao quadrado (h²): " + t.CalculaHipotenusa());
        System.out.println("Area do triangulo: " + t.CalculaArea());

        sc.close();
    }
}