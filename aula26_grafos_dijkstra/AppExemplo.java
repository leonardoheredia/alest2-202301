package aula26_grafos_dijkstra;

public class AppExemplo {
    public static void main(String[] args) {
        GrafoDirigidoValorado g = new GrafoDirigidoValorado(5);
        g.adicionarAresta(0,1,30);
        //g.adicionarAresta(1,0,30);

        g.adicionarAresta(0,3,200);
        //g.adicionarAresta(3,0,200);

        g.adicionarAresta(1,2,20);
        //g.adicionarAresta(2,1,20);

        g.adicionarAresta(2,3,60);
        //g.adicionarAresta(3,2,60);

        g.adicionarAresta(2,4,10);
        //g.adicionarAresta(4,2,10);

        g.adicionarAresta(3,4,40);
        //g.adicionarAresta(4,3,40);

        System.out.println(g.toDot());

        Dijkstra d = new Dijkstra(g, 0);


        //grafo do exemplo do slide do livro
        GrafoDirigidoValorado g2 = new GrafoDirigidoValorado(8);
        g2.adicionarAresta(0,1, 5);
        g2.adicionarAresta(0,4, 9);
        g2.adicionarAresta(0,7, 8);
        g2.adicionarAresta(1,2,12);
        g2.adicionarAresta(1,3,15);
        g2.adicionarAresta(1,7,4);
        g2.adicionarAresta(2,3,3);
        g2.adicionarAresta(2,6,11);
        g2.adicionarAresta(3,6,9);
        g2.adicionarAresta(4,5,4);
        g2.adicionarAresta(4,6,20);
        g2.adicionarAresta(4,7,5);
        g2.adicionarAresta(5,2,1);
        g2.adicionarAresta(5,6,13);
        g2.adicionarAresta(7,2,7);
        g2.adicionarAresta(7,5,6);

        Dijkstra d2 = new Dijkstra(g2, 0);
        d2.imprimirResultado();


    }
}
