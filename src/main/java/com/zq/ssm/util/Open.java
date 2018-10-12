package com.zq.ssm.util;
/**
 * 二维码解析类
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public  class Open {


	public static  String openTwo(String filePath) {
	    String path = "D:/temp/pic/"+filePath+".jpg";
		Result result=null;
		System.out.println("-----------------------path----------------------"+path);
		try {
            MultiFormatReader formatReader = new MultiFormatReader();
             //filePath = "E:/images/00002.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer  binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            result = formatReader.decode(binaryBitmap,hints);

            System.out.println("result = "+ result.toString());
            System.out.println("resultFormat = "+ result.getBarcodeFormat());
            System.out.println("resultText = "+ result.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
		 return result.toString();
	}

    public static  void CreateCode(String content, HttpServletRequest request) {
        int width = 300;
        int height = 300;
        String formate = "png";
        content = "123456";

        // 定义二维码参数

        Map hints;
        hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN,2);

        // 生成二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            String realPath = request.getServletContext().getRealPath("/")+"upload";
            String random = (int) Math.random()+"";
            File file = new File(realPath+ "//" + random+".jpg");
            MatrixToImageWriter.writeToFile(bitMatrix,formate,file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
