import java.awt.*;

public class Paint {

    private Picture picture;

    private Color color = Color.BLACK;

    private int strokeWidth = 1;
    private int textSize    = 1;

    /*
    Calculations for drawLine and other methods involving linear equations
     */
    private double slope;
    private double yIntercept;
    private int    tangentSlope;
    private int    tangentYIntercept;

    public enum Style {
        FILL,
        STROKE,
        FILL_AND_STROKE
    }

    private Paint.Style style = Style.FILL;

    public Paint(Picture p) {
        picture = p;
    }

    public void drawCircle(int centerX, int centerY, int radius) {

    }

    public void drawColor(Color c) {
        for (int row = 0; row <= picture.getHeight(); row++)
            for (int col = 0; col <= picture.getWidth(); col++)
                picture.getPixel(row, col).setColor(c);
    }

    public void drawLine(int startX, int startY, int endX, int endY) {
        slope = ((double) endY - startY) / ((double) endX - startX);
        yIntercept = startY - (startX * slope);
//        tangentSlope = -1 / slope;
//        tangentYIntercept = startY - (startX * tangentSlope);

        if (style.equals(Style.FILL)) { //Draw a filled in line starting and stopping at specified coordinates
            for (int x = startX; x < endX; x++)
                for (int y = getLinearY(x); y < getLinearY(x) + getStrokeWidth(); y++)
                    picture.getPixel(x, y).setColor(color);
        } else if (style.equals(Style.STROKE))
            ;
        else if (style.equals(Style.FILL_AND_STROKE))
            ;
    }

    public void drawOval(int left, int top, int right, int bottom) {

    }

    public void drawPoint(int x, int y) {

    }

    public void drawRect(int left, int top, int right, int bottom) {
        if (style.equals(Style.FILL))
            for (int row = top; row <= bottom; row++)
                for (int col = left; col <= right; col++)
                    picture.getPixel(row, col).setColor(color);
        else if (style.equals(Style.STROKE))
            ;
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

    public void setStyle(Paint.Style s) {
        style = s;
    }

    public void setTextSize(int tS) {
        textSize = tS;
    }

//    private int getXFromDistance() {
//        return Math.sqrt()
//    }

    private int getDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private int getLinearY(int x) {
        return (int) (x * slope + yIntercept);
    }

    private int getTangentY(int x) {
        return x * tangentSlope + tangentYIntercept;
    }

    private int getCircularY(int x, int radius, String sign) {
        int y = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));

        return sign.toLowerCase().startsWith("pos") ? y : sign.toLowerCase().startsWith("neg") ? -y : -1;
    }
}
