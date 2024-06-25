package main;

import gestor.GestorJuego;
import vistas.SeleccionarNaveVista;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GestorJuego gestor = GestorJuego.getInstancia();
        SwingUtilities.invokeLater(() -> {
            SeleccionarNaveVista naveVista = new SeleccionarNaveVista();
        });
    }
}