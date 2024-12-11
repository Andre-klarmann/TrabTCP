public abstract class Tarefa {
    private String tipo;
    private int pontosAoCompletar;
    private String descricao;

    Tarefa(String tipo, int pontos, String descricao){
        this.tipo = tipo;
        this.pontosAoCompletar = pontos;
        this.descricao = descricao;
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getPontos(){
        return this.pontosAoCompletar;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
