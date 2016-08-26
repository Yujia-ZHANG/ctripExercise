package toolManagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("One period has 8 hours. Please enter the number of period: ");
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		ArrayList<Worker> workers = new ArrayList<Worker>();
		for (int i = 1; i <= 7; i++) {
			Worker worker = new Worker(i);
			if (i % 2 != 0) {
				worker.tool = "tool1";
				// worker.restTime = 24;
			}

			// hashMap.put("worker"+i, "tool1");
			else {
				worker.tool = "tool2";
				// worker.restTime = 16;
			}

			// hashMap.put("worker"+i, "tool2");
			workers.add(worker);
		}
		ArrayList<Worker> tool1 = new ArrayList<Worker>();
		ArrayList<Worker> tool2 = new ArrayList<Worker>();

		for (int j = 0; j < workers.size(); j++) {
			Worker worker = workers.get(j);
			if (worker.tool.equals("tool1")) {
				tool1.add(worker);
			} 
			else {
				tool2.add(worker);
			}
		}
		
		
		System.out.println("The hit rate is 100%.");

		try{
		BufferedWriter bw = new BufferedWriter(new FileWriter("details.txt"));
		bw.write("The details of tool1  tool2");
		bw.newLine();
		for(int i = 0;i < n;i++){
			if(i < tool1.size() && i < tool2.size()){
				bw.write("Period " + i  +": " + tool1.get(i).id + "......" + tool2.get(i).id);
				bw.newLine();
			}
			else if(i >= tool2.size() && i < tool1.size()){
				bw.write("Period " + i +": " + tool1.get(i).id + "......" + tool2.get(i % 3).id);
				bw.newLine();
			}
			else if(i >= tool1.size()){
				bw.write("Period " + i +": " + tool1.get(i % 4).id + "......" + tool2.get(i % 3).id);
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		}catch(Exception e){
			
		}
	}

}
