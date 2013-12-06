package widgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Classe para criação de um botão de número (0-9).
 * @author diovani
 *
 */
public class BotaoNumero extends Botao implements IBotao {
        
    /**
     * O número/valor do botão
     */
    private int number;

    public BotaoNumero(int number, ActionListener act) {
        super( String.valueOf(number) );
        this.number = number;
        
        this.setActionCommand("botaonumero");
        this.addActionListener(act);
    }
    
    public int getNumber() {
        return this.number;
    }    
}
