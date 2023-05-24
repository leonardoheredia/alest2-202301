package aula21_grafos_caminhamento_largura;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
    //implementacao com Lista de Adjacencia
    private ArrayList<Integer> listaAdjacencia[];
    int numeroVertices;
    int numeroArestas;
    public Grafo(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
        listaAdjacencia = new ArrayList[this.numeroVertices];
        for (int i = 0; i < this.numeroVertices; i++) {
            listaAdjacencia[i] = new ArrayList<>();
        }
    }
    public void adicionarAresta(int v, int w) {
        this.listaAdjacencia[v].add(w);
        this.listaAdjacencia[w].add(v);
        this.numeroArestas++;
    }
    public ArrayList<Integer> verticesAdjacentes(int vertice) {
        return this.listaAdjacencia[vertice];
    }
    public void buscarEmProfundidade(int origem) {
        boolean[] visitados = new boolean[this.numeroVertices];
        buscarEmProfundidadeRecursivamente(origem, visitados);
    }
    public void buscarEmProfundidadeRecursivamente(int vertice, boolean[] visitados) {
        visitados[vertice] = true;
        System.out.println(vertice + " visitado");
        ArrayList<Integer> adjacentes = this.verticesAdjacentes(vertice);
        for(int vizinho:adjacentes) {
            if(!visitados[vizinho]) {
                //System.out.println("Vou visitar o " + vizinho);
                buscarEmProfundidadeRecursivamente(vizinho, visitados);
            }
            else {
                //System.out.println("Nao vou visitar o " + vizinho + " pq ele ja foi visitado");
            }
        }
    }
    public String toDot() {
        String resultado = "digraph G { " + System.lineSeparator();
        for (int i = 0; i < numeroVertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                resultado += "\t" + i + "->" + listaAdjacencia[i].get(j) + ";" + System.lineSeparator();
            }
        }
        resultado += "}";
        return resultado;
    }

    public void buscarEmLargura(int vertice) {
        boolean[] visitados = new boolean[numeroVertices];
        int[] pai = new int[numeroVertices];
        int[] distancia = new int[numeroVertices];
        for (int i = 0; i < numeroVertices; i++) {
            pai[i] = -1;
        }
        executarBuscaEmLargura(vertice, visitados, pai, distancia);
    }
    private void executarBuscaEmLargura(int vertice,
                                        boolean[] visitados,
                                        int[] pai,
                                        int[] distancia) {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(vertice);
        visitados[vertice] = true;
        while (!fila.isEmpty()) {
            Integer atual = fila.poll();
            for (Integer adjacente:this.listaAdjacencia[atual]) {
                if(!visitados[adjacente]) {
                    visitados[adjacente] = true;
                    pai[adjacente] = atual;
                    fila.add(adjacente);
                }
            }
        }
        System.out.println("Vertice,Visitado,Pai,Distancia");
        for (int i = 0; i < numeroVertices; i++) {
            System.out.println(i + "," + visitados[i] + "," + pai[i] + "," + distancia[i]);
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(7);
        g.adicionarAresta(0,1);
        g.adicionarAresta(0,3);
        g.adicionarAresta(0,5);
        g.adicionarAresta(1,2);
        g.adicionarAresta(2,4);
        g.adicionarAresta(2,5);
        g.adicionarAresta(3,6);
        g.adicionarAresta(4,5);
        g.adicionarAresta(4,6);
        //System.out.println(g.toDot());
        g.buscarEmLargura(0);

    }

}













