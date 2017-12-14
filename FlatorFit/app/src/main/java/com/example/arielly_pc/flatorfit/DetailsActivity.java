package com.example.arielly_pc.flatorfit;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		ImageView imgExercise = (ImageView) findViewById(R.id.imgExercise);
		TextView txtTitleExercise = (TextView) findViewById(R.id.txtTitleExercise);
		LinearLayout mainiBG = (LinearLayout) findViewById(R.id.mainBG);

		String exercise = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);

		txtTitleExercise.setText(exercise);

		switch (exercise){
			case MainActivity.EXERCISE_WEIGHTS:
				mainiBG.setBackgroundColor(Color.parseColor("#2ca5f5"));
				imgExercise.setImageDrawable(getResources().getDrawable(R.drawable.weight, getApplicationContext().getTheme()));
				break;
			case MainActivity.EXERCISE_YOGA:
				mainiBG.setBackgroundColor(Color.parseColor("#916bcd"));
				imgExercise.setImageDrawable(getResources().getDrawable(R.drawable.lotus, getApplicationContext().getTheme()));
				break;
			case MainActivity.EXERCISE_CARDIO:
				mainiBG.setBackgroundColor(Color.parseColor("#52ad56"));
				imgExercise.setImageDrawable(getResources().getDrawable(R.drawable.heart, getApplicationContext().getTheme()));
				break;
		}
	}
}
