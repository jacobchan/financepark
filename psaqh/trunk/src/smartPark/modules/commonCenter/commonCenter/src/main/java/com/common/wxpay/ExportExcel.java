package com.common.wxpay;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

import com.common.MemberManager.entity.MemberInformation;
/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 转载时请保留以下信息，注明出处！
 * 
 * @author leno
 * @version v1.0
 * @param <T>
 *            应用泛型，代表任意一个符合javabean风格的类
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 *            byte[]表jpg格式的图片数据
 */
@SuppressWarnings({ "deprecation" })
public class ExportExcel<T> {
	public void exportExcel(String[] headers, List<T> dataset,
			OutputStream out, String title) {
		exportExcel(headers, dataset, out, "yyyy-MM-dd", title);
	}

	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * @param title
	 *            表格标题名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 */
	public void exportExcel(String[] headers,
			List<T> dataset, OutputStream out, String pattern, String title) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short)30);
		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("企业通讯录名单！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("企业公园");

		// 产生表格标题行
		HSSFRow rowm = sheet.createRow(0);
		HSSFCell cellTiltle = rowm.createCell(0);
		// sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面 - 可扩展】
		HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);// 获取列头样式对象
		HSSFCellStyle styles = this.getStyle(workbook); // 单元格样式对象
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 3));
		cellTiltle.setCellStyle(columnTopStyle);
		cellTiltle.setCellValue(title);

		// 创建字体  
        HSSFFont ftRed = workbook.createFont();
        ftRed.setStrikeout(true); 
        ftRed.setColor(HSSFColor.RED.index);
        ftRed.setFontHeightInPoints((short) 12);
		// 产生表格标题行
		HSSFRow row = sheet.createRow(2);
		row.setHeight((short)506);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i, HSSFCell.CELL_TYPE_STRING);
			HSSFRichTextString textString = new HSSFRichTextString(headers[i]);
			textString.applyFont(ftRed);
			cell.setCellValue(textString);
			cell.setCellStyle(styles);
		}

		// 遍历集合数据，产生数据行
		// 将查询出的数据设置到sheet对应的单元格中
		for (int i = 0; i < dataset.size(); i++) {
			HSSFRow rows = sheet.createRow(i + 3);// 创建所需的行数
			rows.setHeight((short)1012);
			MemberInformation m = (MemberInformation)dataset.get(i);
			
			HSSFCell cell0 = rows.createCell(0, HSSFCell.CELL_TYPE_STRING);
			if (!"".equals(m.getMemberHeadPortrait()) && m.getMemberHeadPortrait() != null) {
				cell0.setCellValue(m.getMemberHeadPortrait());
			}else{
				cell0.setCellValue("");
			}
			cell0.setCellStyle(styles);
			
			HSSFCell cell1 = rows.createCell(1, HSSFCell.CELL_TYPE_STRING);
			if (!"".equals(m.getMemberName()) && m.getMemberName() != null) {
				cell1.setCellValue(m.getMemberName());
			}else{
				cell1.setCellValue("");
			}
			cell1.setCellStyle(styles);
			
			HSSFCell cell2 = rows.createCell(2, HSSFCell.CELL_TYPE_STRING);
			if (!"".equals(m.getMemberPhoneNumber()) && m.getMemberPhoneNumber() != null) {
				cell2.setCellValue(m.getMemberPhoneNumber());
			}else{
				cell2.setCellValue("");
			}
			cell2.setCellStyle(styles);
			
			HSSFCell cell3 = rows.createCell(3, HSSFCell.CELL_TYPE_STRING);
			if (!"".equals(m.getMemberDescribe2()) && m.getMemberDescribe2() != null) {
				cell3.setCellValue(m.getMemberDescribe2());
			}else{
				cell3.setCellValue("");
			}
			cell3.setCellStyle(styles);
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 列头单元格样式
	 */
	public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
		// 设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体大小
		font.setFontHeightInPoints((short) 12);
		// 字体加粗
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体名字
		font.setFontName("Courier New");
		// 设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 在样式用应用设置的字体;
		style.setFont(font);
		// 设置自动换行;
		style.setWrapText(false);
		// 设置水平对齐的样式为居中对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		return style;

	}

	/*
	 * 列数据信息单元格样式
	 */
	public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
		// 设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体大小
		 font.setFontHeightInPoints((short) 10);
		// 字体加粗
//		 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体名字
		font.setFontName("Courier New");
		// 设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 在样式用应用设置的字体;
		style.setFont(font);
		// 设置自动换行;
		style.setWrapText(true);
		// 设置水平对齐的样式为居中对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		return style;
	}
}