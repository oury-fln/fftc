import java.awt.Frame;

public class PathChooer {
    public static void main(String[] args) {
        Frame f = new Frame();//构造一个最初不可见的 Frame 新实例（）。

        f.setTitle("FFT");//设置窗口标题内容
        f.setSize(500, 400);//设置窗口大小,宽度500，高度400
        f.setLocation(300, 200);//设置窗口位置为距离屏幕左边水平方向300，上方垂直方向200
        f.setVisible(true);//设置窗体可见。
    }
}
