import java.util.Scanner;

class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    // Construtor
    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    // calcular IMC
    public void calculaIMC() {
        imc = peso / (altura * altura);
    }

    // informar faixa de obesidade
    public String informaObesidade() {

        if (imc < 18.5)
            return "Abaixo do peso";
        else if (imc <= 24.9)
            return "Peso normal";
        else if (imc <= 29.9)
            return "Sobrepeso";
        else if (imc <= 34.9)
            return "Obesidade grau 1";
        else if (imc <= 39.9)
            return "Obesidade grau 2";
        else
            return "Obesidade grau 3";
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.print("Altura (ex: 1.75): ");
        double altura = sc.nextDouble();

        System.out.print("Peso: ");
        double peso = sc.nextDouble();

        Pessoa p = new Pessoa(nome, sobrenome, idade, altura, peso);

        p.calculaIMC();

        System.out.println("\nIMC: " + p.getImc());
        System.out.println("Classificação: " + p.informaObesidade());

        sc.close();
    }
}