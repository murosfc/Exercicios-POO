package Integrador;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame{
	
	public Janela()
	{
	this.setTitle("Exercícios POO");
	this.setSize(500,150);
	this.setResizable(false);
	
	//Obtem container do JFram
	Container tela = this.getContentPane();
	
	//Inclui o JPanel ao JFrame
	JPanel painel = new JPanel();
	tela.add(painel);
	painel.setLayout(new GridLayout(0,3));
	
	//Exercício Calculadora
	JButton calculadora = new JButton("Calculadora simples");
	painel.add(calculadora);
	
	//Jogo de Adivinhar
	JButton adivinhe = new JButton("Jogo adivinhar");
	painel.add(adivinhe);
	
	//Jogo de Adivinhar
	JButton livros = new JButton("Controle de livros");
	painel.add(livros);
	
	//Ações dos botões
	calculadora.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			final Calculadora.Janela ObjCalc = new Calculadora.Janela();			
		}		 
	});
	
	adivinhe.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent e) {
			final Adivinhe.TelaJogo ObjJogoAdivinhe = new Adivinhe.TelaJogo();	
		}
		
	});
	
	livros.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			final Livros.JanelaLivros ObjLivro = new Livros.JanelaLivros();			
		}
		
	});
	
	//necessário para funcionamento
	this.setVisible(true);
	this.repaint();
	}

}
