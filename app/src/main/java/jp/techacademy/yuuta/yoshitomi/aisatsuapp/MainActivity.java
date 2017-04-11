package jp.techacademy.yuuta.yoshitomi.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            mTextView.setText(mEditText.getText().toString());
        } else if (v.getId() == R.id.button3) {
            showTimePickerDialog();
        }
    }

    public void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if ((hourOfDay > 1) || (hourOfDay < 10)) {
                            mTextView.setText("おはよう");
                        } else if ((hourOfDay >= 10) || (hourOfDay < 18)) {
                            mTextView.setText("こんにちは");
                        } else if ((hourOfDay >= 18) || (hourOfDay < 2)) {
                            mTextView.setText("こんばんは");
                        }

                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}