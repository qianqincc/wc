package dazuoye1;
import java.io.*;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		System.out.print("please input the path");		
		Scanner pa= new Scanner(System.in);
		String path=pa.next();
		System.out.print("please input the filename");
		Scanner fn= new Scanner(System.in);
		String filename =fn.next();
		System.out.print("请输入 -c 或者 -w 或者 -l 或者 -a 或者-s ");	
		
		Scanner sc = new Scanner(System.in);
		String zhiling =sc.next();
		File file=new File(path,filename);
		File file2 = new File(path);
	
		
		if(zhiling.equals("-c")) 
		System.out.print("字符数为  "+count_char(file));
		
		if(zhiling.equals("-w"))
			System.out.print("词数为"+count_word(file));
		
		if(zhiling.equals("-l"))
			System.out.print("行数为"+count_line(file));

		if(zhiling.equals("-a"))
			code_line(file);
		
		if(zhiling.equals("-s"))
			readfile(file2);
		}

	
	
	static int count_char(File file) {
		Reader read=null;
		int char_num=0;
		try {
			 read =new InputStreamReader(new FileInputStream(file));
			 BufferedReader readfile= new BufferedReader(read);
	            int tempchar;
	            while ((tempchar=readfile.read()) != -1) {
	                if((char)tempchar!='\r'&&(char)tempchar!='\n'){
	                    char_num++;
	                }
	            }
	            readfile.close();
		}
        catch(Exception e){
            System.out.println("指定输入文件不存在");
        }    
        return char_num;
	}

	private static int count_word(File file){
        
        BufferedReader readfile=null;
      
        int w_num=0;
        try{
            readfile = new BufferedReader(new FileReader(file));
            String tempchar;
            while ((tempchar=readfile.readLine()) != null) {
            	String[] str=tempchar.split(" ");
            	w_num=str.length;
            }
            
            readfile.close();
        }
        catch(Exception e){
            System.out.println("指定输入文件不存在");
        }    
        return w_num;
    }
     
	
	private static int count_line(File file) {
		
		Reader read=null;
		try {
			read =new InputStreamReader(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		BufferedReader readfile= new BufferedReader(read);
		int line=1;
        int templine;
        try {
			while ((templine=readfile.read()) != -1) {
			    if((char)templine=='\n'){
			        line++;
			    }

                 }
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return line;
	}    
	
	
	@SuppressWarnings("resource")
	private static void code_line(File file)  {
		Reader read=null;
		 try {
			read =new InputStreamReader(new FileInputStream(file));
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		 BufferedReader readfile= new BufferedReader(read);
		 
		    int whiteLines = 0;
			int commentLines = 0;
			int normalLines = 0;

		 
		 boolean comment = false; 
			try { 
				readfile = new BufferedReader(new FileReader(file)); 
				String line = ""; 
				try { 
					while ((line = readfile.readLine()) != null) { 
						line = line.trim(); 
						if (line.matches("^[\\s&&[^\\n]]*$")) { 
							whiteLines++; 
						} else if (line.startsWith("/*") && !line.endsWith("*/")) { 
							commentLines++; 
							comment = true; 
						} else if (true == comment) { 
							commentLines++; 
							if (line.endsWith("*/")) { 
								comment = false; 
							} 
						} else if (line.startsWith("//")) { 
								commentLines++; 
						} else { 
							normalLines++; 
						} 
					} 
				} catch (IOException e) { 
						e.printStackTrace(); 
				} 
			} catch (FileNotFoundException e) { 
					e.printStackTrace(); 
			} 
		
			
			finally { 
				if (readfile != null) { 
					try { 
						System.out.println("空行数："+whiteLines);
						System.out.println("注释行数："+commentLines);
						System.out.println("代码行数："+normalLines);
						readfile.close(); 
						readfile = null; 
					} catch (IOException e) { 
						e.printStackTrace(); 
					} 
					
					
					
				} 
			
				
			} 

		
	}

    public static void readfile(File f){
        if(f!=null){
            if(f.isDirectory()){
                File[] fileArray=f.listFiles();
                if(fileArray!=null){
                    for (int i = 0; i < fileArray.length; i++) {
                        //递归调用
                        readfile(fileArray[i]);
                    }
                }
            }
            else{
                System.out.println(f);
            }
        }
    }


}
		   
		      

		
	
	

	
