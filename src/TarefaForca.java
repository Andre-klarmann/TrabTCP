public class TarefaForca extends Tarefa{
    private int bonusForca;

    TarefaForca(int pontos, String descricao, int bonus){
        super("Força", pontos, descricao);
        this.bonusForca = bonus;
    }

    public int getBonus(){
        return this.bonusForca;
    }
}
