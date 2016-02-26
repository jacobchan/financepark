<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String jsonp = request.getParameter("data:jsonp");
	String fileName = request.getParameter("data:file");
	
	java.io.File file = new java.io.File("/Users/jack/Desktop/project/smartpart/smartPark/wars/smartPark-portal/src/main/webapp/jsonp/"+fileName);
	
	try {
		java.io.ByteArrayOutputStream byteOut = new java.io.ByteArrayOutputStream();
		java.io.InputStream in = new java.io.FileInputStream(file);
		int byteCount = 0;
		byte[] buffer = new byte[2048];
		int bytesRead = -1;
		while ((bytesRead = in.read(buffer)) != -1) {
			byteOut.write(buffer, 0, bytesRead);
			byteCount += bytesRead;
		}
		byteOut.flush();
		
		out.println(jsonp+"("+new String(byteOut.toByteArray(),"UTF-8")+");");
	} catch (java.io.FileNotFoundException e) {
		out.println(jsonp+"();");
	} catch (java.io.IOException e) {
		out.println(jsonp+"();");
	}	catch (Exception e) {
		out.println(jsonp+"();");
	}
	
%>