import java.time.LocalDate;

public class Calendario {
    private LocalDate dataInicio;
    private LocalDate dataFim;

    // Construtor
    public Calendario(LocalDate dataInicio, LocalDate dataFim) {
        if (dataInicio.isAfter(dataFim)) {
            throw new IllegalArgumentException("A data de início não pode ser posterior à data de fim.");
        }
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getter para dataInicio
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    // Setter para dataInicio
    public void setDataInicio(LocalDate dataInicio) {
        if (dataInicio.isAfter(this.dataFim)) {
            throw new IllegalArgumentException("A data de início não pode ser posterior à data de fim.");
        }
        this.dataInicio = dataInicio;
    }

    // Getter para dataFim
    public LocalDate getDataFim() {
        return dataFim;
    }

    // Setter para dataFim
    public void setDataFim(LocalDate dataFim) {
        if (this.dataInicio.isAfter(dataFim)) {
            throw new IllegalArgumentException("A data de fim não pode ser anterior à data de início.");
        }
        this.dataFim = dataFim;
    }

    // Método para verificar se uma data está no período
    public boolean estaNoPeriodo(LocalDate data) {
        return (data.equals(dataInicio) || data.equals(dataFim) || (data.isAfter(dataInicio) && data.isBefore(dataFim)));
    }

}
