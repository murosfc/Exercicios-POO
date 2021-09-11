package Livros;

public class Livro {
	private String[] livros = new String[200];
	private int[] paginas = new int[200];
	private int indice;	
	
	//método construtor de cada livro
	public Livro ()
	{
		indice= -1;		
	}
	
	/*método construtor de cada livro
	public Livro (String nomeLivro, int paginas)
	{
		this.indice++;
		this.setLivros(nomeLivro);
		this.setPaginas(paginas);
	} */
	
	//métodos de acesso
	public String getLivros(int i) {
		return livros[i];
	}

	public void setLivros(String nome) {
		this.livros[indice] = nome;
	}

	public int getPaginas(int i) {
		return paginas[i];
	}

	public void setPaginas(int paginas) {
		this.paginas[indice] = paginas;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int i) {
		this.indice = i;
	}

	//método acionar livro ao array
	public void addLivro (String nomeLivro, int paginas)
	{
		this.indice++;
		this.setLivros(nomeLivro);
		this.setPaginas(paginas);
	}

	
	
	
}
