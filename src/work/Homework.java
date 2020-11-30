package work;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        System.out.println("输入学生名：");
        Scanner scan1 = new Scanner(System.in);
        String name = scan1.nextLine();
        System.out.println("输入学生性别：");
        Scanner scan2 = new Scanner(System.in);
        String sex = scan2.nextLine();
        System.out.println("输入学生年纪：");
        Scanner scan3 = new Scanner(System.in);
        String age = scan3.nextLine();
        Student student = new Student(name, sex, age);
       //查询字符
        Homework hm=new Homework();
        System.out.println("请输入要查询的数据");
        Scanner scan4 = new Scanner(System.in);
        String word=scan4.next();
        if(word.length()>1&&word.length()!=0){
        	hm.findword(word, hm.findtxt());
        }else{
        	char[] w=word.toCharArray();
        	for(char c:w){
        		hm.findword(c,hm.findtxt());
        	}
        	
        }
        
        
        System.out.println("-----------------------");
        System.out.println("学生信息：");
        System.out.println(student.toString());
        System.out.println("-----------------------");
        try {
            //数据读取
            InputStream fread = new FileInputStream("F:\\javallc\\B.txt");
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(fread));
            String[] arr = br.readLine().split("");
            br.close();
            fread.close();
            //数据格式后输出
            OutputStream f = new FileOutputStream("F:\\javallc\\A.txt");
            OutputStreamWriter writer = new OutputStreamWriter(f, "UTF-8");
            List<String> aa = new ArrayList<String>();
            String temp = "";
            for (int x = 0; x < arr.length; x++) {
                if (arr[x].equals("<")){
                    break;
                }
                temp += arr[x];
                if ((x + 1) % 7 == 0) {
                    aa.add(temp);
                    temp = "";
                }
            }
            for (int i = 0; i < aa.size(); i++) {
                writer.append(aa.get(i));
                if ((i + 1) % 2 == 1){
                    writer.append("，");
                }else {
                    writer.append("。");
                    writer.append("\r\n");
                }
            }
            writer.append("………………");
            writer.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	   public void findword(char word,String str){
			char c[]=str.toCharArray();				//将字符串变为字符数组
			int sum=0;								//声明整形变量
			for(int i=0;i<c.length;i++)
			{
				if(c[i]==word){
					sum++;
				}
			}
			System.out.println(word+"的个数："+sum);
	  }
	public void findword(String word,String str){
		int count = 0;
	  // 调用String类的indexOf(String str)方法，返回第一个相同字符串出现的下标
		while (str.indexOf(word) != -1) {
	            // 如果存在相同字符串则次数加1
	            count++;
	           // 调用String类的substring(int beginIndex)方法，获得第一个相同字符出现后的字符串
	            str = str.substring(str.indexOf(word)
	            + word.length());
	
		}
	       System.out.println(word+"出现的次数为："+count);
	 }
	//获取查询文本内容
	public String findtxt() {
			String s = null;
		   File file=new File("F:\\javallc\\A.txt");//同样文件路径要改注意斜线方向
		   if(!file.exists()) {
			   System.err.println("对不起指定文件不存在。。。。");
		   }else {
			   try {
					Reader rd=new FileReader(file);
					char[] data = new char[1024*1024];
					int len;
					while((len=rd.read(data))!=-1) {
						 s = new String(data,0,len);			//根据读取文件的内容创建String 对象
						//System.out.println(s);				//输出读取内容
						
						}
					}catch (Exception e) {
						// TODO: handle exception
					}
			   
		   }
		   //System.out.println(s);
		return s;
	}

}


