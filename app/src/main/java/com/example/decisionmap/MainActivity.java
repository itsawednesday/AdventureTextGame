package com.example.decisionmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {
    private DecisionNode node;

    private TextView description;
    private Button choise1Node;
    private Button choise2Node;
    private TextView option;
    private TextView option2;
    private DecisionMap data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button choise1Node = (Button) findViewById(R.id.getOption);
        Button choise2Node = (Button) findViewById(R.id.getOption2);
        TextView description = (TextView) findViewById(R.id.getDescription);


        try {
            data1 = new DecisionMap(getApplicationContext());
        } catch (
                FileNotFoundException var5) {
            description.setText("File not found");
            return;

        }
        node = data1.entryPoint();


            description.setText(node.getDescription());

            choise1Node.setText(node.getOption());
            choise2Node.setText(node.getOption2());



            choise1Node.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                 //   System.out.println(node.getDescription());

                    node = node.getChoise1Node();
                 //   System.out.println(node.getDescription());
                    description.setText(node.getDescription());

                    choise1Node.setText(node.getOption());


                    choise2Node.setText(node.getOption2());

                }
            });
            choise2Node.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    node = node.getChoise2Node();
                    description.setText(node.getDescription());

                    choise1Node.setText(node.getOption());
                    choise2Node.setText(node.getOption2());
                }
            });



        }
            public void exceptionChoice1 (View view){
                try {
                    node = node.getChoise1Node();
                    throw new EmptyException();
                } catch (EmptyException m) {
                    System.out.println(m.getMessage());

                }

            }

            public void exceptionChoice2 (View view){
                try {
                    node = node.getChoise2Node();
                    node = node.getChoise1Node();
                    throw new EmptyException();
                } catch (EmptyException m) {
                    System.out.println(m.getMessage());


                }
            }

        }





//Startbutton.setOnClickListener(new View.OnClickListener(){
//
//@Override
//public void onClick(View v){
//        Intent intent=new Intent(MainActivity.this,OtherActivity2.class);
//        startActivity(intent);
//
//        }
