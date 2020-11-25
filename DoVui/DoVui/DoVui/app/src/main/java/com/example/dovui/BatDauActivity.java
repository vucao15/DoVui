package com.example.dovui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BatDauActivity extends AppCompatActivity implements View.OnClickListener {
    private DataBaseHelper dataBaseHelper;
    int stt;
    Button button;
    TextView tvQuestion;
    TextView tvContentQuestion;
    TextView tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    List<Number> listso = new ArrayList<>();
    int randomcauhoi1;
    int randomcauhoi2;
    int randomcauhoitieptheo;
    String titleQuestion;
    private String TAG = "HUAN";
    Random random = new Random();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bat_dau);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
        initUi();
        for (int i = 0; i <8 ; i++) {
            listso.add(i);
        }

        randomcauhoi1=random.nextInt(listso.size())+1;
        Log.e(TAG,"Chaytest cau hoi so1 " +randomcauhoi1);
        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDataBase();
         stt= 1;
       titleQuestion = "Question "+stt;
        List<Question> questionList = dataBaseHelper.searchQuestion(String.valueOf(randomcauhoi1));


        tvQuestion.setText(titleQuestion);
        tvContentQuestion.setText(questionList.get(0).cauhoi);
        tvAnswer1.setText(questionList.get(0).dapan1);
        tvAnswer2.setText(questionList.get(0).dapan2);
        tvAnswer3.setText(questionList.get(0).dapan3);
        tvAnswer4.setText(questionList.get(0).dapan4);
        listso.remove(randomcauhoi1);
        tvAnswer1.setOnClickListener(this);
        tvAnswer2.setOnClickListener(this);
        tvAnswer3.setOnClickListener(this);
        tvAnswer4.setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuestion();
            }
        });
    }
    private void initUi() {
        button = findViewById(R.id.btnnext);
        tvQuestion = findViewById(R.id.tvSTT);
        tvQuestion = findViewById(R.id.tvSTT);
        tvContentQuestion = findViewById(R.id.tvquestion);
        tvAnswer1 = findViewById(R.id.tvanswer1);
        tvAnswer2 = findViewById(R.id.tvanswer2);
        tvAnswer3 = findViewById(R.id.tvanswer3);
        tvAnswer4 = findViewById(R.id.tvanswer4);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.tvanswer1:
                tvAnswer1.setBackgroundResource(R.drawable.bg_orange_corner_30);

                break;
            case  R.id.tvanswer2:
                tvAnswer2.setBackgroundResource(R.drawable.bg_orange_corner_30);

                break;
            case  R.id.tvanswer3:
                tvAnswer3.setBackgroundResource(R.drawable.bg_orange_corner_30);


                break;
            case  R.id.tvanswer4:
                tvAnswer4.setBackgroundResource(R.drawable.bg_orange_corner_30);


                break;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void nextQuestion(){


        randomcauhoitieptheo = random.nextInt(listso.size())+1;;

        Log.e(TAG,"Chaytest cau hoi tiep  " +randomcauhoitieptheo);
        stt= stt+1;
        titleQuestion = "Question "+stt;
        List<Question> questionList = dataBaseHelper.searchQuestion(String.valueOf(randomcauhoitieptheo));
        tvQuestion.setText(titleQuestion);
        tvContentQuestion.setText(questionList.get(0).cauhoi);
        tvAnswer1.setText(questionList.get(0).dapan1);
        tvAnswer2.setText(questionList.get(0).dapan2);
        tvAnswer3.setText(questionList.get(0).dapan3);
        tvAnswer4.setText(questionList.get(0).dapan4);

        listso.remove(randomcauhoitieptheo);
//        for (int i = 0; i<=listso.size() ; i++) {
//            Log.e(TAG,"Chaytest " +listso.get(i));
//        }
//        Log.e(TAG,"Chaytest " +"+++++++++++++");



    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}