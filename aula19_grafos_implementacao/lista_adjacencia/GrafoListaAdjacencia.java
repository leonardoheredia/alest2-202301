package aula19_grafos_implementacao.lista_adjacencia;

import java.util.ArrayList;

public class GrafoListaAdjacencia {
    private ArrayList<Integer>[] listaAdjacencia;
    private int numeroVertices;
    private int numeroArestas;

    public GrafoListaAdjacencia(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
        listaAdjacencia = new ArrayList[numeroVertices];
        for (int i = 0; i < numeroVertices; i++) {
            listaAdjacencia[i] = new ArrayList<>();
        }
    }

    public void adicionarAresta(int v, int w) {
        listaAdjacencia[v].add(w);
        listaAdjacencia[w].add(v);
        numeroArestas++;
    }
    public boolean existeAresta(int v, int w) {
        boolean vw = listaAdjacencia[v].indexOf(w)>=0;
        boolean wv = listaAdjacencia[w].indexOf(v)>=0;
        return vw || wv;
    }
    public void removerAresta(int v, int w) {
        int vw = listaAdjacencia[v].indexOf(w);
        listaAdjacencia[v].remove(vw);
        int wv = listaAdjacencia[w].indexOf(v);
        listaAdjacencia[w].remove(wv);
    }
    public ArrayList<Integer> adjacentes(int v) {
        return listaAdjacencia[v];
    }

    public void buscarEmProfundidade(int verticeInicial) {
        boolean[] verticesVisitados = new boolean[this.numeroVertices];
        int[] verticesAnteriores = new int[this.numeroVertices];
        for (int i = 0; i < this.numeroVertices; i++) {
            verticesAnteriores[i] = -1;
        }
        buscarEmProfundidadeRecursiva(verticesVisitados, verticesAnteriores, verticeInicial);
        System.out.println("");

        for (int i = 0; i < verticesAnteriores.length; i++) {
            System.out.println(i + " : " + verticesAnteriores[i]);
        }
    }

    private void buscarEmProfundidadeRecursiva(boolean[] verticesVisitados, int[] verticesAnteriores, int vertice) {
        System.out.print(" " + vertice + " ");
        verticesVisitados[vertice] = true;
        for (int i = 0; i < adjacentes(vertice).size(); i++) {
            int verticeAdjacente = adjacentes(vertice).get(i);
            if(!verticesVisitados[verticeAdjacente])  {
                verticesAnteriores[verticeAdjacente] = vertice;
                buscarEmProfundidadeRecursiva(verticesVisitados, verticesAnteriores,verticeAdjacente);
            }
        }
    }
    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < numeroVertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                resultado += "\t" + i + "--" + listaAdjacencia[i].get(j) + ";" + System.lineSeparator();
            }
        }
        resultado += "}";
        return resultado;
    }
    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < numeroVertices; i++) {
            ret += i + " {";
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                ret += " " + listaAdjacencia[i].get(j);
            }
            ret = ret + " } " + System.lineSeparator();
        }
        return ret;
    }

    public static void main(String[] args) {
        GrafoListaAdjacencia g = new GrafoListaAdjacencia(5);
        g.adicionarAresta(0, 1);
        g.adicionarAresta(1, 2);
        g.adicionarAresta(1, 3);
        g.adicionarAresta(0, 4);
        g.adicionarAresta(1, 4);
        System.out.println(g);

        System.out.println(g.existeAresta(0,3));

        g.removerAresta(0, 1);
        System.out.println(g);

        System.out.println(g.toDot());
        g.buscarEmProfundidade(0);
        
    }
}

