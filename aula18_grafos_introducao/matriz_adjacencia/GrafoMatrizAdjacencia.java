package aula18_grafos_introducao.matriz_adjacencia;

import java.util.*;

public class GrafoMatrizAdjacencia {
    public boolean[][] matrizAdjacencia;
    private int numeroVertices;
    private int numeroArestas;
    public GrafoMatrizAdjacencia(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
        matrizAdjacencia = new boolean[numeroVertices][numeroVertices];
    }
    public void adicionarAresta(int v, int w) {
        matrizAdjacencia[v][w] = true;
        matrizAdjacencia[w][v] = true;
        numeroArestas++;
    }
    public void removerAresta(int v, int w) {
        matrizAdjacencia[v][w] = false;
        matrizAdjacencia[v][w] = false;
        numeroArestas--;
    }

    public void imprimirMatriz() {
        String str="  |";
        for (int i = 0; i < numeroVertices; i++) {
            str += "  " + i + "  |";
        }
        System.out.println(str);
        for (int i = 0; i < numeroVertices; i++) {
            String linha = i + " |";
            for (int j = 0; j < numeroVertices; j++) {
                linha += matrizAdjacencia[i][j] + "|";
            }
            System.out.println(linha);
        }
    }
    public boolean existeAresta(int v, int w) {
        return matrizAdjacencia[v][w];
    }

    public boolean[] buscaEmProfundidade(int verticeInicial) {
        boolean[] verticesVisitados = new boolean[numeroVertices];
        verticesVisitados[verticeInicial] = true;
        buscaEmProfundidadeRecursiva(verticeInicial, verticesVisitados);
        return verticesVisitados;
    }
    public void buscaEmProfundidadeRecursiva(int vertice, boolean[] verticesVisitados) {
        for (int destino = 0; destino < numeroVertices; destino++) {
            if(existeAresta(vertice,destino) && !verticesVisitados[destino]) {
                verticesVisitados[destino] = true;
                buscaEmProfundidadeRecursiva(destino, verticesVisitados);
            }
        }
    }
    public boolean[] buscarEmLargura(int verticeInicial) {
        boolean[] verticesVisitados = new boolean[numeroVertices];
        Queue<Integer> filaAuxiliar = new LinkedList<>();
        filaAuxiliar.add(verticeInicial);
        verticesVisitados[verticeInicial] = true;
        while(!filaAuxiliar.isEmpty()) {
            int origem = filaAuxiliar.poll();
            for (int destino = 0; destino < this.numeroVertices; destino++) {
                if(existeAresta(origem, destino) && !verticesVisitados[destino]) {
                    filaAuxiliar.add(destino);
                    verticesVisitados[destino] = true;
                }
            }
        }
        return verticesVisitados;
    }
    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < numeroVertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = i; j < numeroVertices; j++) {
                if(matrizAdjacencia[i][j]) {
                    resultado += "\t" + i + "--" + j + ";" + System.lineSeparator();
                }
            }
        }
        resultado += "}";
        return resultado;
    }
    @Override
    public String toString() {
        String resultado = "";
        return resultado;
    }

    public static void main(String[] args) {
        GrafoMatrizAdjacencia G = new GrafoMatrizAdjacencia(6);
        G.adicionarAresta(1, 2);
        G.adicionarAresta(2, 3);
        G.adicionarAresta(2, 0);
        G.adicionarAresta(4, 5);

        System.out.println(G.toDot());
        System.out.println(G);


        boolean[] t = new boolean[G.numeroVertices];
        //t = G.buscaEmProfundidade(0);
        t = G.buscarEmLargura(5);
        for (int i = 0; i < t.length; i++) {
            System.out.println(i + " - " + t[i]);
        }

        Aux x = new Aux(10);

    }


}
