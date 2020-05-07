package ru.mvrlrd.materialdesignproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class StartActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        editText = findViewById(R.id.editTextStartView);
    }


    public void onClickButton(View view) {
        //Toast.makeText(this, "mes", Toast.LENGTH_SHORT).show();
        if (!"".contentEquals(editText.getText())){
            startActivity(new Intent(StartActivity.this, MainActivity.class));
        }
        else if ("".contentEquals(editText.getText())) {
            Snackbar snackbar = Snackbar.make(view, "Введите имя", Snackbar.LENGTH_LONG);
            snackbar.setAction("random nick", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < 4 ; i++) {
                        stringBuilder.append((char)(int) (Math.random() * 100));
                    }
                    editText.setText(stringBuilder.toString());
                    startActivity(new Intent(StartActivity.this, MainActivity.class));

                }
            });
            snackbar.show();
        }
    }
}
