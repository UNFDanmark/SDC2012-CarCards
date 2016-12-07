package dk.unf.sdc.grupped;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WinActivity extends Activity {
	private Button mainMenuButton;
	private Intent wPlayAgainIntent;
    private Intent wMainMenuIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        mainMenuButton = (Button) findViewById(R.id.wMainMenuButton); 
		wMainMenuIntent = new Intent (this, MainScreen.class); 
		mainMenuButton.setOnClickListener(wMainMenuListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_win_screen, menu);
        return true;
    }
 
	private OnClickListener wMainMenuListener = new OnClickListener() {
		
		public void onClick(View v) {
			startActivity(wMainMenuIntent);
			finish();
		}
	};

    
}
