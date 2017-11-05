package br.com.fms.grafos.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

@Repository
public class CaminhoMinimo {

	private static Set<Integer> in;
	private static int z, p; // temporary vertices
	private static List<Integer> d;
	private static List<Integer> s;
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

	public String minimo(int a[][], int x, int y) {
		
		in = new HashSet<Integer>();
		d = new ArrayList<Integer>();
		s = new ArrayList<Integer>();

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
			
		}
		
		z = y-1;
		
		String result = "Em ordem inversa o caminho é : "+y+"; ";
		while (z != x-1){
			result += ""+(s.get(z)+1)+"; ";
			z = s.get(z);
		}
		result += "\nA distância é: "+d.get(y-1);
		
		return result;
		
	}
		
	//get lowest value in d
	private static int lowValue(){
		
		SortedSet<Integer> notIn = new TreeSet<Integer>();
		for(int i=0; i < d.size(); i++){
			if (!in.contains(i) && d.get(i)!=0){ //replaces infinity to zero
				notIn.add(d.get(i));  
			}
		}
		System.out.println("notIN = "+notIn);
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
}

