package Calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Janela extends JFrame{	

	//método construtor da classe
	public Janela() 	
	   {	
		this.setTitle("Calculadora");
		this.setSize(300,150);
		this.setResizable(false);
		
		// Obtem o Container do JFrame
		Container c = this.getContentPane();

		// Inclui o JPanel ao JFrame
		JPanel painel = new JPanel();
		c.add(painel);
		
		JLabel num1 = new JLabel ("   Valor 1:    ");
		painel.add(num1);
		
		JTextField boxNum1 = new JTextField(15);
		boxNum1.setToolTipText("Digite o valor 1 para cálculo");
		painel.add(boxNum1);
		
		JLabel num2 = new JLabel ("   Valor 2:     ");
		painel.add(num2);
		
		JTextField boxNum2 = new JTextField(15);
		boxNum2.setToolTipText("Digite o valor 2 para cálculo");
		painel.add(boxNum2);
		
		JLabel resultado = new JLabel ("   Resultado:");
		painel.add(resultado);
		
		JTextField boxResultado = new JTextField(15);
		boxResultado.setToolTipText("Resutado da conta");
		painel.add(boxResultado);
		
		JButton soma = new JButton("+");
		painel.add(soma);		
		
		JButton sub = new JButton ("-");
		painel.add(sub);
		
		JButton mult = new JButton("*");
		painel.add(mult);
		
		JButton div = new JButton("/");
		painel.add(div);
		
		//troca a cor de todos os botões
		ResetBtnColors(soma, sub, mult, div);
		
		// Ação do Botão soma
		soma.addActionListener(new ActionListener()     
				{	
				@Override
				public void actionPerformed(ActionEvent e) {
					fillEmpty(boxNum1,boxNum2);
					ResetBtnColors(soma, sub, mult, div);
					boxResultado.setText("");
					Calculadora ObjCalc = new Calculadora (Integer.parseInt(boxNum1.getText()), Integer.parseInt(boxNum2.getText()));
					boxResultado.setText(String.format("%.2f",ObjCalc.Soma()));
					soma.setBackground(Color.cyan);
				}});
		
		//Ação do Botão Subtração
		sub.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {						
						fillEmpty(boxNum1,boxNum2);
						ResetBtnColors(soma, sub, mult, div);
						Calculadora ObjCalc = new Calculadora(Integer.parseInt(boxNum1.getText()), Integer.parseInt(boxNum2.getText()));
						boxResultado.setText(String.format("%.2f",ObjCalc.Subt()));
						sub.setBackground(Color.cyan);											
				}});
		
		mult.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						fillEmpty(boxNum1, boxNum2);
						ResetBtnColors(soma,sub,mult,div);
						Calculadora objCalc = new Calculadora (Integer.parseInt(boxNum1.getText()), Integer.parseInt(boxNum2.getText()));
						boxResultado.setText(String.format("%.2f",objCalc.Mult()));
						mult.setBackground(Color.cyan);						
					}});
		
		div.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						fillEmpty(boxNum1, boxNum2);
						ResetBtnColors(soma,sub,mult,div);
						Calculadora ObjCalc = new Calculadora (Integer.parseInt(boxNum1.getText()), Integer.parseInt(boxNum2.getText()));
						boxResultado.setText(String.format("%.2f", ObjCalc.Div()));
					}});

		// Metodos do objeto JFrame, usados no final do Construtor
		// para garantir que os novos componentes incluídos apareçam de forma correta
		this.setVisible(true);
		this.repaint();	
	}	

	//método para mudar a cor dos botões exclusivo da classe
	private void ResetBtnColors(JButton soma, JButton sub, JButton mult, JButton div) {
		soma.setBackground(Color.white);
		sub.setBackground(Color.white);
		mult.setBackground(Color.white);
		div.setBackground(Color.white);
	}
	
	//método para preencher com 0 caso algum numero esteja vazio, previne erro
	private void fillEmpty (JTextField n1, JTextField n2)
	{
		if (n1.getText().equals("") )
		{ 
			n1.setText("0");
		}
		if (n2.getText().equals(""))
		{
			n2.setText("0");
		}
	}
}
