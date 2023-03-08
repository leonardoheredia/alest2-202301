package aula03_analise_algortimos_ordenacao;

import arrays.ArrayUtils;

public class AnaliseOrdenacao {

    public static void main(String[] args) {
        for (int n = 5; n <= 100000; n+=50) {
            int[] meuArrayOriginal = new int[n];
            int[] meuArrayBubble = new int[n];
            int[] meuArrayInsertion = new int[n];
            int[] meuArrayMerge = new int[n];
            int[] meuArrayQuickSort = new int[n];

            ArrayUtils.preencherArrayComValoresInteirosAleatorios(meuArrayOriginal, 100, true);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayBubble);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayInsertion);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayMerge);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayQuickSort);

            BubbleSort bubble = new BubbleSort();
            InsertionSort insertion = new InsertionSort();
            MergeSort merge = new MergeSort();
            QuickSort quick = new QuickSort();

            bubble.ordenar(meuArrayBubble);
            insertion.ordenar(meuArrayInsertion);
            merge.ordenar(meuArrayMerge);
            quick.ordenar(meuArrayQuickSort);

            System.out.println(n + ";" + bubble.getOperacoes() + ";" + insertion.getOperacoes() + ";" + merge.getOperacoes() + ";" + quick.getOperacoes());

        }

    }




}
