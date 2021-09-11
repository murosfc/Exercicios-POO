package Calculadora;

public class Calculadora {
	private float num1, num2;

	public float getNum1() {
		return num1;
	}

	public void setNum1(float num1) {
		this.num1 = num1;
	}

	public float getNum2() {
		return num2;
	}

	public void setNum2(float num2) {
		this.num2 = num2;
	}
	
	//método construtor
	public Calculadora(float n1, float n2)
	{
		num1= n1;
		num2 = n2;
	}
	
	//métodos
	public float Soma()
	{
		return this.num1+this.num2;
	}
	
	public float Subt()
	{
		return this.num1-this.num2;
	}
	
	public float Mult()
	{
		return (float)this.num1*this.num2;
	}
	
	public float Div()
	{
		return (float)this.num1/this.num2;
	}

}
