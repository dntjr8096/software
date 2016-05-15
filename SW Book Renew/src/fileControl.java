

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;



class fileControl {
	
	private String fileName;
	private Scanner input=null;
	private String scanString = null;
	
	private makeTable tmpTable;
	
	fileControl(String fileName, makeTable opTable){
		this.fileName = fileName;
		this.tmpTable = opTable;
	}
	
	void read(){
		
		try {
			File file = new File(fileName);
			input = new Scanner(file);
		}
		catch(Exception e1) {
			System.out.println("File is not finded");
		}
		
		tmpTable.initialize();
		
	
		while(input.hasNext()){
			System.out.println(scanString);
			scanString = input.nextLine();
			
			tmpTable.addRow( scanString.split(":")[0].trim(), 
							scanString.split(":")[1].trim(), scanString.split(":")[2].trim(), 
							scanString.split(":")[3].trim());
			  
		}
	}
	
	void renewFile(){
		
		FileWriter fw;
		BufferedWriter bw = null;
		int row = tmpTable.getRowCount();
		int col = 4;
		int i,j;
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			
			for(i=0;i<row;i++){
				for(j=0;j<col;j++){
					String value = (String)(tmpTable.getValueAt(i, j));
					System.out.println(value);
					bw.write(value);
					if(j != col-1)
						bw.write(" : ");
				}
				bw.newLine();
			}
			bw.close();
		}
		catch(Exception e2) {
			System.out.println(e2);
		}
		
	}
	
}
	  

