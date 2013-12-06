package widgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotaoNumero extends JButton implements IBotao {
    
    private int width   = 100;
    private int height  = 80;
    private int padding = 2;
    
    /**
     * O número/valor do botão
     */
    private int number;

    public BotaoNumero(int number, ActionListener act) {
        super( String.valueOf(number) );
        this.number = number;
        
        this.setForeground( Color.RED );
        this.setFont( new Font("Arial", Font.BOLD, 70) );
        
        this.setActionCommand("botaonumero");
        this.addActionListener(act);
    }

    public void placeIn(IBotao botao, String position) {
        Rectangle bounds = botao.getBounds();
        
        switch (position) {
        case "top":
            this.setBounds(bounds.x, bounds.y - bounds.height - this.padding, this.width, this.height);
            break;
        case "bottom":
            this.setBounds(bounds.x, bounds.y + bounds.height + this.padding, this.width, this.height);
            break;
        case "left":
            this.setBounds(bounds.x - bounds.width - this.padding, bounds.y, this.width, this.height);
            break;
        case "right":
        default:
            this.setBounds(bounds.x + bounds.width + this.padding, bounds.y, this.width, this.height);
            break;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }
    
    public int getNumber() {
        return this.number;
    }    
}
