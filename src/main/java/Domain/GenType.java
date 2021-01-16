package Domain;

import lombok.Getter;

@Getter
public enum GenType {
    MAN("M"),
    WOMAN("W");

    private String gen;

    GenType(String gen) {
        this.gen = gen;
    }
}
