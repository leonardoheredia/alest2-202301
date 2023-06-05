package aula26_grafos_dijkstra;

public class DijkstraAula {
    public int[] antecessor;
    public int[] distancia;
    public boolean[] percorrido;
    private GrafoDirigidoValorado grafo;

    public DijkstraAula(GrafoDirigidoValorado g, int origem) {
        this.grafo = g;
        antecessor = new int[grafo.getNumeroVertices()];
        distancia = new int[grafo.getNumeroVertices()];
        percorrido = new boolean[grafo.getNumeroVertices()];

        for (int i = 0; i < grafo.getNumeroVertices(); i++) {
            antecessor[i] = -1;
            distancia[i] = Integer.MAX_VALUE;
            percorrido[i] = false;
        }

        FilaPrioridadeMinima filaMin = new FilaPrioridadeMinima();
        filaMin.enfileirar(origem, 0);
        distancia[0] = 0;

        while (!filaMin.estaVazia()) {
            int vertice = filaMin.desenfileirar();
            percorrido[vertice] = true;
            for (GrafoDirigidoValorado.ArestaDirigida aresta:grafo.getListaAdjacencia(vertice)) {
                int destino = aresta.destino;
                int distanciaDestino = distancia[vertice] + aresta.peso;
                if(distanciaDestino<distancia[destino]) {
                    antecessor[destino] = vertice;
                    distancia[destino] = distanciaDestino;
                    if(!filaMin.existe(destino)) filaMin.enfileirar(destino, distanciaDestino);
                    else filaMin.atualizarDistanca(destino, distanciaDestino);
                }
            }
        }
    }

    public void imprimirResultado() {
        System.out.println("vertice,distancia,antecessor,percorrido");
        for (int i = 0; i < grafo.getNumeroVertices(); i++) {
            System.out.println(i + "," + distancia[i] + "," + antecessor[i] + "," + percorrido[i]);
        }
    }

}
