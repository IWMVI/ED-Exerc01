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
            System.out.println("3. Listar todos os nomes com índices");
            System.out.println("4. Verificar se nome existe");
            System.out.println("5. Exibir quantidade de nomes");
            System.out.println("6. Renomear nome");
            System.out.println("0. Sair");

            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarNome(estrutura, scanner);
                    break;
                case 2:
                    System.out.print("Digite o nome a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    estrutura.excluirNome(nomeRemover);
                    break;
                case 3:
                    estrutura.listarNomesPorIndice();
                    break;
                case 4:
                    System.out.print("Digite o nome para verificar se existe: ");
                    String nomeVerificar = scanner.nextLine();
                    if (estrutura.nomeExiste(nomeVerificar)) {
                        System.out.println("O nome existe na estrutura.");
                    } else {
                        System.out.println("O nome não existe na estrutura.");
                    }
                    break;
                case 5:
                    System.out.println("Quantidade de nomes: " + estrutura.quantidadeDeNomes());
                    break;
                case 6:
                    System.out.print("Digite o nome antigo: ");
                    String nomeAntigo = scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String nomeNovo = scanner.nextLine();
                    estrutura.renomearNome(nomeAntigo, nomeNovo);
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

    private static void adicionarNome(Estrutura estrutura, Scanner scanner) {
        System.out.print("Digite o nome a ser adicionado: ");
        String nomeAdicionar = scanner.nextLine();
        estrutura.adicionarNome(nomeAdicionar);
    }
}
