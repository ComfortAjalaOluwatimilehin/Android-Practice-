package com.comfort.ajala.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Queue;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ///Declare variables for the maths
    private TextView one,two,three,four,five,six,seven,eight,nine,zero;
    private EditText numberone;
    private TextView answer;
    private int NUMBERONE,NUMBERTWO;
    private String OPERATOR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call the reference method
        reference();
    }

    ////////////////////////////////////////////////////////////////////////////////
    private void reference(){

        one = (TextView) findViewById(R.id.one);
        two = (TextView) findViewById(R.id.two);
        three = (TextView) findViewById(R.id.three);
        four = (TextView) findViewById(R.id.four);
        five = (TextView) findViewById(R.id.five);
        six = (TextView) findViewById(R.id.six);
        seven = (TextView) findViewById(R.id.seven);
        eight = (TextView) findViewById(R.id.eight);
        nine = (TextView) findViewById(R.id.nine);
        zero = (TextView) findViewById(R.id.zero);
        numberone = (EditText) findViewById(R.id.numberone);
        answer = (TextView) findViewById(R.id.answer);
        NUMBERONE = NUMBERTWO = -1;

    }

    private void reset(){
        NUMBERONE = NUMBERTWO = -1;
        OPERATOR = null;
        numberone.setText("");
        answer.setText("");
    }
    @Override
    public void onClick(View v) {

        //store the value of the textview clicked
        String val = ((TextView)findViewById(v.getId())).getText().toString();
        //check if the clear button was clicked
        if(v.getId() == R.id.button){
            reset();
        }
        ///else check what if numbers, operators or equal sign was clicked and deal a planned
        else {
            switch (val) {

                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "0":

                    //check if the operator is already selected to guaranty that the firstnumber is set already else set the first number and store
                    if (OPERATOR == null) {
                        //if numberone is set already
                        if(NUMBERONE > -1){
                          String temp = Integer.toString(NUMBERONE) + val;
                            NUMBERONE =  Integer.parseInt(temp);
                        }else{
                        NUMBERONE = Integer.parseInt(val);}
                        //System.out.println("NUMBER ONE");
                        // System.out.println(NUMBERONE);

                        numberone.setText(Integer.toString(NUMBERONE));
                    }
                    ///else store the number in the second variable
                    else {
                        if(NUMBERTWO > -1){
                            String temp = Integer.toString(NUMBERTWO) + val;
                            NUMBERTWO =  Integer.parseInt(temp);
                        }else{
                        NUMBERTWO = Integer.parseInt(val);}
                        //System.out.println("NUMBER TWO");
                        //System.out.println(NUMBERTWO);
                        String finals = Integer.toString(NUMBERONE) + OPERATOR + Integer.toString(NUMBERTWO);
                        numberone.setText(finals);

                    }
                    break;
                //check if operators are selected
                case "+":
                case "-":
                case "x":
                case "/":
                    //store operator
                    OPERATOR = val;
                    //System.out.println("Operation");
                    break;

                case "=":
                   doMath();
                    break;
            }
        }

    }

    private void doMath(){
        if (NUMBERONE >= 0 && NUMBERTWO >= 0 && !OPERATOR.isEmpty()) {
            double end = 0;
//a switch within a switch -- switch inception :)..... do the maths based on the operator stored
            System.out.println("" + NUMBERONE + " " + NUMBERTWO);
            switch (OPERATOR) {
                case "+":
                    end = (double) NUMBERONE + (double) NUMBERTWO;
                    break;
                case "-":
                    end = (double) NUMBERONE - (double) NUMBERTWO;
                    break;
                case "x":
                    end = (double) NUMBERONE * (double) NUMBERTWO;
                    break;
                case "/":
                    end = (double) NUMBERONE / (double) NUMBERTWO;
                    break;
            }

            //System.out.println("END Expression: " + end);


            answer.setText(Double.toString(end));


        }
    }

    //The END!!! THANKS UDACITY::: I WILL UPDATE THISE APP SOON...
    ///////////////////////////////////////////////////////////////////////////////
}

