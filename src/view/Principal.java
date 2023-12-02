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
            System.out.println("3. Listar todos os nomes por índice");
            System.out.println("4. Verificar se nome existe");
            System.out.println("5. Exibir quantidade de nomes");
            System.out.println("6. Alterar nome");
            System.out.println("0. Sair");

            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarNome(scanner);
                    break;
                case 2:
                    System.out.print("Digite o nome a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    Estrutura.excluirNome(nomeRemover);
                    break;
                case 3:
                    listarNomesPorIndice();
                    break;
                case 4:
                    System.out.print("Digite o nome para verificar se existe: ");
                    String nomeVerificar = scanner.nextLine();
                    if (Estrutura.nomeExiste(nomeVerificar)) {
                        System.out.println("O nome existe na estrutura.");
                    } else {
                        System.out.println("O nome não existe na estrutura.");
                    }
                    break;
                case 5:
                    System.out.println("Quantidade de nomes: " + Estrutura.quantidadeDeNomes());
                    break;
                case 6:
                    alterarNome(scanner);
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

    private static void adicionarNome(Scanner scanner) {
        System.out.print("Digite o nome a ser adicionado: ");
        String nomeAdicionar = scanner.nextLine();

        if (Estrutura.nomeExiste(nomeAdicionar)) {
            System.out.println("O nome já existe na estrutura. Deseja alterar? (S/N)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                Estrutura.renomearNome(nomeAdicionar, novoNome);
            }
        } else {
            Estrutura.adicionarNome(nomeAdicionar);
        }
    }

    private static void alterarNome(Scanner scanner) {
        System.out.print("Digite o nome a ser alterado: ");
        String nomeAntigo = scanner.nextLine();
        if (Estrutura.nomeExiste(nomeAntigo)) {
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            Estrutura.renomearNome(nomeAntigo, novoNome);
        } else {
            System.out.println("O nome não existe na estrutura. Não é possível alterar.");
        }
    }

    private static boolean verificarEAdicionarNome(String nome) {
        if (Estrutura.nomeExiste(nome)) {
            System.out.println("O nome já existe na estrutura.");
            return true;
        } else {
            Estrutura.adicionarNome(nome);
            return false;
        }
    }

    private static void listarNomesPorIndice() {
        String[][] vetorDeArrays = Estrutura.getVetorDeArrays();

        for (int i = 0; i < vetorDeArrays.length; i++) {
            System.out.println("\nÍndice " + i + ":");

            for (String nome : vetorDeArrays[i]) {
                System.out.println(nome);
            }
        }
    }
}
