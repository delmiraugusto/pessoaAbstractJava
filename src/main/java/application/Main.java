package application;

import entities.Pessoa;
import entities.PessoaFísica;
import entities.PessoaJurifica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Pessoa> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            sc.nextLine();
            char letter = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();

            if (letter == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                list.add(new PessoaFísica(name, anualIncome, healthExpenditures));
            }
            else {
                System.out.print("Number of employees: ");
                int numEmployees = sc.nextInt();
                list.add(new PessoaJurifica(name, anualIncome, numEmployees));
            }
        }

        double sum = 0.0;
        System.out.println("\nTAXES PAID:");
        for (Pessoa p : list) {
            System.out.println(p.getNome() + ": $ " + String.format("%.2f", p.calcularImposto()));
            sum += p.calcularImposto();
        }
        System.out.println("\nTOTAL TAXES: " + String.format("%.2f", sum));

        sc.close();
    }
}