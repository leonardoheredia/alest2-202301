package aula10_tries_exercicios;

/*
* Usando tipos genericos no java https://docs.oracle.com/javase/tutorial/java/generics/types.html
* */
public class TabelaSimbolos<Chave,Valor> {


    private class Nodo {
        private Chave chave;
        private Valor valor;
        private Nodo proximo;
        public Nodo(Chave chave, Valor valor, Nodo proximo) {
            this.chave = chave;
            this.valor = valor;
            this.proximo = proximo;
        }
    }
    private Nodo inicio;
    private int quantidade = 0;
    public Valor buscar(Chave chave) {
        for(Nodo n = this.inicio; n!=null; n = n.proximo) {
            if(chave.equals(n.chave)) {
                return n.valor;
            }
        }
        return null;
    }
    public void atualizar(Chave chave, Valor valor) {
        for(Nodo n = this.inicio; n!=null; n = n.proximo) {
            if(chave.equals(n.chave)) { //se ja existir a chave entao atualiza o valor
                n.valor = valor;
                return;
            }
        }
        Nodo novoNodo = new Nodo(chave, valor, this.inicio); //se nao existir entao cria um novo nodo
        quantidade++;
        this.inicio = novoNodo; //novo Nodo passa a ser o primeiro la tabela
    }
    public boolean estaVazia() {
        return this.inicio == null;
    }
    public boolean contem(Chave chave) {
        return (buscar(chave)!=null);
    }
    @Override
    public String toString() {
        String str="";
        for(Nodo n = this.inicio; n!=null; n = n.proximo) {
            str = str + n.chave.toString() + " " + n.valor.toString() + "\n";
        }
        return str;
    }
    public void remover(Chave chave){
        //implementar a remocao
        Nodo anterior = this.inicio;
        for (Nodo n = this.inicio; n.proximo!=null; n = n.proximo ) {
            if(n.chave==chave) {
                System.out.println("achei a chave a ser excluida");
                System.out.println("vou excluir");
                anterior.proximo = n.proximo;
                System.out.println("EXCLUIDO o " + n.chave);
                if(inicio==n) {
                    inicio = n.proximo;
                }
            }
        }
    }

    public int getQuantidade() {
        return quantidade;
    }
    public static void main(String[] args) {
        System.out.println("Testando nossa tabela de simbolos");
        TabelaSimbolos<String, String> tabelaVeiculos = new TabelaSimbolos<>();
        tabelaVeiculos.atualizar("IBJ-4433", "Tracker 2.0");
        tabelaVeiculos.atualizar("IIX-2332", "Fiat Uno");
        tabelaVeiculos.atualizar("IEZ-7888", "Jeep Renegade");
        tabelaVeiculos.atualizar("IIX-4444", "Fiat Tempra");
        System.out.println(tabelaVeiculos);

        tabelaVeiculos.remover("IEZ-7888");

        System.out.println(tabelaVeiculos);
    }


}
