package com.example.gogos.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String content;
    private int score;
    private String name;
    private String grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void editTextSummary(View view) {
        EditText nameOnFiled = (EditText) findViewById(R.id.answer_question_4_et_id);
        name = nameOnFiled.getText().toString();
        if (name.equals("Android Studio")) {
            score += 25;
        }
    }

    public void submitQuiz(View view) {
        checkBoxOnChecked(view);
        onRadioButton(view);
        editTextSummary(view);
        calculateGrade();
        quizSummary();
        score = 0;
        Toast.makeText(this, getString(R.string.quiz_result) + content, Toast.LENGTH_LONG).show();
    }

    private void quizSummary() {
        content += "\n" + getString(R.string.name_of_operating_system) + name;
        content += "\n" + getString(R.string.result) + score;
        content += "\n" + getString(R.string.grade) + grade;
        content += "\n" + getString(R.string.thank_you);
    }

    public void checkBoxOnChecked(View view) {
        CheckBox checkedOnAnswerA = (CheckBox) findViewById(R.id.answer_question_1_a_cb_id);
        CheckBox checkedOnAnswerB = (CheckBox) findViewById(R.id.answer_question_1_b_cb_id);
        CheckBox checkedOnAnswerC = (CheckBox) findViewById(R.id.answer_question_1_c_cb_id);
        CheckBox checkedOnAnswerD = (CheckBox) findViewById(R.id.answer_question_1_d_cd_id);
        if (checkedOnAnswerA.isChecked() && checkedOnAnswerB.isChecked()
                && checkedOnAnswerC.isChecked() && !checkedOnAnswerD.isChecked()) {
            score += 25;
        } else {
            return;
        }
    }

    public void onRadioButton(View view) {
        RadioButton checkedOnAnswerA = (RadioButton) findViewById(R.id.answer_question_2_a_rd_id);
        RadioButton checkedOnAnswerB = (RadioButton) findViewById(R.id.answer_question_3_b_rb_id);
        if (checkedOnAnswerA.isChecked() && checkedOnAnswerB.isChecked()) {
            score += 50;
        } else if ((checkedOnAnswerA.isChecked() && !checkedOnAnswerB.isChecked()) ||
                (!checkedOnAnswerA.isChecked() && checkedOnAnswerB.isChecked())) {
            score += 25;
        } else {
            setScore();
            return;
        }

    }

    private void calculateGrade() {
        if (score == 100) {
            grade = getString(R.string.A);
        } else if (score >= 70) {
            grade = "B";
        } else if (score >= 60) {
            grade = "C";
        } else if (score >= 50) {
            grade = getString(R.string.D);
        } else {
            grade = getString(R.string.F);
        }
    }

    private void setScore() {
        if (score >= 100) {
            score = 100;
        } else if (score <= 0) {
            score = 0;
        }
    }
}
