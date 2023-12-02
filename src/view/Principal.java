package view;

import java.util.Scanner;
import model.Estrutura;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estrutura estrutura = new Estrutura();

        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar nome");
            System.out.println("2. Remover nome");
            System.out.println("3. Listar nomes por letra");
            System.out.println("4. Listar todos os nomes");
            System.out.println("5. Obter nome e índice");
            System.out.println("0. Sair");

            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome a ser adicionado: ");
                    String nomeAdicionar = scanner.nextLine();
                    estrutura.adicionarNome(nomeAdicionar);
                    break;
                case 2:
                    System.out.print("Digite o nome a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    estrutura.removerNome(nomeRemover);
                    break;
                case 3:
                    System.out.print("Digite a letra para listar os nomes: ");
                    char letra = scanner.nextLine().charAt(0);
                    estrutura.listarNomesPorLetra(letra);
                    break;
                case 4:
                    estrutura.listarNomes();
                    break;
                case 5:
                    System.out.print("Digite o nome para obter o índice: ");
                    String nomeObterIndice = scanner.nextLine();
                    int indiceObtido = estrutura.indice(nomeObterIndice);
                    System.out.println("Nome: " + nomeObterIndice + ", Índice: " + indiceObtido);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}