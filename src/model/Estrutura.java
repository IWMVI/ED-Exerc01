package model;

public class Estrutura {

    private No[][] indexVetor;

    public Estrutura() {
        indexVetor = new No[26][];
        for (int i = 0; i < 26; i++) {
            indexVetor[i] = new No[10];
        }
    }

    public void adicionarNome(String nome) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome inválido");
            }

            nome = primeiraLetraMaiuscula(nome);

            char primeiraLetra = nome.charAt(0);
            int index = primeiraLetra - 'A';

            if (index < 0 || index >= 26) {
                throw new IllegalArgumentException("A primeira letra não está no alfabeto");
            }

            int posicao = encontrarPosicaoVazia(indexVetor[index]);

            if (posicao == -1) {
                No[] novoVetor = new No[indexVetor[index].length * 2];
                System.arraycopy(indexVetor[index], 0, novoVetor, 0, indexVetor[index].length);
                indexVetor[index] = novoVetor;

                posicao = encontrarPosicaoVazia(indexVetor[index]);
            }

            indexVetor[index][posicao] = new No(nome);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar nome: " + e.getMessage());
        }
    }

    public void listarNomes() {
        for (int i = 0; i < indexVetor.length; i++) {
            for (int j = 0; j < indexVetor[i].length && indexVetor[i][j] != null; j++) {
                System.out.println("Nome: " + indexVetor[i][j].nome + ", Índice: " + j);
            }
        }
    }

    public void listarNomesPorLetra(char letra) {
        try {
            letra = Character.toUpperCase(letra);

            int index = letra - 'A';

            if (index < 0 || index >= 26) {
                throw new IllegalArgumentException("A letra não está no alfabeto");
            }

            for (int j = 0; j < indexVetor[index].length && indexVetor[index][j] != null; j++) {
                System.out.println("Nome: " + indexVetor[index][j].nome + ", Índice: " + j);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar nomes por letra: " + e.getMessage());
        }
    }

    public void removerNome(String nome) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome inválido");
            }

            nome = primeiraLetraMaiuscula(nome);

            char primeiraLetra = nome.charAt(0);
            int index = primeiraLetra - 'A';

            if (index < 0 || index >= 26) {
                throw new IllegalArgumentException("A primeira letra não está no alfabeto");
            }

            for (int j = 0; j < indexVetor[index].length && indexVetor[index][j] != null; j++) {
                if (indexVetor[index][j].nome.equals(nome)) {
                    indexVetor[index][j] = null;
                    compactarVetor(indexVetor[index]);
                    System.out.println("Nome removido: " + nome);
                    return;
                }
            }

            System.out.println("Nome não encontrado: " + nome);
        } catch (Exception e) {
            System.out.println("Erro ao remover nome: " + e.getMessage());
        }
    }

    private int encontrarPosicaoVazia(No[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private void compactarVetor(No[] vetor) {
        int j = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                vetor[j++] = vetor[i];
            }
        }
        for (; j < vetor.length; j++) {
            vetor[j] = null;
        }
    }

    private String primeiraLetraMaiuscula(String palavra) {
        if (palavra == null || palavra.isEmpty()) {
            return palavra;
        }
        return Character.toUpperCase(palavra.charAt(0)) + palavra.substring(1).toLowerCase();
    }

    // Exercício 02

    public int indice(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        nome = primeiraLetraMaiuscula(nome);

        char primeiraLetra = nome.charAt(0);
        int index = primeiraLetra - 'A';

        if (index < 0 || index >= 26) {
            throw new IllegalArgumentException("A primeira letra não está no alfabeto");
        }

        for (int j = 0; j < indexVetor[index].length && indexVetor[index][j] != null; j++) {
            if (indexVetor[index][j].nome.equals(nome)) {
                return j;
            }
        }

        throw new IllegalArgumentException("Nome não encontrado: " + nome);
    }

}