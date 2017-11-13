public class AngryEyebrows {
    public static void main(String[] args) {
        String fName = "src/angrybirdwithouteyebrow.jpg";
        Picture picture = new Picture(fName);
        picture.show();
        Paint painter = new Paint(picture);

        for (int i = 338; i <= 347; i++) {
            painter.setPixelColor(i, 273);
        }

        painter.drawLine(200, 200, 450, 450);
        picture.explore();         //allows to search color by pixel

    }
}