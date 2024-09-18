package br.com.undemy.cm.visao;

import br.com.undemy.cm.modelo.Campo;
import br.com.undemy.cm.modelo.CampoEvento;
import br.com.undemy.cm.modelo.CampoObservador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


public class BotaoCampo extends JButton implements CampoObservador, EventoMouse {
    private final Color BG_PADRAO = new Color(184, 184, 184);
    private final Color BG_MARCAR = new Color(8, 179, 247);
    private final Color BG_EXPLODIR = new Color(189, 66, 68);
    private final Color TEXTO_VERDE = new Color(0, 100, 0);

    private Campo campo;

    public BotaoCampo(Campo campo) {
        this.campo = campo;
        setBackground(BG_PADRAO);
        setOpaque(true);
        setBorder(BorderFactory.createBevelBorder(0));
        setFont(new Font("Arial", Font.BOLD, 18));

        campo.registrarObservador(this); // refistra o observador

        addMouseListener(this);
    }

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        switch (evento) {

            case ABRIR:
                aplicarEstiloAbrir();
                break;

            case MARCAR:
                aplicarEstiloMarcar();
                break;
            case EXPLODIR:
                aplicarEstiloExplodir();


                break;
            default:
                aplicarEstiloPadrao();
        }
        SwingUtilities.invokeLater(() -> {
            repaint();
            validate();
        });
    }


    private void aplicarEstiloPadrao() {
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        setText("");


    }

    private void aplicarEstiloExplodir() {
        setText("X");
        setBackground(BG_EXPLODIR);
        setForeground(Color.WHITE);


    }

    private void aplicarEstiloMarcar() {
        setBackground(BG_MARCAR);
        setForeground(Color.WHITE);
        setText("M");


    }

    private void aplicarEstiloAbrir() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        if (campo.isMinado()){
            setText("X");
            setBackground(BG_EXPLODIR);

            return;

        }

        setBackground(BG_PADRAO);


        switch (campo.minasNaVizinhanca()) {
            case 1:
                setForeground(TEXTO_VERDE);
                break;
            case 2:
                setForeground(Color.BLUE);
                break;
            case 3:
                setForeground(Color.YELLOW);
                break;
            case 4:
                setForeground(Color.RED);
                break;
            case 5:
            case 6:
            default:
                setForeground(Color.PINK);
        }
        String valor =!campo.vizinhacaSegura() ? campo.minasNaVizinhanca() + "":"";
        setText(valor);
    }
// eventos do mause


    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {

            campo.abrir();

        } else {

            campo.alternarMarcacao();
        }
    }
}

