package projecteuler;

public class Funcoes
{
	public static double serieFibonacci(double n)
	{
		if (n < 2)
		{
			return n;
		}
		else
		{
			return serieFibonacci(n - 1) + serieFibonacci(n - 2);
		}
	}

}
