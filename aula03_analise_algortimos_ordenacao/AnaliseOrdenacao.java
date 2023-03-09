package aula03_analise_algortimos_ordenacao;

import arrays.ArrayUtils;

public class AnaliseOrdenacao {

    public static void main(String[] args) {
        System.out.println("N;bubble;insertion;merge");
        for (int n = 100; n <= 50_000; n+=2000) {
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

            //System.out.println(n + ";" + bubble.getOperacoes() + ";" + insertion.getOperacoes() + ";" + merge.getOperacoes());
            System.out.println(n + ";" + bubble.getTempoExecucao());

        }

    }




}