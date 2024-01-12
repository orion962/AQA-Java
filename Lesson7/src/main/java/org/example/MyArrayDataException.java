package org.example;

public class MyArrayDataException extends Exception {
    private final int line;
    private final int column;

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