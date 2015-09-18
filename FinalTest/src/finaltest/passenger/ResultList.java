package finaltest.passenger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.PriorityQueue;

import finaltest.policy.DefaultPolicy;

public class ResultList {
	private static PriorityQueue<Passenger> resultQueue = new PriorityQueue<Passenger>(50, new DefaultPolicy());
	
	public static void makeResultFile(){
		makeResultFile("result");
	}
	
	public static void makeResultFile(String fileName){
		
		try {
			String fileSrc = "/Users/NEXT/Documents/JAVA_Lab/FinalTest/src/data/"+ fileName +".csv";
			File csv = new File(fileSrc);
			BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
			
			bw.write("���̵�,�̸�,�ν������ð�,��ǥ�ҿ�ð�,�̵��ҿ�ð�,��߿�,������,���ð�,��߽ð�,�����ð�\n");
			bw.write(makeBody());
			bw.close();
			System.out.println("���� ���� �Ϸ�");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addResult(Passenger p){
		resultQueue.add(p);
	}
	
	public static void showResult(){
		System.out.println("============= ��� ��� =============");
		System.out.println("[���̵�]\t[�̸�]\t[�ν�����]\t[��ǥ�ҿ�]\t[�̵��ҿ�]\t[���ð�]\t[��߽ð�]\t[�����ð�]");
		Iterator<Passenger> iter = resultQueue.iterator();
		while(iter.hasNext()){
			Passenger c = iter.next();
			System.out.print(c);
			System.out.println("\t"+
				"  "+c.getReadyTime() +"��\t"+
				"  "+c.getLeaveTime() +"��\t"+
				"  "+c.getFinalTime()+"��"
			);
		}
	}
	
	public static int getNumOfResult(){
		int num=0;
		Iterator<Passenger> iter = resultQueue.iterator();
		while(iter.hasNext()){
			Passenger c = iter.next();
			num++;
		}
		return num;
	}
	
	private static String makeBody(){
		String result = "";
		Iterator<Passenger> iter = resultQueue.iterator();
		while(iter.hasNext()){
			Passenger c = iter.next();
			result += c.getResultData()+"\n";
		};
		return result;
	}
}
