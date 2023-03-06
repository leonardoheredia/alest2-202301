package arrays;

import java.util.Random;

public class ArrayUtils {

    public static void imprimir(int[] variavelArray) {
        System.out.printf("[");
        for (int i = 0; i < variavelArray.length ; i++) {
            System.out.printf(" %d ", variavelArray[i]);
        }
        System.out.printf("]%n");
    }

    public static boolean valorExisteNoArray(int[] variavelArray, int valor) {
        boolean achou = false;
        int i = 0;
        while (!achou && i<variavelArray.length) {
            if(variavelArray[i] == valor) achou=true;
            i++;
        }
        return achou;
    }
    public static void preencherArrayComValoresInteirosAleatorios(int[] variavelArray, int limiteSuperior, boolean permitirRepetidos) {
        Random geradorRandomico = new Random();
        for (int i = 0; i < variavelArray.length; i++) {
            int valorGerado = geradorRandomico.nextInt(limiteSuperior);
            if(permitirRepetidos) variavelArray[i] = valorGerado;
            else {
                while (valorExisteNoArray(variavelArray, valorGerado)) {
                    valorGerado = geradorRandomico.nextInt(limiteSuperior);
                }
                variavelArray[i] = valorGerado;
            }
        }
    }

    public static int retornarSomaArrayInteiros(int[] arrayInteiros) {
        int soma=0;
        for (int i = 0; i < arrayInteiros.length; i++) {
            soma = soma + arrayInteiros[i];
        }
        return soma;
    }

    public static int dobrarValor(int valorInteiro) {
        int dobro = valorInteiro * 2;
        return valorInteiro;
    }

}
