import java.awt.*;
import java.security.InvalidParameterException;

public class Paint {

    private Picture picture;

    private Color color = Color.BLACK;

    private int strokeWidth = 1;
    private int textSize = 1;

    /*
    Calculations for drawLine and other methods involving linear equations
     */
    private int slope;
    private int yIntercept;
    private int tangentSlope;
    private int tangentYIntercept;

    public Paint(Picture p) {
        picture = p;
    }

    public void drawCircle(int centerX, int centerY, int radius) {

    }

    public void drawLine(int startX, int startY, int endX, int endY) {
        slope = (endY - startY) / (endX - startX);
        yIntercept = startY - (startX * slope);
        tangentSlope = -1 / slope;
        tangentYIntercept = startY - (startX * tangentSlope);

        for (int x = startX; x < endX; x++) {
            for (int y = getLinearY(x); y < getLinearY(x) + getStrokeWidth(); y++) {
                picture.getPixel(x, y).setColor(color);
            }
        }
    }

    public void drawOval(int left, int top, int right, int bottom) {

    }

    public void drawPoint(int x, int y) {

    }

    public void drawRect(int left, int top, int right, int bottom) {
        for (int row = top; row <= bottom; row++) {
            for (int col = left; col <= right; col++) {
                picture.getPixel(row, col).setColor(color);
            }
        }
    }
    public int getTextSize() {
        return textSize;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setPicture(Picture p) {
        picture = p;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void setPixelColor(int x, int y) {
        picture.getPixel(x, y).setColor(color);
    }

    public void setStrokeWidth(int sW) {
        strokeWidth = sW;
    }

    public void setTextSize(int tS) {
        textSize = tS;
    }

//    private int getXFromDistance() {
//        return Math.sqrt()
//    }

    private int getDistance(int x1, int y1, int x2, int y2) {
        return (int)Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    private int getLinearY(int x) {
        return x * slope + yIntercept;
    }

    private int getTangentY(int x) {
        return x * tangentSlope + tangentYIntercept;
    }

    private int getCircularY(int x, int radius, String sign) {
        int y = (int)Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));

        return sign.toLowerCase().startsWith("pos") ? y :
                sign.toLowerCase().startsWith("neg") ? -y : -1;
    }
}
