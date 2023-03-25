package aula08_tabelas_hash_exercicios.encadeamento_separado;

import arrays.ArrayUtils;

import javax.swing.text.StyledEditorKit;

public class TabelaHashEncadeamentoSeparado {

    private final static int CAPACIDADE_INICIAL = 5;

    public ListaDuplamenteEncadeada[] getTabela() {
        return tabela;
    }
    private ListaDuplamenteEncadeada[] tabela; //cria uma array de lista encadeada

    public TabelaHashEncadeamentoSeparado() {
        tabela = new ListaDuplamenteEncadeada[CAPACIDADE_INICIAL];
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = new ListaDuplamenteEncadeada();
        }
    }
    public void inserir(int chave) {
        int hash = chave % tabela.length;

        ListaDuplamenteEncadeada lista = tabela[hash];
        lista.adicionar(chave);
    }
    public static void main(String[] args) {
        TabelaHashEncadeamentoSeparado tb = new TabelaHashEncadeamentoSeparado();
        tb.inserir(100);
        tb.inserir(300);
        tb.inserir(401);
        tb.inserir(405);
        tb.inserir(650);
        tb.inserir(366);
        tb.inserir(401);
        tb.inserir(443);
        tb.inserir(904);
        tb.inserir(474);
        tb.inserir(558);
        tb.inserir(125);
        tb.inserir(127);


        ListaDuplamenteEncadeada[] t = tb.getTabela();
        for (int i = 0; i < t.length; i++) {
            t[i].imprimir();
        }
    }
}
