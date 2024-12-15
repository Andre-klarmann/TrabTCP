public class Configuracao {

    // Atributos privados
    private String idioma;
    private boolean tema;

    // Construtor da classe
    public Configuracao(String idioma, boolean tema) {
        this.idioma = idioma;
        this.tema = tema;
    }

    // Getter para idioma
    public String getIdioma() {
        return this.idioma;
    }

    // Setter para idioma
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    // Getter para tema
    public boolean getTema() {
        return this.tema;
    }

    // Setter para tema
    public void setTema(boolean tema) {
        this.tema = tema;
    }

}
