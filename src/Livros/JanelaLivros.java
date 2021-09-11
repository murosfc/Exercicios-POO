package Livros;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class JanelaLivros extends JFrame{	
	public int ultimaConsulta=0;
	public int lastLivro=-1;
	
	//método contrutor
	public JanelaLivros()
	{
		this.setTitle("Controle de Livros");
		this.setSize(480,480);		
		this.setResizable(false);		
		
		//Cirar o container do JFrame
		Container tela = this.getContentPane();
		
		//Add JPanel ao JFrame
		JPanel painel = new JPanel();
		tela.add(painel);		
		
		JLabel titulo = new JLabel("teste", SwingConstants.LEFT);
		painel.add(titulo);
		titulo.setText("Título do livro: ");
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		
		JTextField nomeLivro = new JTextField(30);
		painel.add(nomeLivro);
		nomeLivro.setToolTipText("Digite o título do livro");
		
		JLabel pag = new JLabel();
		painel.add(pag);
		pag.setText("Numero de páginas do livro: ");
		
		JTextField pagLivro = new JTextField(10);
		painel.add(pagLivro);
		pagLivro.setToolTipText("Digite a quantidade de páginas que o livro contém");
		
		JButton adiciona = new JButton("Adicionar");
		painel.add(adiciona);
		
		JButton lista = new JButton("Listar");
		painel.add(lista);
		
		JLabel msgErroSucesso = new JLabel();
		painel.add(msgErroSucesso);
		
		JLabel msgLista = new JLabel();
		painel.add(msgLista);
		msgLista.setText("################### Lista de livros registrados ####################");
		msgLista.setVisible(false);	
		msgLista.setForeground(Color.blue);
		
		DefaultListModel relacao = new DefaultListModel();
		JList listaLivros = new JList (relacao);		
		painel.add(listaLivros);
		listaLivros.setVisible(false);
		
		Livro[] Livros = new Livro[200];		
		
		adiciona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				msgErroSucesso.setVisible(true);
				listaLivros.setVisible(false);
				msgLista.setVisible(false);								
				if (validaEntrada(nomeLivro.getText(), pagLivro.getText()))
				{
					lastLivro ++;
					Livros[lastLivro]= new Livro(nomeLivro.getText(), Integer.parseInt(pagLivro.getText()));
					msgErroSucesso.setText("Livro "+Livros[lastLivro].getLivros()+ " adicionado com sucesso");
					msgErroSucesso.setForeground(Color.blue);					
				}
				else
				{
					msgErroSucesso.setText("<html>Para inserir um livro ambas informações de título e número páginas<br>precisam estar preenchidas, ou você não digitou um número válido<br>para a quantidade de páginas</html>");
					msgErroSucesso.setForeground(Color.red);					
				}				
			}});	
		
		lista.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lastLivro >= 0)
				{
					int i;				
					msgErroSucesso.setVisible(false);
					msgLista.setVisible(true);	
					for (i=ultimaConsulta;i<=lastLivro;i++)
					{
						relacao.addElement(Livros[i].getLivros());					
					}
					ultimaConsulta=i;
					listaLivros.setVisible(true);
					listaLivros.setVisibleRowCount(10);
				}								
			}});
		
		//Fundamentais para funcionamento
		this.setVisible(true);
		this.repaint();
	}

	//verifica se os campos de texto não estão vazios
public boolean validaEntrada(String txt1, String txt2)
{
	if (txt1.equals("") || txt2.equals("") || !isStringInt(txt2)) {
		return false;
	}
	else return true;
}

public boolean isStringInt(String s)
{
    try
    {
        Integer.parseInt(s);
        return true;
    } catch (NumberFormatException ex)
    {
        return false;
    }
}
}
