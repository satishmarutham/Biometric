package com.centris.util;

public class AllowanceClaimByManager {

	public boolean getisConflict(String[] conflict_rows_array, String bioid) {
	
		for (int i = 0; i < conflict_rows_array.length; i++) {
		
			if(conflict_rows_array[i]!=""){
				if(Integer.parseInt(conflict_rows_array[i])==(Integer.parseInt(bioid))){
					
					return true;
				}
			}
			
		
				
		}
    	return false;
	}

}
