package aula24_grafos_valorado;

public class AppExemplo {
    public static void main(String[] args) {
        GrafoValorado g = new GrafoValorado(4);
        g.adicionarAresta(0, 1, 33);
        g.adicionarAresta(0,2, 10);
        g.adicionarAresta(1,2, 99);
        g.adicionarAresta(0, 3, 200);

        System.out.println(g.toDot());

        BuscaEmLargura busca1 = new BuscaEmLargura(g, 0);
        busca1.imprimirResultado();
    }
}
