/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.*;
import entidade.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Laiza
 */
public class TelaExibeExemplar extends JDialog{

    private controleExemplar ctrlExemplar;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextArea resultado = new JTextArea(20, 40);

    public TelaExibeExemplar(controleExemplar ctrlExemplar) {
        this.ctrlExemplar = ctrlExemplar;
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(55, 50, 55, 50),
                BorderFactory.createEmptyBorder()));

        resultado.setEditable(false);
        String isso = this.ctrlExemplar.getListaExemplar();
        resultado.setText(isso+"\n\n");
        
        JScrollPane scroll = new JScrollPane(resultado, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        adicionarComponente(painel, new JLabel("Lista exemplares cadastrados"), 0, 0, 1, 1);
        adicionarComponente(painel, scroll, 0, 1, 1, 1);
        super.add(painel);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
        
    }
     
    
    private void adicionarComponente(JPanel painel, JComponent componente,
            int gridx, int gridy, int height, int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = height;
        c.gridwidth = width;
        painel.add(componente, c);
    }
}
