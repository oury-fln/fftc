import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class MainWindow extends JFrame implements DocumentListener {
    //private static String path = "";
    //private static JTextField textField;
    //private static JTextArea textArea;
    private JButton button2;
    private JTextField textField;
    private JCheckBox checkBox;
    public static void main(String[] args) {
        new MainWindow().init();
    }
    public  void init() {
        JFrame f = new MainWindow();//构造一个最初不可见的 Frame 新实例
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        JButton button = new JButton();
        button2 = new JButton();
        checkBox = new JCheckBox();
        textField = new JTextField(15);
        JTextArea textArea = new JTextArea(15, 30);

        f.setTitle("FFT");//设置窗口标题内容
        f.setSize(500, 400);//设置窗口大小,宽度500，高度400
        f.setLocation(300, 200);//设置窗口位置为距离屏幕左边水平方向300，上方垂直方向200
        //f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));

        button.setText("打开文件夹");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int i = jFileChooser.showOpenDialog(null);
                if(i== jFileChooser.APPROVE_OPTION){ //打开文件
                    textField.setText(jFileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        checkBox.setText("包括子文件夹");

        button2.setText("开始计算");
        button2.setEnabled(false);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText() != "") {
                    ArrayList result = Main.c(textField.getText(), checkBox.isBorderPaintedFlat());
                    if (result.size() == 0) {
                        textArea.setText("未找到文件！");
                    } else {
                        textArea.setText("");
                        Iterator it = result.iterator();
                        while (it.hasNext()) {
                            textArea.append(it.next().toString());
                            textArea.append("\n");
                        }
                    }
                }
            }
        });

        Document document = textField.getDocument();
        document.addDocumentListener(this);
        panel1.add(button);
        panel1.add(checkBox);
        panel1.add(textField);
        panel1.add(button2);
        panel2.add(textArea);
        f.add(panel1, BorderLayout.NORTH);
        f.add(panel2);


        f.setVisible(true);//设置窗体可见。
    }
    public MainWindow() {

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        check();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        check();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        check();
    }
    public void check() {
        File file = new File(textField.getText());
        if (file.exists() && file.isDirectory()) {
            button2.setEnabled(true);
        } else {
            button2.setEnabled(false);
        }
    }
}
