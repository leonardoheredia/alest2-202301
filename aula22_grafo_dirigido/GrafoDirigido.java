package aula22_grafo_dirigido;

import java.util.ArrayList;

public class GrafoDirigido {

    private ArrayList<Integer> listaAdjacencia[];
    public int getNumeroVertices() {
        return numeroVertices;
    }
    private int numeroVertices;
    private int numeroArestas;

    public GrafoDirigido(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
        listaAdjacencia = new ArrayList[numeroVertices];
        for (int i = 0; i < numeroVertices; i++) {
            listaAdjacencia[i] = new ArrayList<>();
        }
    }
    public void adicionarAresta(int v, int w) {
        this.listaAdjacencia[v].add(w);
        this.numeroArestas++;
    }
    public ArrayList<Integer> verticesAdjacentes(int vertice) {
        return this.listaAdjacencia[vertice];
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

    public ArrayList<Integer> ordenarTopologicamente() {
        boolean[] marcado = new boolean[this.numeroVertices];
        ArrayList<Integer> ordem = new ArrayList<>();
        for (int i = 0; i < this.numeroVertices; i++) {
            if(!marcado[i])  {
                dfs(i, marcado, ordem);
                ordem.add(i);
            }
        }

        ArrayList<Integer> ordemInversa = new ArrayList<>();
        for (int i = ordem.size()-1; i>=0; i--) {
            ordemInversa.add(ordem.get(i));
        };
        return ordemInversa;
    }

    public void dfs(int vertice, boolean[] marcado, ArrayList<Integer> ordem) {
        marcado[vertice] = true;
        for(int vizinho:this.verticesAdjacentes(vertice)) {
            if(!marcado[vizinho]) {
                dfs(vizinho, marcado, ordem);
                ordem.add(vizinho);
            }
        }
    }

    public boolean contemCiclo() {
        int[] verticeAux = new int[numeroVertices];
        for (int i = 0; i < numeroVertices; i++) { verticeAux[i] = -1;}

        for (int i = 0; i < numeroVertices; i++) {
            if(verticeAux[i] == -1) {
                if(visitar(i, verticeAux)) return true;
            }
        }
        return false;
    }
    private boolean visitar(int vertice, int[] verticeAux) {
        verticeAux[vertice] = 0;
        for (Integer vizinho:verticesAdjacentes(vertice)) {
            if(verticeAux[vizinho]==0) return true;
            else if(verticeAux[vizinho]==-1) {
                if(visitar(vizinho, verticeAux)) return true;
            }
        }
        verticeAux[vertice] = 1;
        return false;
    }
    public static void main(String[] args) {
        GrafoDirigido g = new GrafoDirigido(7);

        g.adicionarAresta(0,1);
        g.adicionarAresta(0,2);
        g.adicionarAresta(0,5);
        g.adicionarAresta(1,4);
        g.adicionarAresta(3,2);
        g.adicionarAresta(3,5);
        g.adicionarAresta(3,6);
        g.adicionarAresta(5,2);
        g.adicionarAresta(6,0);
        g.adicionarAresta(6,4);

        System.out.println(g.toDot());

        BuscaEmProdundidade busca = new BuscaEmProdundidade(g, 0);
        for (int i = 0; i < busca.getVisitados().length; i++) System.out.println(i + " - " + busca.getVisitados()[i]);
        System.out.println("");
        for (int i = 0; i < busca.getAntecessores().length; i++) System.out.println(i + " - " + busca.getAntecessores()[i]);

        System.out.println("");
        System.out.println("Pre-ordem");
        for (int i = 0; i < busca.preordem.length; i++) System.out.println(i + " - " + busca.preordem[i]);

        System.out.println("Pos-ordem");
        for (int i = 0; i < busca.posordem.length; i++) System.out.println(i + " - " + busca.posordem[i]);

        //ArrayList<Integer> ordem = g.ordenarTopologicamente();

        //System.out.println(g.contemCiclo());


    }
}
