package tw.org.iii.shine03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private String strAnswer;
    private TextView mesg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.input);
        mesg = (TextView)findViewById(R.id.mesg);

        strAnswer = createAnswer(3);

    }

    public void guess(View v){
        String guessText = input.getText().toString();
        String result = checkAB(strAnswer,guessText);
        mesg.append(guessText + "=>" + result + "\n");
        //mesg.setText(guessText + ":" + result);
        //Log.v("shine",guessText);
    }

    static String createAnswer(int n){
        // 洗牌
        int[] poker = new int[n]; // poker[0] = 0, ....
        int temp; boolean isRepeat;
        for (int i=0; i<poker.length; i++){
            do{
                temp = (int)(Math.random()*10);
                // 檢查機制
                isRepeat = false;
                for (int j=0; j<i; j++){
                    if (poker[j] == temp){
                        // 此時重複了
                        isRepeat = true;
                        break;
                    }
                }
            }while (isRepeat);
            poker[i] = temp;
            //System.out.println(poker[i]);
        }
        String ret = "";
        for (int v : poker) ret += v;

        return ret;
    }
    static String checkAB(String a, String g){
        int A, B; A = B = 0;
        for (int i=0; i<a.length(); i++){
            if (g.charAt(i) == a.charAt(i)){
                A++;
            }else if (a.indexOf(g.charAt(i)) != -1){
                B++;
            }
        }
        return A + "A" + B + "B";
    }

}

