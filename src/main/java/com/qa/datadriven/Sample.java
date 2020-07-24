package com.qa.datadriven;

import java.io.IOException;

public class Sample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				String s=DataDriven.getDataFromExcel("Login", i, j);
				System.out.println(s);
			}
		}
	}

}
