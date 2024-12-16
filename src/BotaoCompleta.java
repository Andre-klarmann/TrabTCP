import java.time.LocalDate;


public class BotaoCompleta {

    // Atributo privado
    private boolean isAcionado;

    // Construtor
    public BotaoCompleta() {
        this.isAcionado = false;
    }

    // Getter para isAcionado
    public boolean getIsAcionado() {
        return isAcionado;
    }

    // Setter para isAcionado
    public void setIsAcionado(boolean booleano) {
        this.isAcionado = booleano;
    }

    public void completaTarefa(Calendario calendario, GerenciadorDeTarefas gerenciadorDeTarefas) {
        if(isAcionado && calendario.estaNoPeriodo(LocalDate.now())) {
            /*
            * 
            * 
            */
        }
    }
}
