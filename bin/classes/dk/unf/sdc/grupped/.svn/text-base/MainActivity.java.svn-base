package dk.unf.sdc.grupped;

import java.util.ArrayList;

import android.R.string;
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

public class MainActivity extends Activity {

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
	private NetworkService netservice;
	private BluetoothAdapter mBluetoothAdapter;
	private int combatchoice;
	private int opponentCard;

	public static final int MESSAGE_CHOSEN = 1;

	public static final int MESSAGE_PLAYED = 2;
	public static final int MESSAGE_WIN = 3;

	public static final int MESSAGE_LOSE = 4;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (mBluetoothAdapter == null) {
			// Device does not support Bluetooth
		}

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

		game = new Game(true);// vi skriver true fordi det er et netværk spil.
		netservice = NetworkService.getInstance(mBluetoothAdapter);
		netservice.setHandler(mHandler);

		hastighedKnap.setOnClickListener(hastighedsListener);
		motorKnap.setOnClickListener(motorListener);
		nulTilHundredKnap.setOnClickListener(nulTilHundredListener);
		hesteKræfterKnap.setOnClickListener(hesteKræfterListener);
		kmPerLiterKnap.setOnClickListener(kmPerLiterListener);

		battleIntent = new Intent(this, BattleActivity.class);

		loseIntent = new Intent(this, LoseActivity.class);
		winIntent = new Intent(this, WinActivity.class);

		this.updateInterface();
		if(!netservice.isServer()){
			hastighedKnap.setEnabled(false);
			motorKnap.setEnabled(false);
			nulTilHundredKnap.setEnabled(false);
			hesteKræfterKnap.setEnabled(false);
			kmPerLiterKnap.setEnabled(false);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void updateInterface() {
		if (game.getWin() == 2) {
			netservice.writemessage("win");
			startActivity(loseIntent);
			finish();
		} else if (game.getWin() == 1) {
			netservice.writemessage("lose");
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
			String choice = "chosen-1," + game.getCurrent1();
			writeDevice(choice);
			combatchoice = 1;

		}
	};
	private OnClickListener motorListener = new OnClickListener() {

		public void onClick(View v) {
			String choice = "chosen-2," + game.getCurrent1();
			writeDevice(choice);
			combatchoice = 2;
		}
	};
	private OnClickListener nulTilHundredListener = new OnClickListener() {

		public void onClick(View v) {
			String choice = "chosen-3," + game.getCurrent1();
			writeDevice(choice);
			combatchoice = 3;

		}
	};
	private OnClickListener hesteKræfterListener = new OnClickListener() {

		public void onClick(View v) {
			String choice = "chosen-4," + game.getCurrent1();
			writeDevice(choice);
			combatchoice = 4;
		}
	};
	private OnClickListener kmPerLiterListener = new OnClickListener() {

		public void onClick(View v) {
			String choice = "chosen-5," + game.getCurrent1();
			writeDevice(choice);
			combatchoice = 5;
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		int result = data.getExtras().getInt("win");
		if (result == 1) {
			Toast.makeText(getApplicationContext(), "You Won", Toast.LENGTH_SHORT).show();
			game.won(opponentCard);
			hastighedKnap.setEnabled(true);
			motorKnap.setEnabled(true);
			nulTilHundredKnap.setEnabled(true);
			hesteKræfterKnap.setEnabled(true);
			kmPerLiterKnap.setEnabled(true);
			updateInterface();
		} else if (result == 2) {
			Toast.makeText(getApplicationContext(), "You Lost", Toast.LENGTH_SHORT).show();
			game.lost();
			hastighedKnap.setEnabled(false);
			motorKnap.setEnabled(false);
			nulTilHundredKnap.setEnabled(false);
			hesteKræfterKnap.setEnabled(false);
			kmPerLiterKnap.setEnabled(false);
			updateInterface();
		} else if (result == 3) {
			Toast.makeText(getApplicationContext(), "Tied", Toast.LENGTH_SHORT).show();
			game.tied();
			updateInterface();
		}
	}

	private void writeDevice(String input) {
		netservice.writemessage(input);
	}

	// The Handler that gets information back from the BluetoothChatService
	private final Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {

			case MESSAGE_CHOSEN:
				byte[] readBuf = (byte[]) msg.obj;
				// construct a string from the valid bytes in the buffer
				String readMessage = new String(readBuf, 0, msg.arg1);

				Log.d("maintester", "Vi modtog i main: " + readMessage);
				String[] temp;
				/* delimiter */
				String delimiter = "-";
				// given string will be split by the argument delimiter
				// provided.
				temp = readMessage.split(delimiter);
				String[] temp1;
				/* delimiter */
				String delimiter1 = ",";
				// given string will be split by the argument delimiter
				// provided.
				temp1 = temp[1].split(delimiter1);
				int attribute = Integer.valueOf(temp1[0]);
				opponentCard = Integer.valueOf(temp1[1]);
				writeDevice("played-" + game.getCurrent1());

				battleIntent.putExtra("knap", attribute);
				battleIntent.putExtra("Player 1", game.getCurrent1());
				battleIntent.putExtra("Player 2", opponentCard);
				startActivityForResult(battleIntent, 0);
				break;
			case MESSAGE_PLAYED:
				byte[] readBuf1 = (byte[]) msg.obj;
				// construct a string from the valid bytes in the buffer
				String readMessage1 = new String(readBuf1, 0, msg.arg1);
				String[] temp2;
				/* delimiter */
				String delimiter2 = "-";
				// given string will be split by the argument delimiter
				// provided.
				temp2 = readMessage1.split(delimiter2);

				opponentCard = Integer.valueOf(temp2[1]);
				battleIntent.putExtra("knap", combatchoice);
				battleIntent.putExtra("Player 1", game.getCurrent1());
				battleIntent.putExtra("Player 2", opponentCard);
				startActivityForResult(battleIntent, 0);
				break;
			
			case MESSAGE_LOSE:
				startActivity(loseIntent);
				break;
			case MESSAGE_WIN:
				startActivity(winIntent);
				break;
			}
		}
	};
}
