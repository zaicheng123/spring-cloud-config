package cn.jbit.code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

@RequestMapping("/test3")
public class TwoCode {


    public  String  test03(HttpServletRequest request){

        System.out.printf ("生成二维码");
        final  int  width=300;
        final  int  height=300;
        final  String format="png";
        final  String content="我爱你，中国";
        //定义二维码参数
        HashMap hints=new HashMap();

        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");

        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

        hints.put(EncodeHintType.MARGIN,2);

        //生成二维码
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);

            Path file=new File(request.getSession().getServletContext().getRealPath("")+"static\\img.png").toPath();

            MatrixToImageWriter.writeToPath(bitMatrix,format,file);
        }catch (Exception e){

        }
        return  "index2";
    }






}
