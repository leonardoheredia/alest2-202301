package aula07_tabelas_hash.enderecamento_aberto;

import arrays.ArrayUtils;

import java.util.Scanner;

public class TabelaHashEnderecamentoAberto {
    private int capacidade; //capacidade nos nossos slides seria o m
    private int quantidade; //quantidade de chaves validas na nossa tabela
    private int[] tabela;
    public int[] getTabela() {
        return tabela;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public TabelaHashEnderecamentoAberto(int capacidade) {
        this.capacidade = capacidade;
        tabela = new int[capacidade];
        for (int i = 0; i < capacidade; i++) {
            tabela[i] = -1; //-1 seria um valor invalido na tabela hash indicando que a posicao esta vazia
        }
    }
    public void inserir(int chave) {
        int hash  = funcaoHashing(chave);
        System.out.printf("%nhash(%d) = %d", chave, hash);
        if(tabela[hash]==-1) { //posicao livre na tabela
            tabela[hash] = chave;
            quantidade++;
            System.out.printf("%nInseriu a chave %d na posição %d", chave, hash);
        }
        else if(tabela[hash]==chave) { //se isso ocorrer significa que a chave ja existe
            System.out.printf("%nChave já existe na posição %d. Não vou fazer nada.", chave);
        }
        else {
            System.out.printf("%nColisão na posição %d.", hash);
            //tratar a colisão achando alguma posição livre
            int posicao_original = hash;
            int proxima_posicao = hash+1;
            while(true) {
                if(proxima_posicao==this.capacidade) { //chegou no final
                    System.out.printf("%nOps! Cheguei no final %d e não achei nada livre. Vou recomecar desde o início para ver se tenho mais sorte", proxima_posicao);
                    proxima_posicao = 0; //recomeca do zero
                }
                else if(tabela[proxima_posicao] == -1) {
                    System.out.printf("%nOba! A posição %d estava livre. Vou inserir %d na posição %d.", proxima_posicao, chave, proxima_posicao);
                    tabela[proxima_posicao] = chave;
                    quantidade++;
                    return;
                }
                else if(tabela[proxima_posicao]==chave) { //se isso ocorrer significa que a chave ja existe
                    System.out.printf("%nChave já existe na posição %d. Não vou fazer nada.", chave);
                    return;
                }
                else proxima_posicao++;
                if(proxima_posicao == posicao_original) {
                    System.out.printf("%n Oh não!! Já tentei tudo e não achei lugar! Isso significa que a tabela hash esta lotada! O que farei??? ");
                    System.out.printf("%n Tenho que fazer um resize duplicando o m e colocando novamente todas as chaves");
                    duplicarTabela();
                    return;
                }

            }

        }
    }
    public void duplicarTabela() {
        int[] tabelaTemporaria = new int[capacidade];
        for (int i = 0; i < capacidade; i++) {
            tabelaTemporaria[i] = tabela[i];
        }
        //duplica a capacidade da tabela hash
        this.capacidade = this.capacidade * 2;
        tabela = new int[capacidade];
        this.quantidade = 0;
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = -1;
        }
        for (int i = 0; i < tabelaTemporaria.length; i++) {
            inserir(tabelaTemporaria[i]);
        }

    }
    public int funcaoHashing(int chave) {
        return chave % this.capacidade;
    }
    public int buscar(int chave) {
        int hash = funcaoHashing(chave);
        int sondagens = 0;
        if(tabela[hash]==-1) {
            return -1;
        }
        else if(chave==tabela[hash]) {
            return hash; //achou a chave
        }
        else {
            int posicao_original = hash;
            int proxima_posicao = hash+1;
            while(true) {  // percorre a tabela até achar a chave ou achar uma posição vazia
                if (proxima_posicao == this.capacidade) proxima_posicao = 0;
                if(chave==tabela[proxima_posicao]) { //achou
                    return hash;
                }
                proxima_posicao++;
                if(tabela[proxima_posicao]==-1 || proxima_posicao==posicao_original) return -1; //se encontrar uma posição vazia ou tiver percorrido tudo e não achado a chave entao retorna -1
            }

        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%nExemplo de tabela hashing");
        System.out.printf("%n-------------------------");
        System.out.printf("%n");

        TabelaHashEnderecamentoAberto tabelaHash = new TabelaHashEnderecamentoAberto(3);

        int chave=-1;
        while(true) {
            System.out.printf("%nDigite um valor entre 100 e 999 para inserir na tabela ou 0 para terminar: ");
            chave = sc.nextInt();
            if(chave>=100 && chave<=999) {
                tabelaHash.inserir(chave);
            }
            else if (chave==0) break;
            else {
                System.out.printf("%nValor inválido. Digitar valor entre (100-999).");
            }
            ArrayUtils.imprimir(tabelaHash.tabela);
            System.out.printf("%n Quantidade de valores validos na tabela = %d", tabelaHash.quantidade);
        }



    }
}
