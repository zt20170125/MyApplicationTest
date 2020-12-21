package com.example.testu2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG="MonkeyTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //给第一个按钮设置点击事件
        findViewById(R.id.btn_start_test).setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v){
            execCommand("test132");
        }
    };

    private static StringBuilder sResult = new StringBuilder("");
    public static int execCommand(String command1) {
        command1="monkey --throttle 500 --ignore-crashes --ignore-timeouts --ignore-security-exceptions --ignore-native-crashes --monitor-native-crashes -v " +
                "-p com.android.contacts " +
                "-p com.android.dialer " +
                "-p com.android.calendar " +
                "-p com.mediatek.todos " +
                "-p com.android.deskclock " +
                "-p com.android.gallery3d " +
                "-p com.android.music " +
                "-p com.mediatek.filemanager " +
                "-p com.mediatek.videoplayer " +
                "-p com.android.settings " +
                "-p com.android.systemui "+
                "1000000";
        android.util.Log.i(TAG," MainActivity execCommand() command1="+command1);
        sResult.delete(0, sResult.length());
        Process process = null;
        try {
            //执行指令
            process = Runtime.getRuntime().exec(command1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (process == null) {
            return -1;
        }
        //
//        Matcher m = Pattern.compile("[0-9]").matcher(process.toString());
//        StringBuffer bf = new StringBuffer(64);
//        while (m.find()) {
//            bf.append(m.group());
//        }
//        savePid(Integer.parseInt(bf.toString(), 10));
//        //打印log的位置文件
//        String path ="/MonkeyTestResultERROR.txt";
//        String path2 ="/MonkeyTestResult.txt";
//        new StreamGobbler(process.getErrorStream(),"ERROR",path).start();
//        new StreamGobbler(process.getInputStream(), "STDOUT",path2).start();
        return 0;
    }
}
