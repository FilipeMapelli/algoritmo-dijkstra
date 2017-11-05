package br.com.fms.grafos.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class Teste {

	private static Set<Integer> in = new HashSet<Integer>();
	private static int z, p; // temporary vertices
	private static List<Integer> d = new ArrayList<Integer>();
	private static List<Integer> s = new ArrayList<Integer>();
	private static int distAnterior;
	private int x,y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void minimo(int a[][], int x, int y) {

		// starts the Set and ArrayLists d and s
		in.add(x - 1);

		// treatment of inclusion in the ArrayList (index > size)
		while (d.size() < x - 1) {
			d.add(null);
		}
		d.add(x - 1, 0);
		
		//treatment replace null 
		for (z = 0; z < a.length; z++) {
			if (!in.contains(z)) {
				if (z < d.size()) {
					if (d.get(z) == null) {
						d.set(z, a[x - 1][z]);
						s.add(z, x - 1);
					}
				} else {
					d.add(z, a[x - 1][z]);
					s.add(z, x - 1);
				}
			} else {
				s.add(z, null);
			}
		}
		
		int contaPasso = 1;
		
		while (!in.contains(y-1)){
			p = vertexLowValue();
			in.add(p); //Added "p" to the set
			
			for (z=0; z < d.size(); z++){
				if(!in.contains(z)){
					distAnterior = d.get(z);
					d.set(z, min(d.get(z), d.get(p), a[p][z]));
					
					if(d.get(z) != distAnterior){
						s.set(z, p);
					}
				}
			}
			
			System.out.println("\n#####################");
			System.out.println("PASSO: "+contaPasso);
			System.out.println("P = "+p);
			System.out.println("N = "+in);
			for (z=0; z < d.size(); z++){
				System.out.print("\nd["+(z+1)+"]= "+d.get(z)+"    ----- ");
				System.out.print("s["+(z+1)+"]= "+s.get(z));
			}
			contaPasso += 1;
			
		}
		
		String result = "Em ordem inversa o caminho é : "+y+"; ";
		
		System.out.println("\n");
		System.out.print("Em ordem inversa, o caminho é: ");
		System.out.print(y);
		z = y-1;
		
		while (z != x-1){
			System.out.print("; "+ (s.get(z)+1));
			result += ""+(s.get(z)+1)+"; ";
			z = s.get(z);
		}
		
		result += "\nA distância é: "+d.get(y-1);
		
		System.out.println("\n");
		System.out.println("A distancia é : "+d.get(y-1));
		
		//AJUSTAR RETORNO PARA JSP
		
		System.out.println(result);
		
	}
		
	//get lowest value in d
	private static int lowValue(){
		
		SortedSet<Integer> notIn = new TreeSet<Integer>();
		for(int i=0; i < d.size(); i++){
			if (!in.contains(i) && d.get(i)!=0){ //replaces infinity to zero
				notIn.add(d.get(i));  
			}
		}
		if (notIn.isEmpty()){
			return 0;
		}else{
			return notIn.first();
		}
		
	}
	
	//get the vertex related to lower value
	private static int vertexLowValue(){
		
		int result = 0;
		
		for(int i=0; i < d.size(); i++){
			if (!in.contains(i) && d.get(i)!=0){ //replaces infinity to zero
				if (d.get(i) == lowValue()){
					result = i;
				}
			}
		}
		return result;
	}
	
	
	
	
	/*
	 * d[z], d[p] + A[p,z]
	 * replace infinity by zero
	 */
	private static int min(int dz, int dp, int apz){
		
		int add = 0;
		int result = 0;
		
		if (dp != 0 && apz != 0){
			add = dp+apz; 
		}
		
		if (dz != 0){
			if(add != 0){
				if (dz < add){
					result = dz;
				}else{
					result = add;
				}
			}else{
				result = dz;
			}
		}else{
			result = add;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int[][] a = new int[8][8];
		
		a[0][0] = 0; a[0][1] = 3; a[0][2] = 5; a[0][3] = 0; a[0][4] = 8; a[0][5] = 1;a[0][6] = 0; a[0][7] = 0;
		a[1][0] = 3; a[1][1] = 0; a[1][2] = 2; a[1][3] = 0; a[1][4] = 0; a[1][5] = 0;a[1][6] = 1; a[1][7] = 0;
		a[2][0] = 5; a[2][1] = 2; a[2][2] = 0; a[2][3] = 1; a[2][4] = 0; a[2][5] = 0;a[2][6] = 0; a[2][7] = 2;
		a[3][0] = 0; a[3][1] = 0; a[3][2] = 1; a[3][3] = 0; a[3][4] = 4; a[3][5] = 0;a[3][6] = 0; a[3][7] = 0;
		a[4][0] = 8; a[4][1] = 0; a[4][2] = 0; a[4][3] = 4; a[4][4] = 0; a[4][5] = 6;a[4][6] = 0; a[4][7] = 1;
		a[5][0] = 1; a[5][1] = 0; a[5][2] = 0; a[5][3] = 0; a[5][4] = 6; a[5][5] = 0;a[5][6] = 5; a[5][7] = 0;
		a[6][0] = 0; a[6][1] = 1; a[6][2] = 0; a[6][3] = 0; a[6][4] = 0; a[6][5] = 5;a[6][6] = 0; a[6][7] = 1;
		a[7][0] = 0; a[7][1] = 0; a[7][2] = 2; a[7][3] = 0; a[7][4] = 1; a[7][5] = 0;a[7][6] = 1; a[7][7] = 0;
		
		Teste teste = new Teste();
		teste.minimo(a, 4, 7);
		
	}
}
