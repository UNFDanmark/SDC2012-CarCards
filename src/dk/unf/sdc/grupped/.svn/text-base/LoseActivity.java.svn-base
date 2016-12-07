package dk.unf.sdc.grupped;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class LoseActivity extends Activity {
	private Button youLoseButton;
	private Intent playAgainIntent;
	private Intent mainMenuIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lose);

		youLoseButton = (Button) findViewById(R.id.lMainMenuButton);

		mainMenuIntent = new Intent(this, MainScreen.class);

		youLoseButton.setOnClickListener(mainMenuListener);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_lose, menu);
		return true;
	}

	private OnClickListener mainMenuListener = new OnClickListener() {

		public void onClick(View v) {
			startActivity(mainMenuIntent);
			finish();
		}
	};
}
