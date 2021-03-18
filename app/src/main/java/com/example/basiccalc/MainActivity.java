package com.example.basiccalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button Ac,Power,Back,Div,Mul,Add,Sub,Nine,Eigth,Seven,Six,Five,Four,Three,Two,One,Zero,Point,Answer,Equal,opencoversion;
    String input,ansr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ac=findViewById(R.id.ac);
        Screen=findViewById(R.id.screen);
        Power=findViewById(R.id.power);
        Back=findViewById(R.id.back);
        Div=findViewById(R.id.div);
        Mul=findViewById(R.id.mul);
        Add=findViewById(R.id.add);
        Sub=findViewById(R.id.sub);
        Nine=findViewById(R.id.nine);
        Eigth=findViewById(R.id.eight);
        Seven=findViewById(R.id.seven);
        Six=findViewById(R.id.six);
        Five=findViewById(R.id.five);
        Four=findViewById(R.id.four);
        Three=findViewById(R.id.three);
        Two=findViewById(R.id.two);
        One=findViewById(R.id.one);
        Zero=findViewById(R.id.zero);
        Point=findViewById(R.id.point);
        Answer=findViewById(R.id.answer);
        Equal=findViewById(R.id.equal);

    }

    public void ButtonClicked(View view){
        // open conversion activity






        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){

            case "AC":
                input="";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            case "ANS":
                input+=ansr;
                break;
            case "X":
                Solve();
                input+="*";
                break;
            case "=":
                Solve();
                ansr=input;
                break;
            case "DEL":
                String newtext = input.substring(0,input.length()-1);
                input= newtext;
                break;
            default:
                if (input==null){
                    input= "";
                }
                if (data.equals("+")||data.equals("-")||data.equals("/")){
                    Solve();
                }
                input+=data;
        }
        Screen.setText(input);
    }
    private void Solve(){

        if (input.split("\\*").length==2){

            String number [] = input.split("\\*");
            try {
                Double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul +"";
            }
            catch (Exception e){

            }
        }
        else if (input.split("/").length==2){

            String number [] = input.split("/");
            try {
                Double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div +"";
            }
            catch (Exception e){

            }
        }
        else if (input.split("\\^").length==2){

            String number [] = input.split("\\^");
            try {
                Double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input = pow +"";
            }
            catch (Exception e){

            }
        }
        else if (input.split("\\+").length==2){

            String number [] = input.split("\\+");
            try {
                Double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum +"";
            }
            catch (Exception e){

            }
        }
        else if (input.split("-").length>1){

            String number [] = input.split("-");
            // negative numbers operation
            if (number[0]=="" && number.length==2){
                number[0]= 0 +"";
            }
            try {
                double sub = 0;
                if(number.length==2) {
                     sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);

                }
                else if(number.length==3){
                    sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub + "";
            }
            catch (Exception e){

            }
        }
        String n [] = input.split("\\.");
        if (n.length>1){
            if (n[1].equals("0")){
                input= n[0];
            }
        }
        Screen.setText(input);


    }

    public void CallConversion(View view){
        Intent intent = new Intent(MainActivity.this,ConversionActivity.class);
        startActivity(intent);
        finish();
    }
}
