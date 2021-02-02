package 其他;

//给你一个以 (radius, x_center, y_center) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2)，
// 其中 (x1, y1) 是矩形左下角的坐标，(x2, y2) 是右上角的坐标。
//如果圆和矩形有重叠的部分，请你返回 True ，否则返回 False 。
public class 划分区域 {

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        double dist = 0;
        if (x_center < x1 || x_center >x2){
            dist += Math.min( (x1 - x_center) * (x1 - x_center) ,(x2 - x_center) * (x2 - x_center) );
        }
        if (y_center < y1 || y_center >y2){
            dist += Math.min( (y1 - y_center) * (y1 - y_center) ,(y2 - y_center) * (y2 - y_center) );
        }
        return dist <= radius * radius;
    }
}
