package aula03_analise_algortimos_ordenacao;

public class BubbleSort {


    private int operacoes;

    public int getOperacoes() {
        return operacoes;
    }

    public void ordenar(int[] arrayInteiros) {
        operacoes = 0;
        int tamanho = arrayInteiros.length;
        for (int i = 0; i < tamanho; i++) {
            //ArrayUtils.imprimir(arrayParaOrdenar);
            for (int j = 1; j < tamanho - i; j++) {
                if(arrayInteiros[j-1]>arrayInteiros[j]) {
                    int temp = arrayInteiros[j-1];
                    arrayInteiros[j-1] = arrayInteiros[j];
                    arrayInteiros[j] = temp;
                    operacoes++;
                    //System.out.printf("Trocou %d pelo %d %n", temp, arrayParaOrdenar[j-1]);
                }
                operacoes++;
            }
        }
    }

}
