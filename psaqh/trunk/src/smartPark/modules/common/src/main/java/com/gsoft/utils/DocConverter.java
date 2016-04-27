package com.gsoft.utils;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;
 /**
  * 文档转pdf浏览类
  * @author xtc
  *
  */
public class DocConverter {
    private static final int environment = 0;// 环境1：windows,2:linux(涉及pdf2swf路径问题)
    private static  OfficeManager officeManager;
    private static String OPEN_OFFICE_HOME = "";
    private static int OPEN_OFFICE_PORT[] = {8100};
    private String fileString;
    private String outputPath = "";// 输入路径，如果不设置就输出在默认位置
    private  String fileName;
    private File pdfFile;
    private  File swfFile;
    private File docFile;
 
    public DocConverter(String fileString) {
        ini(fileString);
    }
    //读取当前操作系统
    public static int getOcName(){
	    String osName = System.getProperty("os.name");
	    String ostype = "";
	    if (Pattern.matches("Linux.*", osName)) {
	        ostype="2";
	    } else if (Pattern.matches("Windows.*", osName)) {
	    	ostype="1";
	    }
		return Integer.parseInt(ostype);
    }
    /*
     * 重新设置 file @param fileString
     */
    public void setFile(String fileString) {
        ini(fileString);
    }
 
    /*
     * 初始化 @param fileString
     */
    private void ini(String fileString) {
        this.fileString = fileString;
        fileName = fileString.substring(0, fileString.lastIndexOf("."));
        docFile = new File(fileString);
        pdfFile = new File(fileName + ".pdf");
        swfFile = new File(fileName + ".swf");
    }
 
    /*
     * 操作系统安装openOffice路径
     */
    public static String getOfficeHome() {
    	String offpath = "";
        if (getOcName()==2) {
        	offpath = "/opt/openoffice4";
        } else if (getOcName()==1) {
        	offpath = "C:\\program Files (x86)\\OpenOffice.org 3";
        }
        return offpath;
    }
    /*
     * 操作系统安装SWFTools路径
     */
    public String getSWFToolsHome() {
        String swfpath = "";
        if (getOcName()==2) {
        	swfpath = "pdf2swf ";
        } else if (getOcName()==1) {
        	swfpath = "F:\\SWFTools\\pdf2swf.exe "; 
        }
        return swfpath;
    }
    
    
    /*
     * 转为PDF @param file
     */
    private void doc2pdf() throws Exception {
        if (docFile.exists()) {
            if (!pdfFile.exists()) {
            	/*String officeHome = getOfficeHome();
            	String OpenOffice_HOME = officeHome;//这里是OpenOffice的安装目录, 在我的项目中,为了便于拓展接口,没有直接写成这个样子,但是这样是绝对没问题的  
                // 如果从文件中读取的URL地址最后一个字符不是 '\'，则添加'\'  
            	 String command ="";
            	if (getOcName()==2){
            		if (OpenOffice_HOME.charAt(OpenOffice_HOME.length() - 1) != '/') {  
            			OpenOffice_HOME += "/";  
            		}
            		command = OpenOffice_HOME  
                            + "program/soffice -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\"";  
            	}else if(getOcName()==1){
            		if (OpenOffice_HOME.charAt(OpenOffice_HOME.length() - 1) != '\\') {  
            			OpenOffice_HOME += "\\";  
            		}
            		command = OpenOffice_HOME  
                            + "program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\"";  
            	}*/
            	// 启动OpenOffice的服务
                //Process pro = Runtime.getRuntime().exec(command);  
                // connect to an OpenOffice.org instance running on port 8100  
               // OpenOfficeConnection connection = new SocketOpenOfficeConnection(  
                      //  "127.0.0.1", 8100);  
            	 System.out.println("进行文档转换转换:" + docFile + " --> " + pdfFile);
                long startTime = System.currentTimeMillis();
                startService();        
                OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
                converter.convert(docFile, pdfFile);
                System.out.println("转换完成.耗时" +( (System.currentTimeMillis() - startTime) / 60.0)+ "秒");
                stopService();
                System.out.println("运行结束"); 
                try {
                   // connection.connect();
                  //  DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
                  //  converter.convert(docFile, pdfFile);
                    System.out.println("****pdf转换成功，PDF输出：" + pdfFile.getPath() + "****");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("****swf转换器异常，读取转换文件失败****");
                    throw e;
                } 
            } else {
                System.out.println("****已经转换为pdf，不需要再进行转化****");
            }
        } else {
            System.out.println("****swf转换器异常，需要转换的文档不存在，无法转换****");
        }
    }
 
