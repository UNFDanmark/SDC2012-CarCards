package dk.unf.sdc.grupped;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleActivity extends Activity {

	private Game game;
	private TextView mærke;
	private ImageView bil;
	private Button hastighedKnap;
	private TextView hastighedTekst;
	private Button motorKnap;
	private TextView motorTekst;
	private Button nulTilHundredKnap;
	private TextView nulTilHundredTekst;
	private Button hesteKræfterKnap;
	private TextView hesteKræfterTekst;
	private Button kmPerLiterKnap;
	private TextView kmPerLiterTekst;
	private TextView dækTællerTekst;
	private Intent battleIntent;
	private Intent loseIntent;
	private Intent winIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		mærke = (TextView) findViewById(R.id.brandText);
		bil = (ImageView) findViewById(R.id.carPic);
		hastighedKnap = (Button) findViewById(R.id.maxSpeedButton);
		hastighedTekst = (TextView) findViewById(R.id.maxSpeedText);
		motorKnap = (Button) findViewById(R.id.engineSizeButton);
		motorTekst = (TextView) findViewById(R.id.engineSizeText);
		nulTilHundredKnap = (Button) findViewById(R.id.nullToHundredButton);
		nulTilHundredTekst = (TextView) findViewById(R.id.nullToHundredText);
		hesteKræfterKnap = (Button) findViewById(R.id.bhpButton);
		hesteKræfterTekst = (TextView) findViewById(R.id.bhpText);
		kmPerLiterKnap = (Button) findViewById(R.id.kmlButton);
		kmPerLiterTekst = (TextView) findViewById(R.id.kmlText);
		dækTællerTekst = (TextView) findViewById(R.id.deckCountText);

		game = new Game(false);

		hastighedKnap.setOnClickListener(hastighedsListener);
		motorKnap.setOnClickListener(motorListener);
		nulTilHundredKnap.setOnClickListener(nulTilHundredListener);
		hesteKræfterKnap.setOnClickListener(hesteKræfterListener);
		kmPerLiterKnap.setOnClickListener(kmPerLiterListener);

		battleIntent = new Intent(this, BattleActivity.class);

		loseIntent = new Intent(this, LoseActivity.class);
		winIntent = new Intent(this, WinActivity.class);

		this.newCard();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void newCard() {
		if (game.getCurrent1() == -1) {
			startActivity(loseIntent);
			finish();
		} else if (game.getCurrent2() == -1) {
			startActivity(winIntent);
			finish();
		} else {

			mærke.setText("" + Cardlibrary.cards.get(game.getCurrent1()).getBrand());
			hastighedTekst.setText("" + Cardlibrary.cards.get(game.getCurrent1()).getSpeed());
			motorTekst.setText("" + Cardlibrary.cards.get(game.getCurrent1()).getEngineSize());
			nulTilHundredTekst.setText("" + Cardlibrary.cards.get(game.getCurrent1()).getNullToHundred());
			hesteKræfterTekst.setText("" + Cardlibrary.cards.get(game.getCurrent1()).getHorsePower());
			kmPerLiterTekst.setText("" + Cardlibrary.cards.get(game.getCurrent1()).getUsePerKm());
			dækTællerTekst.setText("Deck Count: " + game.getPlayer1().getCards().size());
			bil.setImageResource(Cardlibrary.cards.get(game.getCurrent1()).getPicture());
		}
	}

	private OnClickListener hastighedsListener = new OnClickListener() {

		public void onClick(View v) {
			battleIntent.putExtra("knap", 1);
			battleIntent.putExtra("Player 1", game.getCurrent1());
			battleIntent.putExtra("Player 2", game.getCurrent2());
			startActivityForResult(battleIntent, 0);
		}
	};
	private OnClickListener motorListener = new OnClickListener() {

		public void onClick(View v) {
			battleIntent.putExtra("knap", 2);
			battleIntent.putExtra("Player 1", game.getCurrent1());
			battleIntent.putExtra("Player 2", game.getCurrent2());
			startActivityForResult(battleIntent, 0);
		}
	};
	private OnClickListener nulTilHundredListener = new OnClickListener() {

		public void onClick(View v) {
			battleIntent.putExtra("knap", 3);
			battleIntent.putExtra("Player 1", game.getCurrent1());
			battleIntent.putExtra("Player 2", game.getCurrent2());
			startActivityForResult(battleIntent, 0);

		}
	};
	private OnClickListener hesteKræfterListener = new OnClickListener() {

		public void onClick(View v) {
			battleIntent.putExtra("knap", 4);
			battleIntent.putExtra("Player 1", game.getCurrent1());
			battleIntent.putExtra("Player 2", game.getCurrent2());
			startActivityForResult(battleIntent, 0);
		}
	};
	private OnClickListener kmPerLiterListener = new OnClickListener() {

		public void onClick(View v) {
			battleIntent.putExtra("knap", 5);
			battleIntent.putExtra("Player 1", game.getCurrent1());
			battleIntent.putExtra("Player 2", game.getCurrent2());
			startActivityForResult(battleIntent, 0);
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		int result = data.getExtras().getInt("win");
		if (result == 1) {
			Toast.makeText(getApplicationContext(), "You Won", Toast.LENGTH_SHORT).show();
			game.setWinner(game.getPlayer1());
			newCard();
		} else if (result == 2) {
			Toast.makeText(getApplicationContext(), "You Lost", Toast.LENGTH_SHORT).show();
			game.setWinner(game.getPlayer2());
			newCard();
		} else if (result == 3) {
			Toast.makeText(getApplicationContext(), "Tied", Toast.LENGTH_SHORT).show();
			game.tied();
			newCard();
		}
	}
	
	
}
