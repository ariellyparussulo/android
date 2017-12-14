package com.example.arielly_pc.coolcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
	private enum Operation {
		ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL;
	}

	private String runningNumber = "";
	private String leftValueStr = "";
	private String rightValueStr = "";
	private double result;
	private Operation currentOperation;

	private  TextView txtResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtResult = (TextView) findViewById(R.id.txtResult);

		Button btn0 = (Button) findViewById(R.id.btn0);
		Button btn1 = (Button) findViewById(R.id.btn1);
		Button btn2 = (Button) findViewById(R.id.btn2);
		Button btn3 = (Button) findViewById(R.id.btn3);
		Button btn4 = (Button) findViewById(R.id.btn4);
		Button btn5 = (Button) findViewById(R.id.btn5);
		Button btn6 = (Button) findViewById(R.id.btn6);
		Button btn7 = (Button) findViewById(R.id.btn7);
		Button btn8 = (Button) findViewById(R.id.btn8);
		Button btn9 = (Button) findViewById(R.id.btn9);

		Button btnClear = (Button) findViewById(R.id.btnClear);

		ImageButton btnDiv = (ImageButton) findViewById(R.id.btnDivide);
		ImageButton btnMult = (ImageButton) findViewById(R.id.btnMultiply);
		ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd);
		ImageButton btnSub = (ImageButton) findViewById(R.id.btnSubtract);

		ImageButton btnEquals = (ImageButton) findViewById(R.id.btnEquals);


		btn0.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);

		btnClear.setOnClickListener(this);

		btnDiv.setOnClickListener(this);
		btnMult.setOnClickListener(this);
		btnAdd.setOnClickListener(this);
		btnSub.setOnClickListener(this);

		btnEquals.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btn0:
				numberPressed('0');
				break;
			case R.id.btn1:
				numberPressed('1');
				break;
			case R.id.btn2:
				numberPressed('2');
				break;
			case R.id.btn3:
				numberPressed('3');
				break;
			case R.id.btn4:
				numberPressed('4');
				break;
			case R.id.btn5:
				numberPressed('5');
				break;
			case R.id.btn6:
				numberPressed('6');
				break;
			case R.id.btn7:
				numberPressed('7');
				break;
			case R.id.btn8:
				numberPressed('8');
				break;
			case R.id.btn9:
				numberPressed('9');
				break;
			case R.id.btnClear:
				clear();
				break;
			case R.id.btnDivide:
				processOperation(Operation.DIVIDE);
				break;
			case R.id.btnAdd:
				processOperation(Operation.ADD);
				break;
			case R.id.btnMultiply:
				processOperation(Oxperation.MULTIPLY);
				break;
			case R.id.btnSubtract:
				processOperation(Operation.SUBTRACT );
				break;
			case R.id.btnEquals:
				processOperation(Operation.EQUAL);
				break;
		}
	}

	private void clear(){
		currentOperation = null;
		leftValueStr = "";
		rightValueStr = "";
		txtResult.setText("");
		result = 0;
		runningNumber = "";
	}

	private void processOperation (Operation operation){
		if (currentOperation != null){
			if (runningNumber != ""){
				rightValueStr = runningNumber;
				runningNumber = "";

				switch (currentOperation){
					case ADD:
						result = Double.parseDouble(leftValueStr) + Double.parseDouble(rightValueStr);
						break;
					case SUBTRACT:
						result = Double.parseDouble(leftValueStr) - Double.parseDouble(rightValueStr);
						break;
					case MULTIPLY:
						result = Double.parseDouble(leftValueStr) * Double.parseDouble(rightValueStr);
						break;
					case DIVIDE:
						result = Double.parseDouble(leftValueStr) / Double.parseDouble(rightValueStr);
						break;
				}

				leftValueStr = String.valueOf(result);
				txtResult.setText(leftValueStr);

				currentOperation = operation;
			}
		} else {
			leftValueStr = runningNumber;
			runningNumber = "";
			currentOperation = operation;
		}
	}

	private void numberPressed(char number){
		runningNumber += number;
		txtResult.setText(runningNumber);
	}
}
