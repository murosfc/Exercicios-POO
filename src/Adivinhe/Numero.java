package Adivinhe;

import java.util.*;

public class Numero {
	private int num;
	private int tentativas;
	
	//método contrutor
	public Numero()
	{
		Random random = new Random();
		num = random.nextInt((100 - 1) + 1) + 1;
		tentativas=0;
	}
	//métodos de acesso
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}		
	public int getTentativas() {
		return tentativas;
	}
	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}
	
	//verifica palpite, retorna 1 para certo, 2 para menor e 3 para maior
	public int checaPalpite(int palpite)
	{		
		if (palpite == this.num)
		{				
			return 1;
		}
		else if (palpite > this.num)
		{			
			return 2;
		}
		else {		
			return 3;
		}
	}

}
