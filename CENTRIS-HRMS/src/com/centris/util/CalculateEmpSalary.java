package com.centris.util;

import com.centris.util.SQLUtils.Employee;

public class CalculateEmpSalary {
	
	/*
	public static double calculateBasicDa(double ctc){
		
		double basicda=(ctc*Employee.BASI_DA)/100;
		
		return Math.round(basicda);
	}
	public static double calculateHra(double basicda){
			
			double hra=(basicda*Employee.HRA)/100;
			
			return Math.round(hra);
		}
	public static double calculatePfEmpr(double basicda){
		
		double pf_empr=0.0;
		
		if(basicda<=15000){
		
		 pf_empr=(basicda*Employee.PF_EMPR)/100;
		
		}else{
		
			 pf_empr=0.0;
		}
		
		return Math.round(pf_empr);
	}
	public static double calculatePfEmpy(double basicda){
		
		double pf_empy=0.0;
		
		if(basicda<=15000){
			
		 pf_empy=(basicda*Employee.PF_EMPY)/100;
		 
		}else{
			
			pf_empy=1800;
		}
		
		return Math.round(pf_empy);
	}
	public static double calculateEsiEmpr(double grosssalary){
		
		double esi_empr=0.0;
		
		if(grosssalary<=15000){
			
			 esi_empr=(grosssalary*Employee.ESI_EMPR)/100;
			 
		}
			return Math.round(esi_empr);
		}
	public static double calculateEsiEmpy(double grosssalary){
		
		double esi_empy=0.0;
		
		if(grosssalary<=15000){
			
		 esi_empy=(grosssalary*Employee.ESI_EMPY)/100;
		 
		}
		return Math.round(esi_empy);
	}
	
	public static double calculatePt(double basicda){
		
		double ptax=0.0;
		
		if(basicda<15000){
			
			ptax=150;
		 
		}else{
			
			ptax=200;
		}
		return ptax;
	}
	*/
	
	
	//new calculation for teliindia
	
			
			public static double calculateHra(double basicda,double percent){
				
				double hra=(basicda*percent)/100;
				
				return Math.round(hra);
			}
		public static double calculatePfEmpr(double basicda,double percent){
			
			
			 double	 pf_empr=(basicda*percent)/100;
			
			if(pf_empr>1800){
				
				pf_empr=1800;
			}
			return Math.round(pf_empr);
		}
		public static double calculatePfEmpy(double basicda,double percent){
				
			double	 pf_empy=(basicda*percent)/100;
			
			if(pf_empy>1800){
				
				pf_empy=1800;
			}
			
			return Math.round(pf_empy);
		}
		
		public static double calculateEsiEmpr(double grossSalary,double percent,double ctc_double){
			
			
			double	 esi_empr=0.0;
			
			if(grossSalary>15000){
				
				esi_empr=0.0;
			}
			
			else{
				
				esi_empr=(grossSalary*percent)/100;
				
			}
				 
			System.out.println("esi_empr ::: "+esi_empr);
			
			return Math.round(esi_empr);
			
			}
		
		public static double calculateEsiEmpy(double grossSalary,double percent,double ctc_double){
			
			double	 esi_empy=0.0;
			
			if(grossSalary>15000){
				
				esi_empy=0.0;
				
			}else{
				
				esi_empy=(grossSalary*percent)/100;
				
			}
				
			 
			 System.out.println("esi_empy ::: "+esi_empy);
			return Math.round(esi_empy);
		}

		public static double calculatePt(double basicda){
			
			double ptax=0.0;
			
			
			if(basicda<15000){
				
				ptax=0;
			 
			}else{
				
				ptax=200;
			}
			return ptax;
		}
	

}
