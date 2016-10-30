package rosalind;

public class DNA
{

	public static void main(String[] args)
	{
		String sequencia = "AGAATGAGCGCGGGTGTGGCAGGAAGTCCCAATGGAAGTCATAATGACACCGCCGTATTTTAGTCATTGATAGGTCTCGACTATCTTATAGAAGCACGATTACAAGATGTGTTGTGATTACAACCCTAAACCGGCGCCGCCTAAAGGGGCACCTTAAATCACAGACCTTGTGTTTTTTCCTACCCAATCCTTAAATATTACTAAAGTCGTAGACTATGAATTTCGACGGGTACTGTGTGACCCAGCGAAAATCTGACTAATCGATGCACTACGGCACCTGTCTCGTACAACTACTATTCCCCCACAGGCAACCTATATAGCTGCTGGAGAGAGTCCGACGTTTTGTCCGGACCTGGTAATAAGCGAGCAAAGGCAAGGTTTCAGTCGCTCTCCGGCTATTCTAGCATGGTTTGAACTCGAAGGATGAGCACCAAATTTGCAGCCGGTACCTTGTGGACACGTGCTCTTGAGGCGCTTCTCTATGGGTGTTGAACGACCCTGCTCACTGAGCTCAGCTAATCCGCAATGAAGCCGATGCCACGGAATCAGCCTTTTATTCCAAGCCCCCTCAATGTTACTTTGGCTCCACTGAACACCGTCGGCATCAGGCGAAAGATGCGAGTATTCGCGTATTCATAGTATCTAGGTTGGTCTCACGGGGATCTATTTTGCCAGAATTGGGAAAAGCACCTTAACCGTCCAGACTATAAAGGACTTTGCCCACGTGCCAGTTCGGAGGCAATGCTTAACCCATGTCATGTGCGTACACATAGGTCTGCGCCCGGCAAGGTTCCCACTGGGGTTGCAAATAAGATTTGACTTGAACTAAGGATTCATGCGGACAAATCATTATGTGT";
		char letra;
		int[] total = {0,0,0,0};
		
		for(int i = 0; i < sequencia.length(); i++)
		{
			letra = sequencia.charAt(i);
			
			if(letra == 'A')
			{
				total[0] = total[0] + 1;
			}
			
			if(letra == 'C')
			{
				total[1] = total[1] + 1;
			}
			
			if(letra == 'G')
			{
				total[2] = total[2] + 1;
			}
			
			if(letra == 'T')
			{
				total[3] = total[3] + 1;
			}
		}
		
		System.out.println("A = " + total[0]);
		System.out.println("C = " + total[1]);
		System.out.println("G = " + total[2]);
		System.out.println("T = " + total[3]);
		System.out.println(total[0] + " " + total[1] + " " + total[2] + " " + total[3]);
	}

}
