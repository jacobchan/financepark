package com.gsoft.utils;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
 
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
 
public class DocConverter {
    private static final int environment = 1;// 环境1：windows,2:linux(涉及pdf2swf路径问题)
    private String fileString;
    private String outputPath = "";// 输入路径，如果不设置就输出在默认位置
    private  String fileName;
    private File pdfFile;
    private  File swfFile;
    private File docFile;
 
    public DocConverter(String fileString) {
        ini(fileString);
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
    public String getOfficeHome() {
        String osName = System.getProperty("os.name");
        if (Pattern.matches("Linux.*", osName)) {
            return "\\opt\\openoffice.org3";
        } else if (Pattern.matches("Windows.*", osName)) {
            return "C:\\program Files (x86)\\OpenOffice 4";
        }
        return null;
    }
    /*
     * 操作系统安装SWFTools路径
     */
    public String getSWFToolsHome() {
        String osName = System.getProperty("os.name");
        if (Pattern.matches("Linux.*", osName)) {
            return "\\opt\\openoffice.org3";
        } else if (Pattern.matches("Windows.*", osName)) {
            return "H:\\SWFTools\\pdf2swf.exe "; 
        }
        return null;
    }
    
    
    /*
     * 转为PDF @param file
     */
    private void doc2pdf() throws Exception {
        if (docFile.exists()) {
            if (!pdfFile.exists()) {
            	String officeHome = getOfficeHome();
            	String OpenOffice_HOME = officeHome;//这里是OpenOffice的安装目录, 在我的项目中,为了便于拓展接口,没有直接写成这个样子,但是这样是绝对没问题的  
                // 如果从文件中读取的URL地址最后一个字符不是 '\'，则添加'\'  
                if (OpenOffice_HOME.charAt(OpenOffice_HOME.length() - 1) != '\\') {  
                    OpenOffice_HOME += "\\";  
                }  
            	// 启动OpenOffice的服务  
                String command = OpenOffice_HOME  
                        + "program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\"";  
                Process pro = Runtime.getRuntime().exec(command);  
                // connect to an OpenOffice.org instance running on port 8100  
                OpenOfficeConnection connection = new SocketOpenOfficeConnection(  
                        "127.0.0.1", 8100);  
                try {
                    connection.connect();
                    DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
                    converter.convert(docFile, pdfFile);
                    System.out.println("****pdf转换成功，PDF输出：" + pdfFile.getPath() + "****");
                } catch (java.net.ConnectException e) {
                    // ToDo Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("****swf转换异常，openoffice服务未启动！****");
                    throw e;
                } catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
                    e.printStackTrace();
                    System.out.println("****swf转换器异常，读取转换文件失败****");
                    throw e;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }finally{  
                    if(connection!=null){  
                        // close the connection  
                        connection.disconnect();  
                    }  
                     // 关闭OpenOffice服务的进程    
                    if(pro!=null){  
                        pro.destroy();  
                    }  
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
 
        if (environment == 1) {
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
 
    public static  void getSwfPath(String path) {
        DocConverter d = new DocConverter("/smartPark/smartPark/wars/smartPark-web/src/main/webapp/upload/"+path);
        d.conver();
    }
}