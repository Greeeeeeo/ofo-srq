package com.zq.ssm.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建二维码
 */
public class CreateQRCode {
    public static void main(String[] args) {

        //createCode("090909");
        int width = 300;
        int height = 300;
        String formate = "png";
        String content = "444444";
        String pathname = "D:/temp/pic/" + content + "Cd.jpg";
        // String path = request.getSession().getServletContext().getRealPath("image/") + content + "Cd.jpg";
        // 定义二维码参数

        Map hints;
        hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);

        // 生成二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            File file = new File(pathname);

            MatrixToImageWriter.writeToFile(bitMatrix, formate, file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCode(String content, HttpServletRequest request) {
        int width = 300;
        int height = 300;
        String formate = "png";
        //String content = "444444";
        String pathname = "D:/temp/pic/" + content + "Cd.jpg";
        String path = request.getSession().getServletContext().getRealPath("image/") + content + "Cd.jpg";

        // 定义二维码参数

        Map hints;
        hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);

        // 生成二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            File file = new File(path);
            File file2 = new File(pathname);

            MatrixToImageWriter.writeToFile(bitMatrix, formate, file);
            MatrixToImageWriter.writeToFile(bitMatrix, formate, file2);

        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}