import java.io.File;
import java.util.Arrays;

public class AngryEyebrows {
    public static void main(String[] args) {
        Picture picture = new Picture(new File("src").exists() ? "src/angrybirdwithouteyebrow.jpg" : "angrybirdwithouteyebrow.jpg");
        picture.show();
        Paint painter = new Paint(picture);

        for (int i = 338; i <= 347; i++)
            painter.setPixelColor(i, 273);

        painter.setStrokeWidth(50);
        painter.drawLine(200, 200, 450, 450);
        painter.drawLine(200, 450, 450, 200);
        painter.drawLine(200, 200, 450, 200);
        Arrays.sort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        picture.explore();                    //allows to search color by pixel

    }
}