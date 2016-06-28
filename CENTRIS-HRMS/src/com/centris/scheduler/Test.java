package com.centris.scheduler;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Test t=new Test();
		
		t.recurFunction(1, "Ratna");
	}

	
	
	public void recurFunction( int i, String str){
		
		
		boolean iSvalid = checkF(i);
		
		
		if(!iSvalid){
			
			i=i+1;
			recurFunction(i, str);
			
			System.out.println( i+" - "+str);
			
			
		}
        if(iSvalid){
			
			return ;		
		}
		
	}
	
	
	public boolean checkF(int j){
		
		if (j == 10){
			
			return true;
		}else
			return false;
	}
}
