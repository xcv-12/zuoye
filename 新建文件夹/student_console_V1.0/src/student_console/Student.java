package student_console;

import java.io.Serializable;

public class Student implements Serializable{
	private String xuehao;
	private String name;
	private float hMath;
	private float Java;
	private float lMath;
	private int Ave;   //平均分   未打印.
	private float Total;
	
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float gethMath() {
		return hMath;
	}
	public void sethMath(float hMath) {
		this.hMath = hMath;
	}
	public float getJava() {
		return Java;
	}
	public void setJava(float java) {
		Java = java;
	}
	public float getlMath() {
		return lMath;
	}
	public void setlMath(float lMath) {
		this.lMath = lMath;
	}
	public float getAve() {
		return Ave;
	}
	public void setAve(i ave) {
		Ave = ave;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	@Override
	public String toString() {
		return "Student [学号=" + xuehao + ", 姓名=" + name + ", 高数=" + hMath + ", Java=" + Java + ", 离散="
				+ lMath + ",  总分=" + Total + "]";
	}
	
}
