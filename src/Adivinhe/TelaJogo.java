package Adivinhe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaJogo extends JFrame{	
	
	//método construtor da janela
	public TelaJogo()
	{		
		this.setTitle("Jogo do Adivinhe");
		this.setSize(250,200);
		this.setResizable(false);		
		
		//Obtem container do JFrame
		Container tela = this.getContentPane();
		
		//Inclui o JPanel ao JFrame
		JPanel painel = new JPanel();		
		tela.add(painel);		
		
		JLabel msginicial = new JLabel();
		painel.add(msginicial);
		msginicial.setText("<html>Eu tenho um número entre 1 e 100<br>&nbsp&nbsp&nbsp Você é capaz de adivinhá-lo?<br><br></html>");
		
		JLabel setadir = new JLabel();
		painel.add(setadir );
		setadir.setText("    >>>>>>>>");		
			
		JTextField palpite = new JTextField(5);		
		painel.add(palpite);
		palpite.setToolTipText("Digite seu palpite, um número entre 1 e 100");
		palpite.setHorizontalAlignment(palpite.CENTER);
		
		JLabel setaesq = new JLabel();
		painel.add(setaesq );
		setaesq.setText("<<<<<<<<");	
				
		JButton send = new JButton ("Enviar");
		painel.add(send);
		
		JButton restart = new JButton("Reiniciar Jogo");
		painel.add(restart);
		
		JLabel result = new JLabel();
		painel.add(result);
		
		JLabel tentativas = new JLabel();
		painel.add(tentativas);
		tentativas.setText("");	
		
		final Numero ObjNum = new Numero();
		
		send.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						ObjNum.setTentativas(ObjNum.getTentativas()+1);
						if (!(palpite.getText().equals("")))
						{							
							if (ObjNum.checaPalpite(Integer.parseInt(palpite.getText())) == 1)
							{
								tentativas.setText("");	
								result.setText("Parabéns! Você acertou em "+ObjNum.getTentativas()+" tentativas");
								palpite.setBackground(Color.green);
								palpite.setForeground(Color.black);
								palpite.setEditable(false);
							}
							else if (ObjNum.checaPalpite(Integer.parseInt(palpite.getText())) == 2)
							{
								result.setText("Checando palpite");
								palpite.setBackground(Color.white);								
								palpite.setBackground(Color.red);
								palpite.setForeground(Color.white);
								result.setText("O numero procurado é menor");
								tentativas.setText("Tentantivas = "+ ObjNum.getTentativas());
							}
							else 
							{
								result.setText("Checando palpite");								
								palpite.setBackground(Color.white);								
								palpite.setBackground(Color.blue);
								palpite.setForeground(Color.white);
								result.setText("O numero procurado é maior");
								tentativas.setText("Tentantivas = "+ ObjNum.getTentativas());
							}								
						}
						else {
							result.setText("Digite um palpite antes de clicar em Ok");
						}
					}
				});
		
		restart.addActionListener(new ActionListener()
				{					
					@Override		
					public void actionPerformed(ActionEvent e) {
						dispose();
						new TelaJogo();
					}});
		
		// Metodos do objeto JFrame, usados no final do Construtor
		// para garantir que os novos componentes incluídos apareçam de forma correta
		this.setVisible(true);
		this.repaint();		
	}
}
