package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图片处理工具类
 *
 * @author cc
 * @date 2019-08-12 22:41:41
 */

public class ImageUtils {

    BufferedImage bufferedImage;    //原始图片
    int width;
    int height;

    public static void saveSubImage(BufferedImage image, Rectangle subImageBounds, File subImageFile) throws IOException {
        if (subImageBounds.x < 0 || subImageBounds.y < 0 || subImageBounds.width - subImageBounds.x > image.getWidth()
        || subImageBounds.height - subImageBounds.y > image.getHeight()){
            return;
        }
        BufferedImage subImage = image.getSubimage(subImageBounds.x, subImageBounds.y, subImageBounds.width,
                subImageBounds.height);
        String fileName = subImageFile.getName();
        String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
        ImageIO.write(subImage, formatName, subImageFile);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\picture\\15221-106.jpg");
        BufferedImage srcImage = ImageIO.read(file);
        File tarImage = new File("F:\\picture\\15221-106-123456.jpg");
        Rectangle subImageBounds = new Rectangle(10,10,500,300);
        saveSubImage(srcImage,subImageBounds,tarImage);
    }
}
