package problem04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int[] right = new int[18];
		Random rd = new Random();
		int size =0;
		ArrayList<Double> time = new ArrayList<>();
		ArrayList<Integer> sucCnt = new ArrayList<>();
		Map<String, Object> map  = new HashMap<String, Object>();
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
			map.put(Integer.toString(size++),(( end - start )/1000.0)+success);
			System.out.println("게임을 계속하겠습니까? y/n");
			if(sc.nextLine().equalsIgnoreCase("N"))break;
		}
		
		Iterator it = sortByValue(map).iterator();
		int id =1;
		while(it.hasNext()) {

            int temp = Integer.parseInt((String)it.next());
            System.out.println((id++)+" : "+sucCnt.get(temp)+"  /  : "+time.get(temp));
        }
	}
	
	public static List sortByValue(final Map map) {

	        List<String> list = new ArrayList();
	        list.addAll(map.keySet());
	        Collections.sort(list,new Comparator() {
	            public int compare(Object o1,Object o2) {
	                Object v1 = map.get(o1);
	                Object v2 = map.get(o2);
	                return ((Comparable) v2).compareTo(v1);

	            }
	        });
	        return list;
	    }
}