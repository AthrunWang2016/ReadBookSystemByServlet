package com.tool;
/**
 * 应该把错误信息记录到ini文件中
 * isPrintOut：true为记录,false为不记录
 * @author Administrator
 *
 */
public class SystemLogOut {

	private String logOut;
	private boolean isPrintOut = false;
	private static SystemLogOut systemLogOut = null;
	
	private SystemLogOut() {
		// TODO Auto-generated constructor stub
	}
	public static SystemLogOut getInstance() {
		if(systemLogOut == null){
			systemLogOut = new SystemLogOut();
		}
		return systemLogOut;
	}
	
	public void printOut(String outStr) {
		if(isPrintOut){
			System.out.println(outStr);
		}
	}
	public boolean isPrintOut() {
		return isPrintOut;
	}
	public void setPrintOut(boolean isPrintOut) {
		if(systemLogOut == null){
			systemLogOut = new SystemLogOut();
		}
		systemLogOut.isPrintOut = isPrintOut;
	}
	
}
