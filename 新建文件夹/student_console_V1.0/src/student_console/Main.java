package student_console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	//private static List<Student> list = new ArrayList<Student>();
    private static List <Student> list = null;
	public static void main(String[] args) throws Exception  {
        init();
		createFace();
	}

    
	
    //界面
	public static void createFace() throws Exception {
		int select = 0;

		while(true) {
			System.out.println("                              ");
			System.out.println("	  		**===========请选择:==========**");
			System.out.println(" 				1: 增加一条学生数据");
			System.out.println(" 				2: 更新一条学生数据");
			System.out.println(" 				3: 查询一条学生数据");
			System.out.println(" 				4: 删除一条学生数据");
			System.out.println(" 				5: 排序学生成绩表单");
			System.out.println(" 				6: 显示所有学生数据");
			System.out.println(" 				7:   学生数据存档");
			select = sc.nextInt();
			switch(select) {
			case 1:saveStudent();break;
			case 2:updateStudent();break;
			case 3:getStudent();break;
			case 4:deleteStudent();break;
			case 5:listSort();break;
			case 6:listStudent();break;
			case 7:SaveDataUtils.saveObject(list);   System.out.println("OK!");
			}
		}
	}

    //1.添加    **链表,   键入,储存,**显示
    public static void saveStudent() {
    	float temp = 0;  
    	Student student = new Student();

    	System.out.println("请输入学号");
    	student.setXuehao(sc.next());
    	System.out.println("请输入姓名");
    	student.setName(sc.next());
    	System.out.println("请输入高数");
    	student.sethMath(sc.nextFloat());
    	System.out.println("请输入java");
    	student.setJava(sc.nextFloat());
    	System.out.println("请输入离散");
    	student.setlMath(sc.nextFloat());

    	temp += student.gethMath();
    	temp += student.getJava();
    	temp += student.getlMath();
    	student.setAve(temp/3);
    	student.setTotal(temp);
    	
    	list.add(student);
    } 
   
    //2.更新
    public static void updateStudent(){
        String xuehao ="";
        float score = 0;
        Student temp =null;
        System.out.println("请输入学生学号或进行修改");
        xuehao = sc.next();

        if((temp = findStudentByInput(xuehao)) == null){
            System.out.println("查无此信息");
        }else{
            System.out.println("请输入学号");
            temp.setXuehao(sc.next());
            System.out.println("请输入姓名");
            temp.setName(sc.next());
            System.out.println("请输入高数");
            temp.sethMath(sc.nextFloat());
            System.out.println("请输入java");
            temp.setJava(sc.nextFloat());
            System.out.println("请输入离散");
            temp.setlMath(sc.nextFloat());

            score += temp.gethMath();
            score += temp.getJava();
            score += temp.getlMath();
            
            temp.setAve(score/3);
            temp.setTotal(score);

            System.out.println("修改成功");
        }
    }
    
    //3.查询
    public static void getStudent(){
        String xuehao ="";
        Student temp =null;
        System.out.println("请输入学生学号或姓名进行查找");
        xuehao = sc.next();

        if((temp = findStudentByInput(xuehao)) == null){
            System.out.println("查无此信息");
        }else{
            System.out.println(temp.toString());
        }
    }
    
    //4.删除
    public static void deleteStudent(){
        String name = "";
        Student temp = null;System.out.println("请输入学生学号或姓名进行删除");
        name = sc.next();
        if((temp=findStudentByInput(name)) ==null){
            System.out.println("查无此信息");
        }else{
            list.remove(temp);
            System.out.println("删除成功");
        }
    }
    
    //5.排序***升序与降序未完成
    public static void listSort() {
    	Collections.sort(list,new Comparator<Student>() {
    		//o1.getTotal() - o2.getTotal() 升序
    		//o2.getTotal() - o1.getTotal() 降序
			@Override
			public int compare(Student o1, Student o2) {
				
				return (int)(o1.getTotal() - o2.getTotal());
			}
    		
    	});
    	System.out.println("排序完成");
    	listStudent();
    }
    
    //6.显示
    public static void listStudent() {
    	System.out .println("----学生成绩表--");
    	for(Student student : list) {
    		
    		System.out.println(student.toString());
    	}
    	
    }
    //***成绩分析***未完成
    public static void analyzeStudent(){
    	
    	System.out.println("及格率: 高数为:  , java为   ,离散为");
    	System.out.println("优秀人数: 高数为: ,java为  ,离散为 ");

    }
    
    
    //封装方法 (用学号或姓名查找指定学生并且返回该对象)
    public static Student findStudentByInput(String input){
        Student target = null;
        for(Student student : list){
            if(input.equals(student.getXuehao())){
                target = student;
                break;
            }
            if(input.equals(student.getName())) {
            	target = student;
                break;
            }
        }
        return target;
    }
    
    
    
  //储存 用init方法 ,反序列化
    public static void init () throws Exception{

        if(SaveDataUtils.readObject()!=null){
            list = (ArrayList<Student>)SaveDataUtils.readObject();
        }else{
            list = new ArrayList<Student>();
        }

    }
	

}

