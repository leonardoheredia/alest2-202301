package aula08_tabelas_hash_exercicios.encadeamento_separado;

public class ListaDuplamenteEncadeada {
    private int tamanho;
    private Nodo inicio;
    private Nodo fim;
    private class Nodo {
        private int chave;
        private int valor;
        private Nodo proximo;
        private Nodo anterior;

        public Nodo(int chave) {
            this.chave = chave;
            this.proximo = null;
            this.anterior = null;
        }

    }

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;

    }
    public void adicionar(int chave) {
        Nodo novoNodo = new Nodo(chave);
        if(tamanho==0) {
            this.inicio = novoNodo;
            this.fim = novoNodo;
        }
        else {
            novoNodo.anterior = fim;
            fim.proximo =novoNodo;
            fim = novoNodo;

        }
        tamanho++;
    }
    public int buscar(int chave) {
        Nodo aux = this.inicio;
        while (aux != null) {
            if (aux.chave == chave) {
                return chave;
            }
            aux = aux.proximo;
        }
        return -1;
    }

    public void imprimir() {
        System.out.printf("%n[");
        Nodo aux = this.inicio;
        while (aux != null) {
            System.out.printf(" %d ", aux.chave);
            aux = aux.proximo;
        }
        System.out.printf("]");
    }
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.adicionar(100);
        lista.adicionar(400);
        lista.adicionar(500);
    }


}
