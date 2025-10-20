package application;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entities.Cliente;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Cliente> list = new ArrayList<>();

        System.out.print("Quantos clientes serão cadastrados? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nCadastro do cliente #" + (i + 1));
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            BigInteger nCartao = gerarNumero();
            System.out.println("Número do cartão: " + nCartao);

            Cliente cli = new Cliente(nome, email, nCartao);
            list.add(cli);
        }

        System.out.println();
        System.out.println("Lista de Clientes:");
        for (Cliente c: list) {
            System.out.println(c);
        }

        sc.close();

        try {
            FileWriter registro = new FileWriter("clientes.txt", true);

            for (Cliente c : list) {
                registro.write("Nome: " + c.getNome() + "\n");
                registro.write("Email: " + c.getEmail() + "\n");
                registro.write("Número do Cartão: " + c.getnCartao() + "\n");
                registro.write("-----------------------------\n");
            }

            registro.close();
            System.out.println("\nClientes salvos em 'clientes.txt'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo.");
            e.printStackTrace();
        }
    }

    public static BigInteger gerarNumero() {
        Random gerador = new Random();
        String numero = "";

        numero += gerador.nextInt(9) + 1;

        for (int i = 1; i < 16; i++) {
            numero += gerador.nextInt(10);
        }

        return new BigInteger(numero);
    }
}