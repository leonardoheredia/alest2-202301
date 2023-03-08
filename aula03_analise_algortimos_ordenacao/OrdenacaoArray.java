package aula03_analise_algortimos_ordenacao;

import arrays.ArrayUtils;

public class OrdenacaoArray {

    public static void main(String[] args) {
        for (int n = 5; n <= 100; n++) {
            int[] meuArrayOriginal = new int[n];
            int[] meuArrayBubble = new int[n];
            int[] meuArrayInsertion = new int[n];
            int[] meuArrayMerge = new int[n];

            ArrayUtils.preencherArrayComValoresInteirosAleatorios(meuArrayOriginal, 100, true);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayBubble);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayInsertion);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayMerge);

            BubbleSort bubble = new BubbleSort();
            InsertionSort insertion = new InsertionSort();
            MergeSort merge = new MergeSort();

            bubble.ordenar(meuArrayBubble);
            insertion.ordenar(meuArrayInsertion);
            merge.ordenar(meuArrayMerge);


            System.out.println(n + ";" + bubble.getOperacoes() + ";" + insertion.getOperacoes() + ";" + merge.getOperacoes());

        }

    }




}
