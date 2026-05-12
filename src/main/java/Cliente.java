public class Cliente {
    private String nome;
    private int id;
    private static int registros = 0;

    Cliente(String nome){
        this.nome = nome;
        this.id = registros++;
    }

    public String getNome() { return nome; }
}