public class TarefaSorte extends Tarefa {
    private int bonusSorte;

    TarefaSorte(int pontos, String descricao, int bonus){
        super("Sorte", pontos, descricao);
        this.bonusSorte = bonus;
    }

    public int getBonus(){
        return this.bonusSorte;
    }
}
