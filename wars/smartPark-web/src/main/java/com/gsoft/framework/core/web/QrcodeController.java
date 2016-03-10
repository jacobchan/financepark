package com.gsoft.framework.core.web;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
@Controller
@RequestMapping("/qrcode")
public class QrcodeController {
	@RequestMapping(value = "/showQrcode", method = { RequestMethod.POST, RequestMethod.GET })
	public void showQrcode(HttpServletResponse resp, String id) throws IOException {
		String url = "http://www.whtv.com.cn?id=" + id;
		if (url != null && !"".equals(url)) {
			ServletOutputStream stream = null;
			try {
				int width = 200;// 图片的宽度
				int height = 200;// 高度
				stream = resp.getOutputStream();
				QRCodeWriter writer = new QRCodeWriter();
				BitMatrix m = writer.encode(url, BarcodeFormat.QR_CODE, height, width);
				MatrixToImageWriter.writeToStream(m, "png", stream);
			} catch (WriterException e) {
				e.printStackTrace();
			} finally {
				if (stream != null) {
					stream.flush();
					stream.close();
				}
			}
		}
	}
}