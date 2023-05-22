package aula22_grafo_dirigido;

import java.util.ArrayList;

public class BuscaEmProdundidade {
    private boolean[] visitados;
    private int[] antecessor;
    public int[] preordem;
    public int[] posordem;
    private int indicePreOrdem;
    private int indicePosOrdem;
    public BuscaEmProdundidade(GrafoDirigido g, int verticeOrigem) {
        this.visitados = new boolean[g.getNumeroVertices()];
        this.antecessor = new int[g.getNumeroVertices()];
        this.preordem = new int[g.getNumeroVertices()];
        this.posordem = new int[g.getNumeroVertices()];
        for (int i = 0; i < antecessor.length; i++) {
            antecessor[i] = -1;
            preordem[i] = -1;
            posordem[i] = -1;
        }
        preordem[0] = verticeOrigem;
        executarBuscaRecursiva(g, verticeOrigem);
    }
    private void executarBuscaRecursiva(GrafoDirigido g, int vertice) {
        visitados[vertice] = true;
        ArrayList<Integer> adjacentes = g.verticesAdjacentes(vertice);
        for(int vizinho:adjacentes) {
            if(!visitados[vizinho]) {
                antecessor[vizinho] = vertice;
                indicePreOrdem++;
                preordem[indicePreOrdem] = vizinho;
                executarBuscaRecursiva(g, vizinho);
                posordem[indicePosOrdem] = vizinho;
                indicePosOrdem++;
            }
        }
    }
    public boolean[] getVisitados() {
        boolean[] retorno = new boolean[visitados.length];
        for (int i = 0; i < visitados.length; i++) {
            retorno[i] = visitados[i];
        }
        return retorno;
    }

    public int[] getAntecessores() {
        int[] retorno = new int[visitados.length];
        for (int i = 0; i < visitados.length; i++) {
            retorno[i] = antecessor[i];
        }
        return retorno;
    }

}
