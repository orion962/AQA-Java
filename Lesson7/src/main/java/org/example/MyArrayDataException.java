package org.example;

public class MyArrayDataException extends Exception {
    int line;
    int column;

    MyArrayDataException(String msg, int line, int column) {
        super(msg);
        this.line = line;
        this.column = column;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Ячейка [" + line + "][" + column + "].";
    }
}
