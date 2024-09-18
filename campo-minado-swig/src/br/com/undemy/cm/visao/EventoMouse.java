package br.com.undemy.cm.visao;

import br.com.undemy.cm.modelo.Campo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface EventoMouse extends MouseListener, MouseMotionListener {


    @Override
    default void mouseClicked(MouseEvent e) {
    }

    @Override
    default void mousePressed(MouseEvent e) {
        if(e.getButton() == 1 ){


        }else{


        }
    }

    @Override
    default void mouseReleased(MouseEvent e) {
        // Lógica para tratar a liberação do mouse
    }

    @Override
    default void mouseEntered(MouseEvent e) {
        // Lógica para tratar a entrada do mouse em um componente
    }

    @Override
    default void mouseExited(MouseEvent e) {
        // Lógica para tratar a saída do mouse de um componente
    }

    @Override
    default void mouseDragged(MouseEvent e) {
        // Lógica para tratar o arrasto do mouse
    }

    @Override
    default void mouseMoved(MouseEvent e) {
        // Lógica para tratar o movimento do mouse
    }
}
