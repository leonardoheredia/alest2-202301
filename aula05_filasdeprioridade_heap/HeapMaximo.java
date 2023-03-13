package aula05_filasdeprioridade_heap;

import arrays.ArrayUtils;

/*
* Estrutura de dados HeapMaximo
* Implementação para fins didáticos
* Limitada a números inteiros maiores que 0.
* O valor -1 na chave indica que a posição do heap está vazia
* */
public class HeapMaximo {
    private int[] chaves;
    private int capacidade; //capacidade do heap, não a sua quantidade de elementos/chaves
    private int tamanho; //quantidade de elementos/chaves do heap

    public HeapMaximo(int capacidade) {
        this.chaves = new int[capacidade];
        this.tamanho = 0;
    }

    public HeapMaximo(int[] chaves) {
        this.chaves = chaves;
        this.capacidade = this.chaves.length;
        this.tamanho = this.chaves.length-1;
        gerarHeap();
    }

    private void gerarHeap() {
        //um array qualquer recebido no construtor pode nao ser um heap-maximo
        //nesse caso temos que transformar ele em um heap
        //para isso vamos percorrer a arvore a partir do ultimo nodo e "nadarPraCima"
        int posicaoPaiUltimoNodo = this.tamanho / 2;
        for (int i = posicaoPaiUltimoNodo; i > 0; i--) {
            afundarPraBaixo(i);
        }
    }

    public int[] getChaves() {
        return chaves;
    }
    public void inserir(int chave) {
        //Inserir sempre no final
        System.out.println("Inserindo " + chave);
        int ultimaPosicaoPreenchida = this.tamanho;
        this.chaves[ultimaPosicaoPreenchida + 1] = chave;
        this.tamanho++;
        nadarPraCima(this.tamanho);

    }
    public void removerMaximo() { //remove o maior elemento, a raiz
        /*
        * Trocar a chave do pai com o último elemento do heap, ou seja o último elemento vira a raiz e a raiz anterior eh removida do heap
        * Isso pode deixar o heap inconsistente, com uma raiz menor que os filhos
        * Entao o algoritmo deve executar a operacao "afundar" até que o heap fique consistente
        * */

        //troca
        int chaveMaxima = this.chaves[1];
        int chaveUltimaPosicao = this.chaves[this.tamanho];
        this.chaves[1] = chaveUltimaPosicao;
        this.chaves[this.tamanho] = chaveMaxima;

        //remove a antiga raiz
        this.chaves[this.tamanho] = 0;
        this.tamanho = this.tamanho - 1;

        System.out.println("Removido " + chaveMaxima);
        //inicia o ajuste afundando a nova raiz ate que o heap seja restaurado
        afundarPraBaixo(1);

    }


    private void afundarPraBaixo(int posicao) {
        int posicaoPai = posicao;
        int posicaoUltimoFilho = 2 * posicaoPai;
        while (posicaoUltimoFilho <= this.tamanho) { //enquanto tiver filho
            System.out.printf("%n");
            //troca a chave do pai com a do filho maior
            int chavePai = this.chaves[posicaoPai];
            int chaveFilhoEsquerda = this.chaves[posicaoUltimoFilho];
            int posicaoFilhoNaDireita = posicaoUltimoFilho + 1;
            int chaveFilhoDireita = 0;
            if (posicaoFilhoNaDireita <= this.tamanho) { //existe filho na direita
                chaveFilhoDireita = this.chaves[posicaoFilhoNaDireita];
            }
            System.out.printf("%nAnalisa nodo pai %d", chavePai);
            //troca a o pai com o maior dos filhos e segue o algoritmo
            if (chaveFilhoEsquerda > chavePai && chaveFilhoEsquerda > chaveFilhoDireita) {
                System.out.printf("Trocou %d por %d", chavePai, chaveFilhoEsquerda);
                chaves[posicaoUltimoFilho] = chavePai;
                chaves[posicaoPai] = chaveFilhoEsquerda;
                posicaoUltimoFilho = posicaoPai * 2;
            } else if (chaveFilhoDireita > chavePai && chaveFilhoDireita >= chaveFilhoEsquerda) {
                chaves[posicaoFilhoNaDireita] = chavePai;
                chaves[posicaoPai] = chaveFilhoDireita;
                posicaoUltimoFilho = posicaoPai * 2 + 1;
                System.out.printf("Trocou %d por %d", chavePai, chaveFilhoDireita);
            }
            else {
                break;
            }
        }
    }
    private void nadarPraCima(int posicao) {
        while(posicao > 1) {
            int chave = this.chaves[posicao];
            int chavePai = this.chaves[posicao / 2];
            if(chave > chavePai) { //filho maior que pai, entao troca as posicoes
                System.out.printf("   Trocando %d por %d.", chave, chavePai);
                this.chaves[posicao / 2] = chave;
                this.chaves[posicao] = chavePai;
            }
            posicao = posicao / 2; //sobe na arvore
        }
    }
}
