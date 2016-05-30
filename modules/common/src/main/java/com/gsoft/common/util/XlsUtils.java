/**
 * 
 */
package com.gsoft.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.util.PropertyUtils;



public class XlsUtils {
	
	public static Object parseValue(Cell cell) {
		if(cell==null)
			return "";
		
		int cellType = cell.getCellType();
		Object value = "";
		switch(cellType){
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value = cell.getBooleanCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				value = cell.getNumericCellValue();
				break;
			default:
				value = "";
				break;
		}
		
		return value;
	}
	
	/**excel文件按对应属性保存到record中
	 * @param in
	 * @param properties
	 * @return
	 */
	public static List<Record> buildRecords(InputStream in,Map<String,String> properties){
		List<Record> records = new ArrayList<Record>();

		Workbook wb = null;
		try {
			try {
			//	fs = new POIFSFileSystem(in);
				wb = new HSSFWorkbook(in);
			} catch (OfficeXmlFileException e) {
				wb = new XSSFWorkbook(in);
//				wb = WorkbookFactory.create(in);
			}
			parseWorkbook(wb, records, properties);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusException("读取模板文件异常.");
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			
		}
		return records;
	}
	
	public static void parseWorkbook(Workbook wb,List<Record> records,Map<String,String> properties){
		Sheet sheet = wb.getSheetAt(0); 
		if (wb != null) {
			sheet = wb.getSheetAt(0);
			int rowSize = sheet.getPhysicalNumberOfRows();
			List<String> header = new ArrayList<String>(rowSize);
			for (int i = 0; i < rowSize; i++) {
				if(i==0){
					Row headRow = sheet.getRow(0);
					if(headRow!=null){
						for (int j = 0; j < headRow.getLastCellNum(); j++) {
							header.add(getEntryKey(properties,parseValue(headRow.getCell(j)).toString()));
						}
					}
				}else{
					Row row = sheet.getRow(i);
					if(null!=row){
						Record record = new Record();
						for (int x = 0; x < row.getLastCellNum(); x++) {
							record.put(header.get(x), parseValue(row.getCell(x)).toString());
						}
						records.add(record);
					}
				}
			}
				
		}
	}
	
	/**
	 * @param file
	 * @param properties 实体属性与 excel头名称对应
	 * @return
	 */
	public static List<Record> buildRecords(File file,Map<String,String> properties){
		try {
			return buildRecords(new FileInputStream(file), properties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Record>();
	}
	
	public static String getEntryKey(Map<String, String> properties, String value) {
		for(Map.Entry<String, String> entry:properties.entrySet()){
			if(value.equals(entry.getValue())){
				return entry.getKey();
			}
		}
		return "";
	}
	
	/**导出
	 * @param recods
	 * @return
	 */
	public static void buildWorkbook(OutputStream out,List<Record> recods,List<String> header,File tempalateFile){
		if(recods!=null&&recods!=null){
			Workbook workbook = null;
	        try { 
	        	workbook = new XSSFWorkbook(new FileInputStream(tempalateFile));
	        } catch (Exception ex) { 
	        	try {
					workbook = new HSSFWorkbook(new FileInputStream(tempalateFile));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
	        } 
			CellStyle[] styles = { createStyle(workbook, true), createStyle(workbook, false) };
			Sheet sheet = workbook.getSheetAt(0);
			for(int i=0;i<recods.size();i++){
				Row row = sheet.createRow(i+1);
				 for(int j=0;j<header.size();j++){
					Object value = PropertyUtils.getPropertyValue(recods.get(i), header.get(j));
					Cell cell = row.createCell(j);
					cell.setCellType(1);
				    cell.setCellValue(value != null ? value.toString() : "");
					cell.setCellStyle(styles[1]);
				 }
			}
			if(workbook!=null){
				try {
					workbook.write(out);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static CellStyle createStyle(Workbook workbook, boolean isFirstRow) {
	    CellStyle cellStyle = workbook.createCellStyle();
	    if (isFirstRow) {
	      cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
	      cellStyle.setFillPattern((short) 1);
	    }
	    cellStyle.setBorderLeft((short) 1);
	    cellStyle.setBorderTop((short) 1);
	    cellStyle.setBorderRight((short) 1);
	    cellStyle.setBorderBottom((short) 1);

	    return cellStyle;
	  }

	public static void main(String[] args) {
//		List<Record> records = getRecords(new File("C:\\Users\\ASUS\\Desktop\\entinfo.xlsx"), 3);
//		System.out.println(records);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "企业名称");
		map.put("addr", "企业地址");
		List<Record> records2 = buildRecords(new File("C:\\Users\\ASUS\\Desktop\\entinfo.xlsx"), map );
		System.out.println(records2);
	}
}
