package Livros;

public class Livro {
	private String livros;
	private int paginas;	
	
	//m�todo construtor de cada livro
	public Livro (String titulo, int paginas)
	{
		this.livros = titulo;
		this.paginas = paginas;		
	}
	
	public Livro ()
	{
		this.livros = "";
		this.paginas = 0;		
	}
			
	//m�todos de acesso
	public String getLivros() {
		return livros;
	}

	public void setLivros(String livros) {
		this.livros = livros;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
}
