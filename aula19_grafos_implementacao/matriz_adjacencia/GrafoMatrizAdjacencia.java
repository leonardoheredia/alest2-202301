package aula19_grafos_implementacao.matriz_adjacencia;

public class GrafoMatrizAdjacencia {
    private boolean[][] matrizAdjacencia;
    private int numeroVertices;
    private int numeroArestas;
    public GrafoMatrizAdjacencia(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
        this.matrizAdjacencia = new boolean[numeroVertices][numeroVertices];
    }

    public void adicionarAresta(int v, int w) {
        matrizAdjacencia[v][w] = true;
        matrizAdjacencia[w][v] = true;
        numeroArestas++;
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
    public void imprimirMatriz() {
        String str="  |";
        for (int i = 0; i < numeroVertices; i++) {
            str += "  " + i + "  |";
        }
        System.out.println(str);
        for (int i = 0; i < numeroVertices; i++) {
            String linha = i + " |";
            for (int j = 0; j < numeroVertices; j++) {
                linha += ((matrizAdjacencia[i][j]) ? "true " : "false") + "|";
            }
            System.out.println(linha);
        }
    }

    public static void main(String[] args) {
        GrafoMatrizAdjacencia g = new GrafoMatrizAdjacencia(5);
        g.adicionarAresta(0, 1);
        g.adicionarAresta(3,4);
        g.imprimirMatriz();

    }

}
