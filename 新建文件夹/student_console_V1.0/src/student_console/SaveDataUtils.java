package student_console;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveDataUtils {
	//保存对象,序列化
	private static String filePath = null;
	static{
        try{
            filePath = new File("").getCanonicalPath()+"/student.txt";
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void saveObject(Object object) throws Exception{
        ObjectOutputStream out = null;
        FileOutputStream fout = null;
        try{
            fout = new FileOutputStream(filePath);
            out = new ObjectOutputStream(fout);
            out.writeObject(object);
        }finally{
            fout.close();
            out.close();
        }
    }
    
    //读取对象,反序列化
    public static Object readObject() throws Exception{
        ObjectInputStream in = null;
        FileInputStream fin = null;
        Object object = null;
        try{
            fin = new FileInputStream(filePath);
            if(fin.getChannel().size() == 0){
                return null;
            }
            in = new ObjectInputStream(fin);
            object = in.readObject();
            return object;
        }finally{
            if(fin!=null){
                fin.close();
            }
            if(in!=null){
                in.close();
            }
        }
    }



}
