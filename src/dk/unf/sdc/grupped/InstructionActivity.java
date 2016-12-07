package dk.unf.sdc.grupped;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InstructionActivity extends Activity {

	private Button backButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instruction);

		backButton = (Button) findViewById(R.id.instructionBackButton);
		backButton.setOnClickListener(backButtonListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_instruction, menu);
		return true;
	}
	

	private OnClickListener backButtonListener = new OnClickListener() {

		public void onClick(View v) {
			finish();
		}
	};

}
