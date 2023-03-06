package arrays;

import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {

        int[] meuArray1 = {32, 44, 12, 88, 18, 67};

        for (int n = 100; n <5000 ; n+=50) {
            int[] array1 = new int[n];
            ArrayUtils.preencherArrayComValoresInteirosAleatorios(array1, 1000, true);
            int operacoes = ordenarBubbleSort(array1);
            System.out.println(n+";"+operacoes);
        }

    }
    public static int ordenarBubbleSort(int[] arrayParaOrdenar) {
        int operacoes = 0;
        int tamanho = arrayParaOrdenar.length;
        for (int i = 0; i < tamanho; i++) {
            //ArrayUtils.imprimir(arrayParaOrdenar);
            for (int j = 1; j < tamanho - i; j++) {
                if(arrayParaOrdenar[j-1]>arrayParaOrdenar[j]) {
                    int temp = arrayParaOrdenar[j-1];
                    arrayParaOrdenar[j-1] = arrayParaOrdenar[j];
                    arrayParaOrdenar[j] = temp;
                    //System.out.printf("Trocou %d pelo %d %n", temp, arrayParaOrdenar[j-1]);
                }
                operacoes++;
            }
        }
        return operacoes;
    }





}
