 ＃第四次实验课 李灵臣 计G2020322084
## 1.实验要求
设计学生类（可利用之前的）；  

采用交互式方式实例化某学生；  

设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。  
## 2.实验内容
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。  

文件A包括两部分内容：  

一是学生的基本信息；  

二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：  
（1）每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”  

（2）允许提供输入参数，统计古诗中某个字或词出现的次数。  

（3）输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A。  

（4）考虑操作中可能出现的异常，在程序中设计异常处理程序。  

## 3.实验目的
（1）掌握字符串String及其方法的使用  

（2）掌握文件的读取/写入方法  

（3）掌握异常处理结构  
## 4.实验要求输出结果
输入：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续>

输出：  

汉皇重色思倾国，御宇多年求不得。  

杨家有女初长成，养在深闺人未识。  

天生丽质难自弃，一朝选在君王侧。  

回眸一笑百媚生，六宫粉黛无颜色。  

春寒赐浴华清池，温泉水滑洗凝脂。  

侍儿扶起娇无力，始是新承恩泽时。  

云鬓花颜金步摇，芙蓉帐暖度春宵。  

春宵苦短日高起，从此君王不早朝。  

…………

## 4.实验过程  
(1).创建了2个类：Student类和Homework类 
Student为学生类：设置了学生的姓名、性别、年龄。  
Homework主要内容有：可以输入学生的姓名、性别、年纪，并且可以输出、查询字符的个数。

（2）.首先通过获取文件的字节流，通过findword方法找到相应的字符，运用toCharArray方法获取输入字的信息，运用for循环进行遍历。而后运用if语句进行查询输入字的信息，  
最后运用System进行输出；在输入字的信息时，如果出现输入字不在文本内容中，显示异常。
 
## 5.实验核心代码  
```
//通过字节输入流获取文本信息
 OutputStream f = new FileOutputStream("F:\\javallc\\A.txt");
 OutputStreamWriter writer = new OutputStreamWriter(f, "UTF-8");

```
``` 
//获取文件的字节长度
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

```
```
//根据判断结果，进行添加“，” “。”。
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
```
```
System.out.println("输入第" + (i + 1) + "位博士薪水：");
            Scanner salary = new Scanner(System.in);
            int Dsalary = salary.nextInt();
            try{
            	if(Dsalary<0){
            	throw new Exception("输出错误！薪水不能为负！"); //异常显示
            }
        }
            catch(Exception e){
          	  System.out.println("发生异常："+e.getMessage()); 
          	  System.exit(1); //发生异常后，终止运行
          }

```
```

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
```
## 6.运行截图   
![alt console](http://m.qpic.cn/psc?/V50ghPAb3qpJGr4VGzMR1RNNj21NWrfC/ruAMsa53pVQWN7FLK88i5jW8Ia*kdlx8CDzdhcqS5x*EljdL9hIMXr9sUSHxixvGz4UYxlB4bC7KxkStL.HeZK5BCGXQN95QFVpktHwhoYM!/b&bo=oAH1AAAAAAADB3Y!&rf=viewer_4)  
![alt console](http://m.qpic.cn/psc?/V50ghPAb3qpJGr4VGzMR1RNNj21NWrfC/ruAMsa53pVQWN7FLK88i5iLJmj2lhP5AIh0dYPtxkb44xMpPrm*8FX*p.ntN7XvzCid9cWrYSpKoyTN62bmK.DrMd*m2yDr3YI4CgvBQ284!/b&bo=DgFbAQAAAAADB3c!&rf=viewer_4)  


## 7.编程感想  
1.通过编程掌握了如何使用输入字节流和输出字节流获取文本信息。    

2.通过查询和排错改错，知道了\\和\的作用。

3.通过for循坏if else 判断语句，可以使文本格式化输出。

4.在编程过程中出现了许多问题和报错，经过同学的帮助以及csdn的查询，逐步排错改错。
