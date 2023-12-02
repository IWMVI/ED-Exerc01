package model;
public class Estrutura {
    private static String[][] vetorDeArrays = new String[26][0];

    static {
        for (int i = 0; i < vetorDeArrays.length; i++) {
            vetorDeArrays[i] = new String[0];
        }
    }

    public static int indice(String nome) {
        char primeiraLetra = obterPrimeiraLetra(nome);

        if (!Character.isLetter(primeiraLetra)) {
            throw new IllegalArgumentException("O nome deve começar com uma letra do alfabeto.");
        }

        return primeiraLetra - 'a';
    }

    public static void adicionarNome(String nome) {
        int indice = indice(nome);
        String nomeFormatado = formatarNome(nome);

        String[] array = vetorDeArrays[indice];

        // Encontrar a posição correta para inserir o nome na ordem alfabética
        int posicaoInsercao = 0;
        while (posicaoInsercao < array.length && nomeFormatado.compareToIgnoreCase(array[posicaoInsercao]) > 0) {
            posicaoInsercao++;
        }

        array = adicionarElemento(array, nomeFormatado, posicaoInsercao);
        vetorDeArrays[indice] = array;
    }

    public static boolean nomeExiste(String nome) {
        int indice = indice(nome);
        String nomeFormatado = formatarNome(nome);
        String[] array = vetorDeArrays[indice];
        return contemElemento(array, nomeFormatado);
    }

    public static void excluirNome(String nome) {
        int indice = indice(nome);
        String nomeFormatado = formatarNome(nome);
        String[] array = vetorDeArrays[indice];
        int posicaoRemocao = encontrarPosicao(array, nomeFormatado);

        if (posicaoRemocao != -1) {
            array = removerElemento(array, posicaoRemocao);
            vetorDeArrays[indice] = array;
        }
    }

    public static void renomearNome(String nomeAntigo, String nomeNovo) {
        if (nomeExiste(nomeAntigo)) {
            excluirNome(nomeAntigo);
            adicionarNome(nomeNovo);
        } else {
            throw new IllegalArgumentException("O nome antigo não existe na estrutura de dados.");
        }
    }

    public static boolean estaVazia() {
        for (String[] array : vetorDeArrays) {
            if (array.length > 0) {
                return false;
            }
        }
        return true;
    }

    public static int quantidadeDeNomes() {
        int quantidade = 0;
        for (String[] array : vetorDeArrays) {
            quantidade += array.length;
        }
        return quantidade;
    }

    // Métodos auxiliares...

    private static String[] adicionarElemento(String[] array, String elemento, int posicao) {
        String[] novoArray = new String[array.length + 1];

        for (int i = 0; i < posicao; i++) {
            novoArray[i] = array[i];
        }

        novoArray[posicao] = elemento;

        for (int i = posicao + 1; i < novoArray.length; i++) {
            novoArray[i] = array[i - 1];
        }

        return novoArray;
    }

    private static boolean contemElemento(String[] array, String elemento) {
        for (String e : array) {
            if (e.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    private static String[] removerElemento(String[] array, int posicao) {
        String[] novoArray = new String[array.length - 1];

        for (int i = 0; i < posicao; i++) {
            novoArray[i] = array[i];
        }

        for (int i = posicao + 1; i < array.length; i++) {
            novoArray[i - 1] = array[i];
        }

        return novoArray;
    }

    private static int encontrarPosicao(String[] array, String elemento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    private static char obterPrimeiraLetra(String nome) {
        String nomeMinusculo = nome.toLowerCase();
        return nomeMinusculo.charAt(0);
    }

    private static String formatarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo.");
        }

        return nome.substring(0, 1).toUpperCase() + nome.substring(1);
    }

    public static String[][] getVetorDeArrays() {
        return vetorDeArrays;
    }
}
