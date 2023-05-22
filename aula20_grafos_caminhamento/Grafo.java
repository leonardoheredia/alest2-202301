package aula20_grafos_caminhamento;


import java.util.ArrayList;

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
        System.out.println("Marquei o " + vertice + " como visitado");
        ArrayList<Integer> adjacentes = this.verticesAdjacentes(vertice);
        for(int vizinho:adjacentes) {
            if(!visitados[vizinho]) {
                System.out.println("Vou visitar o " + vizinho);
                buscarEmProfundidadeRecursivamente(vizinho, visitados);
            }
            else {
                System.out.println("Nao vou visitar o " + vizinho + " pq ele ja foi visitado");
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

    public static void main(String[] args) {
        Grafo g = new Grafo(4);
        g.adicionarAresta(0,1);
        g.adicionarAresta(0,2);
        g.adicionarAresta(0,3);
        g.adicionarAresta(1,2);
        g.adicionarAresta(2,3);

        g.buscarEmProfundidade(0);

    }

}
