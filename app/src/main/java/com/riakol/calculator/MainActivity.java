package com.riakol.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textViewExample = findViewById(R.id.textViewExample);
        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView incorrectAnswer = findViewById(R.id.textViewIncorrectAnswer);
        TextView correctAnswer = findViewById(R.id.textViewCorrectAnswer);

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editTextAnswer.getText().toString();
                if (text.equals("15")) {
                    correctAnswer.setVisibility(View.VISIBLE);
                    incorrectAnswer.setVisibility(View.GONE);
                } else {
                    correctAnswer.setVisibility(View.GONE);
                    incorrectAnswer.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}