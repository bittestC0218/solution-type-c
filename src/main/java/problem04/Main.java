package problem04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int[] right = new int[18];
		Random rd = new Random();
		ArrayList<Double> time = new ArrayList<>();
		ArrayList<Integer> sucCnt = new ArrayList<>();
		ArrayList<Double> sum = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		for(int i=0;i<18;i++) {
			right[i] = rd.nextInt(9)+1;
			if(i!=0 && i%2==1) {
				while(right[i]==right[i-1]) {right[i] = rd.nextInt(9)+1;}
			}
		}

		System.out.println("===================랜덤문제===================");
		for(int i=1;i<=9;i++) {
			System.out.println(i+" x "+right[i]+", "+i+" x "+right[2*i-1]);
		}

		System.out.println("===================랜덤제시===================");
		while(true) {
			int cnt = 0;
			int[] indexAry = new int[18];
			Arrays.fill(indexAry,-1);
			int success = 0;

			long start = System.currentTimeMillis(); //시작하는 시점 계산
			while(cnt<18) {

				int index = rd.nextInt(18);
				while(Arrays.asList(indexAry).contains(index))index=rd.nextInt(18);
				int left=-1;
				indexAry[cnt]=index;

				left=(index/2)+1;

				System.out.println((++cnt)+".   "+left+" x "+right[index]+" ?");

				int ans = Integer.parseInt(sc.nextLine());
				if(ans==(left*right[index]))success++;
			}

			long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
			time.add((( end - start )/1000.0)); 
			sucCnt.add(success);
			sum.add((( end - start )/1000.0)+success);
			System.out.println("게임을 계속하겠습니까? y/n");
			if(sc.nextLine().equalsIgnoreCase("N"))break;
		}
		
		Collections.sort(sum);
		
		for(int i=0;i<sum.size();i++) {
			System.out.println((i+1)+" : "+sucCnt.get(i)+"  /  : "+time.get(i));
		}

	}
}