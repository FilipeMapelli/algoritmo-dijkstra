package br.com.fms.grafos.util;

import org.springframework.stereotype.Repository;

@Repository
public class Util {
	
	//convert array to array of array 
	public int[][] convertToMatriz(int[] v, int size){
		
		int value;
		int a[][] = new int[size][size];
		int indice = 0;
		
		for(int i=0; i < size; i++){
			for(int j=0; j < size; j++){
				if(indice < v.length){
					value = v[indice];
					a[i][j] = value;
					indice++;
				}
			}
		}
		return a;
	}
	
	public boolean caminhoEuleriano(int a[][], int size) {
		
		int total = 0;
		int row = 0;
		int grau;
		
		while (total <= 2 & row < size) {
			grau = 0;
			for (int col = 0; col < size; col++) {
				grau += a[row][col];
			}
			if ((grau % 2) != 0) { // function odd
				total += 1;
			}
			row += 1;
		}
		if (total > 2) {
			return false;
		} else {
			return true;
		}
	}
}
