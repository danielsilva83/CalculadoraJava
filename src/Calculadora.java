import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import widgets.BotaoNumero;


public class Calculadora extends JFrame implements ActionListener {

    JLabel lblTelaVisor;
    
    public Calculadora() {

        super( "Calculadora" );
        
        Container container = getContentPane();
        container.setLayout( new BorderLayout() );
        
        container.add( getPainelCalculadora(), BorderLayout.CENTER );

        setSize( 500, 600 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.setVisible( true );
    }
    
    private JComponent getPainelCalculadora() {
        JPanel painel = new JPanel();
        painel.setLayout( null );
        
    	/*
    	 * Adiciona o visor
    	 */
        lblTelaVisor = new JLabel( "0.0");
        lblTelaVisor.setBounds( 2, 25, 480, 80 );
        lblTelaVisor.setBackground( Color.GREEN );
        lblTelaVisor.setForeground( Color.BLUE );
        lblTelaVisor.setFont( new Font("Monospace", Font.BOLD, 70) );
        lblTelaVisor.setHorizontalAlignment(JLabel.RIGHT);
        lblTelaVisor.setBorder( BorderFactory.createEtchedBorder() );   
        painel.add( lblTelaVisor );
        
        /*
         * Adiciona os botões de números,
         * Note que apenas o primeiro botão tem uma posuição fixa, 
         * todos os demais fica relativos à um anterior.
         */
        BotaoNumero botao7 = new BotaoNumero(7, this);
        botao7.setBounds(0, 110, botao7.getWidth(), botao7.getHeight());
        painel.add( botao7 );

        BotaoNumero botao8 = new BotaoNumero(8, this);
        botao8.placeIn(botao7, "right");
        painel.add( botao8 );

        BotaoNumero botao9 = new BotaoNumero(9, this);
        botao9.placeIn(botao8, "right");
        painel.add( botao9 );

        BotaoNumero botao4 = new BotaoNumero(4, this);
        botao4.placeIn(botao7, "bottom");
        painel.add( botao4 );

        BotaoNumero botao5 = new BotaoNumero(5, this);
        botao5.placeIn(botao4, "right");
        painel.add( botao5 );

        BotaoNumero botao6 = new BotaoNumero(6, this);
        botao6.placeIn(botao5, "right");
        painel.add( botao6 );

        BotaoNumero botao1 = new BotaoNumero(1, this);
        botao1.placeIn(botao4, "bottom");
        painel.add( botao1 );

        BotaoNumero botao2 = new BotaoNumero(2, this);
        botao2.placeIn(botao1, "right");
        painel.add( botao2 );

        BotaoNumero botao3 = new BotaoNumero(3, this);
        botao3.placeIn(botao2, "right");
        painel.add( botao3 );

        BotaoNumero botao0 = new BotaoNumero(0, this);
        botao0.setWidth( botao0.getWidth() *2 + botao0.getPadding() );	//usa o espaço de dois botões
        botao0.placeIn(botao1, "bottom");
        painel.add( botao0 );

        return painel;
    }

    public void actionPerformed(ActionEvent ev) {
    	
        if( ev.getActionCommand().equals( "botaonumero" ) ) {
        	/*
        	 * Quando um botão de número é pressionado, só precisamos
        	 * atualizar o visor com este.
        	 */
            BotaoNumero botao = (BotaoNumero) ev.getSource();
            String texto = lblTelaVisor.getText();
            double valor = Double.parseDouble( texto );
            valor = valor * 10 + botao.getNumber();	//*10 para "saltar" uma casa à esquerda
            
            lblTelaVisor.setText( String.valueOf(valor) );
        }
    }

}