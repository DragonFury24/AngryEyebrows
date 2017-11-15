import java.io.File;

public class AngryEyebrows {
    public static void main(String[] args) {
        Picture picture = new Picture(new File("src").exists() ? "src/angrybirdwithouteyebrow.jpg" : "angrybirdwithouteyebrow.jpg");
        picture.show();
        Paint painter = new Paint(picture);

        for (int i = 338; i <= 347; i++)
            painter.setPixelColor(i, 273);

        painter.drawLine(200, 200, 450, 450);
        picture.explore();         //allows to search color by pixel

    }
}