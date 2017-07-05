package com.senmiao.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class CreateQRCode {

	public static String create(String url, String id) {

		String content = url;
		String date = DataUtil.getMonthDate();
		String path = "/alidata/server/www/view/files/" + date + "/";

		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
			File file1 = new File(path, id + ".jpg");
			if (!file1.exists())
				file1.mkdirs();
			MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop2 = DataUtil.loadProperty("server.properties");
		String server = prop2.getProperty("web.develop.server", "http://www.senmiao.com");
		
		return (server + "/files/" + date + "/" + id + ".jpg");
	}
	
}
