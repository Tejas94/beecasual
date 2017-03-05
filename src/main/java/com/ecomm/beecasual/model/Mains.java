package com.ecomm.beecasual.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;

public class Mains {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		if (N > 0 && N <= 10000) {
			int kk[] = new int[N];
			for (int i = 0; i < N; i++) {
				
				kk[i] = s.nextInt();
				
				
			}

			for (int j = 0; j < N; j++) {
				
				kk[j] = kk[j] - 1;
				

				if (kk[j] == 0) {
					System.out.println("No");
					break;
				} else {
					System.out.println("yes");
				}
			}
		}

	}

}
