package aula18_grafos_introducao.matriz_adjacencia;

public class GrafoComRotulo {
    public class Vertice {
        public String rotulo;
    }
    public boolean[][] matrizAdjacencia;
    private Vertice[] listaVertices;
    private int obterIndiceVertice(String rotulo) {
        for (int i = 0; i < totalVertices; i++) {
            if(listaVertices[i].rotulo.equals(rotulo)) return i;
        }
        return -1;
    }
    private int totalVertices;
    private int totalArestas;
    public GrafoComRotulo() {
        this.matrizAdjacencia = new boolean[10][10];
        listaVertices = new Vertice[10];
        totalVertices = 0;
        totalArestas = 0;
    }

    public void adicionarVertice(String rotulo) {
        Vertice v = new Vertice();
        v.rotulo = rotulo;
        listaVertices[totalVertices] = v;
        totalVertices++;
    }
    public void adicionarAresta(String v, String w) {
        int iV = obterIndiceVertice(v);
        int iW = obterIndiceVertice(w);
        matrizAdjacencia[iV][iW] = true;
        matrizAdjacencia[iW][iV] = true;
        totalArestas++;
    }
    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < totalVertices; i++) {
            resultado = resultado + "\t" + listaVertices[i].rotulo + ";" + System.lineSeparator();
        }
        for (int i = 0; i < totalVertices; i++) {
            for (int j = i; j < totalVertices; j++) {
                if(matrizAdjacencia[i][j]) {
                    resultado += "\t" + listaVertices[i].rotulo + "--" + listaVertices[j].rotulo + ";" + System.lineSeparator();
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
        GrafoComRotulo G = new GrafoComRotulo();
        G.adicionarVertice("A");
        G.adicionarVertice("B");
        G.adicionarVertice("C");
        G.adicionarAresta("A", "B");
        G.adicionarAresta("A", "C");
        G.adicionarAresta("B", "C");
        G.adicionarVertice("D");
        G.adicionarVertice("E");
        G.adicionarAresta("C", "D");
        G.adicionarAresta("D", "E");
        System.out.println(G.toDot());
        System.out.println(G);
    }
}
