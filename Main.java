import java.util.Scanner;
import java.util.Calendar;

class Data {
    int dia;
    int mes;
    int ano;

    Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
}

class Pessoa {
    String nome;
    String sobrenome;
    double peso;
    double altura;
    Data dataNascimento;

    Pessoa(String nome, String sobrenome, double peso, double altura, Data dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    int calculaIdade() {
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH) + 1;
        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);

        int idade = anoAtual - dataNascimento.ano;

        if (mesAtual < dataNascimento.mes) {
            idade--;
        } else if (mesAtual == dataNascimento.mes && diaAtual < dataNascimento.dia) {
            idade--;
        }

        return idade;
    }

    double calcularIMC() {
        return peso / (altura * altura);
    }

    String classificacaoIMC() {
        double imc = calcularIMC();

        if (imc < 18.5) return "Abaixo do peso";
        else if (imc < 25) return "Peso normal";
        else if (imc < 30) return "Sobrepeso";
        else if (imc < 35) return "Obesidade grau I";
        else if (imc < 40) return "Obesidade grau II";
        else return "Obesidade grau III";
    }

    String nomeReferencia() {
        return sobrenome + ", " + nome.toUpperCase();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[10];
        int count = 0;

        for (int i = 0; i < 10; i++) {

            System.out.println("Digite o nome:");
            String nome = sc.nextLine();

            System.out.println("Digite o sobrenome:");
            String sobrenome = sc.nextLine();

            if (i > 0) {
                if (nome.equalsIgnoreCase(pessoas[i-1].nome) &&
                    sobrenome.equalsIgnoreCase(pessoas[i-1].sobrenome)) {
                    break;
                }
            }

            System.out.println("Digite o peso:");
            double peso = sc.nextDouble();

            System.out.println("Digite a altura:");
            double altura = sc.nextDouble();
            sc.nextLine();

            System.out.println("Digite a data de nascimento (dd/mm/aaaa):");
            String data = sc.nextLine();

            String[] partes = data.split("/");

            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);

            Data nascimento = new Data(dia, mes, ano);

            pessoas[i] = new Pessoa(nome, sobrenome, peso, altura, nascimento);

            count++;
        }

        System.out.println("\n--- DADOS CADASTRADOS ---\n");

        for (int i = 0; i < count; i++) {

            Pessoa p = pessoas[i];

            System.out.println("Cadastro " + (i+1) + ":");
            System.out.println("Nome completo: " + p.nome + " " + p.sobrenome);
            System.out.println("Nome de referência: " + p.nomeReferencia());
            System.out.println("Idade: " + p.calculaIdade());
            System.out.println("Peso: " + p.peso);
            System.out.println("Altura: " + p.altura);
            System.out.printf("IMC: %.2f\n", p.calcularIMC());
            System.out.println("Classificação: " + p.classificacaoIMC());
            System.out.println();
        }

        sc.close();
    }
}