    /*
     * 转换成swf
     */
    private void pdf2swf() throws Exception {
        Runtime r = Runtime.getRuntime();
        if (!swfFile.exists()) {
            if (pdfFile.exists()) {
            	String SWFToolsHome= getSWFToolsHome();
                    try {
                        // 这里根据SWFTools安装路径需要进行相应更改
                        Process p = r.exec(SWFToolsHome + pdfFile.getPath() + " -o " + swfFile.getPath() + " -T 9");
                        System.out.print(loadStream(p.getInputStream()));
                        System.err.print(loadStream(p.getErrorStream()));
                        System.out.print(loadStream(p.getInputStream()));
                        System.err.println("****swf转换成功，文件输出：" + swfFile.getPath() + "****");
                        if (pdfFile.exists()) {
                            pdfFile.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
            } else {
                System.out.println("****pdf不存在，无法转换****");
            }
        } else {
            System.out.println("****swf已存在不需要转换****");
        }
    }
 
    static String loadStream(InputStream in) throws IOException {
        int ptr = 0;
        //把InputStream字节流 替换为BufferedReader字符流 2013-07-17修改
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder buffer = new StringBuilder();
        while ((ptr = reader.read()) != -1) {
            buffer.append((char) ptr);
        }
        return buffer.toString();
    }
 
    /*
     * 转换主方法
     */
    public boolean conver() {
        if (swfFile.exists()) {
            System.out.println("****swf转换器开始工作，该文件已经转换为swf****");
            return true;
        }
 
        if (getOcName()== 1) {
            System.out.println("****swf转换器开始工作，当前设置运行环境windows****");
        } else {
            System.out.println("****swf转换器开始工作，当前设置运行环境linux****");
        }
 
        try {
            doc2pdf();
            pdf2swf();
        } catch (Exception e) {
            // TODO: Auto-generated catch block
            e.printStackTrace();
            return false;
        }
 
        if (swfFile.exists()) {
            return true;
        } else {
            return false;
        }
    }
 
    /*
     * 返回文件路径 @param s
     */
    public String getswfPath() {
        if (swfFile.exists()) {
            String tempString = swfFile.getPath();
            tempString = tempString.replaceAll("\\\\", "/");
            return tempString;
        } else {
            return "";
        }
    }
 
    /*
     * 设置输出路径
     */
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
        if (!outputPath.equals("")) {
            String realName = fileName.substring(fileName.lastIndexOf("/"), fileName.lastIndexOf("."));
            if (outputPath.charAt(outputPath.length()) == '/') {
                swfFile = new File(outputPath + realName + ".swf");
            } else {
                swfFile = new File(outputPath + realName + ".swf");
            }
        }
    }
 
    public static void stopService(){
        System.out.println("关闭office转换服务....");
        
        if (officeManager != null) {
            officeManager.stop();
        }
        
        System.out.println("关闭office转换成功!");
    }
    
    public static void startService(){
        DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
        String officeHome = getOfficeHome();
        try {
            System.out.println("准备启动安装在" + officeHome + "目录下的openoffice服务....");
            configuration.setOfficeHome(officeHome);//设置OpenOffice.org安装目录
            configuration.setPortNumbers(OPEN_OFFICE_PORT); //设置转换端口，默认为8100
            configuration.setTaskExecutionTimeout(1000 * 60 * 5L);//设置任务执行超时为5分钟
            configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);//设置任务队列超时为24小时
         
            officeManager = configuration.buildOfficeManager();
            officeManager.start();    //启动服务
            System.out.println("office转换服务启动成功!");
        } catch (Exception ce) {
            System.out.println("office转换服务启动失败!详细信息:" + ce);
        }
    }
    
    
    public static  void getSwfPath(String path) {
        DocConverter d = new DocConverter(path);
        d.conver();     
    }
}