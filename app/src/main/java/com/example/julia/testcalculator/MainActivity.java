package com.example.julia.testcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String nowNum="";
    EditText edtResult;
    boolean reset = false;
    //set operate option
    int option =0;
    double sol=0;
    double temp =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickButton(View view){
        Button btn = (Button)view;
        edtResult=(EditText) findViewById(R.id.edtResult);
        int getBtnId = view.getId();

        if(getBtnId == R.id.btn_0||getBtnId==R.id.btn_1||getBtnId==R.id.btn_2||getBtnId==R.id.btn_3||
                getBtnId==R.id.btn_4||getBtnId==R.id.btn_5||getBtnId==R.id.btn_6||getBtnId==R.id.btn_7||
                getBtnId==R.id.btn_8||getBtnId==R.id.btn_9){
            if(reset){
                reset = false;
                nowNum=btn.getText().toString();
                edtResult.setText(nowNum);

            } else{
                nowNum = String.valueOf(edtResult.getText());
                if(nowNum.equals("0")){
                    nowNum=btn.getText().toString();
                }else {
                    nowNum = nowNum + btn.getText().toString();
                }
                edtResult.setText(nowNum);
            }

        }

        else if(getBtnId==R.id.btn_add){
            double now = Double.parseDouble(String.valueOf(edtResult.getText()));
            if(option ==0) {
                sol = now;
                option = 1;
                reset = true;
            }else{
                temp = now;
                sol = operation(option, sol, temp);
                option =1;
                reset = true;
            }
            edtResult.setText(String.valueOf(sol));
        }

        else if(getBtnId==R.id.btn_sub){
            double now = Double.parseDouble(String.valueOf(edtResult.getText()));
            if(option ==0){
                sol = now;
                option =2;
                reset = true;
            }else{
                temp = now;
                sol = operation(option,sol,temp);
                option = 2;
                reset = true;
            }
            edtResult.setText(String.valueOf(sol));
        }

        else if(getBtnId == R.id.btn_times){
            double now = Double.parseDouble(String.valueOf(edtResult.getText()));
            if(option ==0){
                sol = now;
                option = 3;
                reset = true;
            }else{
                temp = now;
                sol = operation(option,sol,temp);
                option = 3;
                reset = true;
            }
            edtResult.setText(String.valueOf(sol));
        }

        else if(getBtnId == R.id.btn_devide){
            double now = Double.parseDouble(String.valueOf(edtResult.getText()));
            if(option == 0){
                sol = now;
                option = 4;
                reset = true;
            }else{
                temp = now;
                sol = operation(option,sol,temp);
                option = 4;
                reset = true;
            }
            edtResult.setText(String.valueOf(sol));
        }

        else if(getBtnId==R.id.btn_equal){
            double now = Double.parseDouble(String.valueOf(edtResult.getText()));
            temp = now;
            sol = operation(option,sol,temp);
            option = 0;
            reset = true;
            edtResult.setText(String.valueOf(sol));
        }

        else if(getBtnId==R.id.btn_clear){
            temp = 0;
            sol = 0;
            option =0;
            reset = true;
            edtResult.setText(String.valueOf(sol));
        }
        else if(getBtnId == R.id.btn_percent){
            double now = Double.parseDouble(String.valueOf(edtResult.getText()));
            now = now/100;
            edtResult.setText(String.valueOf(now));
        }
        else if(getBtnId == R.id.btn_addSub){
            double now = Double.parseDouble(String.valueOf(edtResult.getText()));
            now = -now;
            edtResult.setText(String.valueOf(now));
        }
        else if(getBtnId == R.id.btn_point){
           // int now = Integer.parseInt(String.valueOf(edtResult.getText()));
            nowNum = String.valueOf(edtResult.getText());

            edtResult.setText(String.valueOf(nowNum)+".");
        }

    }

    private double operation(int option,double sol,double temp) {
        if(option == 1){
            sol = sol + temp;
        }
        else if(option ==2){
            sol = sol - temp;
        }
        else if(option ==3){
            sol = sol * temp;
        }
        else if(option == 4){
            sol = sol/ temp;
        }


        return sol;
    }
}
