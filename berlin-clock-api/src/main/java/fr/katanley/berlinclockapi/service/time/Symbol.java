package fr.katanley.berlinclockapi.service.time;

public enum Symbol {
    NO_LIGHT_SYMBOL("O"),
    RED_LIGHT_SYMBOL("R"),
    YELLOW_LIGHT_SYMBOL("Y");

    private final String textRepresentation;
    private Symbol(String textRepresentation){
        this.textRepresentation = textRepresentation;
    }
    public String toString() {
        return this.textRepresentation;
    }
}
