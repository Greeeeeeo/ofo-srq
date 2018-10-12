package com.zq.ssm.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Liwei on 2016/8/7.
 * 解析二维码
 */
public class ReadQRCode {

    public static void main(String[] args) throws IOException, NotFoundException {

       MultiFormatReader formatReader = new MultiFormatReader();
        File file = new File("D:/temp/pic/1.jpg");
        BufferedImage image = ImageIO.read(file);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");

        Result result = formatReader.decode(binaryBitmap,hints);
        System.out.println("解析结果：" +result.toString());
        System.out.println("二维码格式类型：" +result.getBarcodeFormat());
        System.out.println("二维码文本内容：" +result.getText());
       // String s = Open.openTwo("1");
        System.out.println("____________________________");



    }



}