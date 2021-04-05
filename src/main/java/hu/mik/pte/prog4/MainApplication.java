package hu.mik.pte.prog4;

import hu.mik.pte.prog4.controller.Control;
import hu.mik.pte.prog4.service.BookService;

public class MainApplication {
    public static void main(String[] args) {
        Control control = new Control(new BookService());
        control.start();
    }
}
