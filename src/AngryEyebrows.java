import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class AngryEyebrows {
    public static void main(String[] args) {
        Picture picture = new Picture(new File("src").exists() ? "src/angrybirdwithouteyebrow.jpg" : "angrybirdwithouteyebrow.jpg");
        picture.show();
        Paint painter = new Paint(picture);

        for (int i = 338; i <= 347; i++)
            painter.setPixelColor(i, 273);

        painter.setStrokeWidth(20);
        painter.setColor(Color.YELLOW);
        painter.drawLine(new Point(255, 233), new Point(331, 265));
        painter.drawLine(new Point(343, 273), new Point(379, 243));
        painter.setColor(Color.BLUE);
        painter.drawRect(100, 100, 350, 200);
        picture.explore();                    //allows to search color by pixel

    }
}