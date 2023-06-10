package aula05_filasdeprioridade_heap;

import arrays.ArrayUtils;

import java.util.Scanner;

public class Aula05_Heap {
    public static void main(String[] args) {

        // TestarHeap();
        exemplo1();
        // exemplo2();
        // exemplo3();
        // exemplo4();

    }

    public static void TestarHeap() {
        Scanner teclado = new Scanner(System.in);
        HeapMaximo h1 = new HeapMaximo(10);

        int chave;
        System.out.println("Digite os valores a serem inseridos (0 para encerrar)");
        do {
            chave = teclado.nextInt();
            if (chave > 0)
                h1.inserir(chave);
            ArrayUtils.imprimir(h1.getChaves());
        } while (chave > 0);

    }

    public static void exemplo1() {
        HeapMaximo h1 = new HeapMaximo(10);

        ArrayUtils.imprimir(h1.getChaves());

        h1.inserir(10);
        h1.inserir(20);
        h1.inserir(15);
        h1.inserir(5);
        h1.inserir(30);
        h1.inserir(120);

        System.out.println();
        ArrayUtils.imprimir(h1.getChaves());

        h1.removerMaximo();
        ArrayUtils.imprimir(h1.getChaves());
        h1.removerMaximo();
        ArrayUtils.imprimir(h1.getChaves());

    }

    public static void exemplo2() {
        // gerando um heap-max a partir de um array, ou seja, convertendo o array em um
        // heap

        int[] meuArray = { 0, 20, 35, 12, 77, 90, 15, 100 };
        ArrayUtils.imprimir(meuArray);
        HeapMaximo meuHeap = new HeapMaximo(meuArray);
        ArrayUtils.imprimir(meuHeap.getChaves());
        ArrayUtils.imprimir(meuHeap.getChaves());

    }

    public static void exemplo3() {
        // gerando um heap-max a partir de um array, ou seja, convertendo o array em um
        // heap

        int[] meuArray = { 0, 40, 87, 2, 90, 1, 100, 30, 20 };
        ArrayUtils.imprimir(meuArray);
        HeapMaximo meuHeap = new HeapMaximo(meuArray);
        ArrayUtils.imprimir(meuHeap.getChaves());

    }

    public static void exemplo4() {
        // gerando um heap-max a partir de um array, ou seja, convertendo o array em um
        // heap

        int[] meuArray = { 0, 15, 23, 30, 11, 50, 33 };
        ArrayUtils.imprimir(meuArray);
        HeapMaximo meuHeap = new HeapMaximo(meuArray);
        ArrayUtils.imprimir(meuHeap.getChaves());

    }
}
