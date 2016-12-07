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
import android.widget.Toast;

public class MainScreen extends Activity {
	private Button play1;
	private Button play2;
	private Intent findGameIntent;
	private Intent SingleGameIntent;
	private NetworkService netService;
	private BluetoothAdapter mBluetoothAdapter;
	private static final int REQUEST_ENABLE_BT = 1;
	private static final String tag = "BluetoothFrame";
	private ArrayList<BluetoothDevice> discoveredPeers;
	private AlertDialog serverDialog;
	private AlertDialog clientDialog;
	private EditText input_serverName;
	private EditText input_clientServerName;
	private String clientServerName;
	private Button server;
	private Button client;
	private Context mContext;
	private Button instructions;
	private Intent startinstruct;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
		mContext = getApplicationContext();

		play1 = (Button) findViewById(R.id.findGameButton);
		play2 = (Button) findViewById(R.id.playOfflineButton);
		instructions = (Button) findViewById(R.id.instructionButton);

		play1.setOnClickListener(play1Listener);
		play2.setOnClickListener(play2Listener);
		instructions.setOnClickListener(instruckt);

		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (mBluetoothAdapter == null) {
			// Device does not support Bluetooth
		}
		netService = NetworkService.getInstance(mBluetoothAdapter);
		netService.setHandler(mHandler);
		IntentFilter deviceFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		Log.d(tag, "Registering deviceReceiver");
		registerReceiver(deviceReceiver, deviceFilter);
		IntentFilter adapterFilter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		Log.d(tag, "Registering adapterReceiver");
		registerReceiver(adapterReceiver, adapterFilter);
		server = (Button) findViewById(R.id.start_server);
		client = (Button) findViewById(R.id.start_client);
		serverDialog = new AlertDialog.Builder(this).create();
		clientDialog = new AlertDialog.Builder(this).create();
		input_serverName = new EditText(this);
		input_clientServerName = new EditText(this);
		discoveredPeers = new ArrayList<BluetoothDevice>();

		findGameIntent = new Intent(this, MainActivity.class);
		
		startinstruct = new Intent(this, InstructionActivity.class);

		SingleGameIntent = new Intent(this, SingleActivity.class);
		client.setOnClickListener(startClientListener);
		server.setOnClickListener(startServerListener);
		

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(tag, "Unregistering deviceReceiver");
		unregisterReceiver(deviceReceiver);
		Log.d(tag, "Unregistering adapterReceiver");
		unregisterReceiver(adapterReceiver);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode) {
		case REQUEST_ENABLE_BT:
			// When the request to enable Bluetooth returns
			if (resultCode == Activity.RESULT_OK) {
				// Bluetooth is now enabled, so set up a chat session
				Toast.makeText(this, "BT Enabled", Toast.LENGTH_SHORT).show();
			} else {
				// User did not enable Bluetooth or an error occurred
				Log.d(tag, "BT not enabled");
				Toast.makeText(this, "BT Not Enabled", Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}

	// Create a BroadcastReceiver for ACTION_FOUND
	private final BroadcastReceiver deviceReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			// When discovery finds a device
			Log.d(tag, action);
			Log.d(tag, String.valueOf(BluetoothDevice.ACTION_FOUND.equals(action)));
			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				// Get the BluetoothDevice object from the Intent
				BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				try {
					discoveredPeers.add(device);
					Log.d(tag, device.getName() + " added to discovered list.");
				} catch (Exception e) {
					Log.d(tag, "Failed adding device to device list.");
				}
			}
		}
	};

	// Create a BroadcastReceiver for ACTION_DISCOVERY
	private final BroadcastReceiver adapterReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			// When discovery finds a device
			Log.d(tag, action);
			if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
				Log.d(tag, "Trying to connect as client.");
				boolean bo = false;
				for (BluetoothDevice device : discoveredPeers) {
					Log.d(tag, "DEVICE NAME: " + device.getName());
					if (device.getName().equals(clientServerName)) {
						Log.d(tag, "Discovered, OK.");
						netService.connect(device);
						bo = true;
						// Her skal i LAve knappen om så den starter et
						// netværksspil.
					}
				}
				if (!bo) {
					Toast.makeText(getApplicationContext(), "Could not find server with name: " + clientServerName, Toast.LENGTH_SHORT).show();
				}
			}
		}
	};

	private OnClickListener startServerListener = new OnClickListener() {
		public void onClick(View v) {
			serverDialog.setTitle("Create Game");
			serverDialog.setView(input_serverName);
			serverDialog.setMessage("Set Game name:");
			serverDialog.setCancelable(false);
			serverDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Create Game", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					if (!mBluetoothAdapter.isEnabled()) {
						Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
						startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
					}
					Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
					discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 0);
					startActivity(discoverableIntent);
					mBluetoothAdapter.setName(input_serverName.getText().toString());
					netService.start();
					for (int i = 0; i < 3; i++) {
						Toast.makeText(mContext, "Wait for other player to connect.", Toast.LENGTH_LONG).show();

					}

				}
			});
			serverDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					serverDialog.cancel();
				}
			});
			serverDialog.show();
		}
	};

	private OnClickListener startClientListener = new OnClickListener() {
		public void onClick(View v) {
			clientDialog.setTitle("Connect to Game");
			clientDialog.setView(input_clientServerName);
			clientDialog.setMessage("Type Game name:");
			clientDialog.setCancelable(false);
			clientDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Connect to Game", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {

					if (!mBluetoothAdapter.isEnabled()) {
						Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
						startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
					}
					clientServerName = input_clientServerName.getText().toString();
					mBluetoothAdapter.startDiscovery();
					for (int i = 0; i < 3; i++) {
						Toast.makeText(mContext, "Please wait at least 10-15 seconds while connecting.", Toast.LENGTH_LONG).show();

					}

				}
			});
			clientDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Annuller", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					clientDialog.cancel();
				}
			});
			clientDialog.show();
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_screen, menu);
		return true;
	}

	private OnClickListener play1Listener = new OnClickListener() {

		public void onClick(View v) {
			if (netService.isNetworkGame()) {
				startActivity(findGameIntent);
				finish();
			} else {
				Toast.makeText(getApplicationContext(), "Connect to other player first", Toast.LENGTH_SHORT).show();

			}
		}
	};
	private OnClickListener play2Listener = new OnClickListener() {

		public void onClick(View v) {
			startActivity(SingleGameIntent);
			finish();

		}
	};
	private OnClickListener instruckt = new OnClickListener() {

		public void onClick(View v) {
			startActivityForResult(startinstruct, 0);
		}
	};

	private final Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {

			case 0:
				// Her får spilleren besked på at der er forbundet en anden
				// spiller.
				Toast.makeText(getApplicationContext(), "Connected to player. Please start the game!", Toast.LENGTH_LONG).show();

				break;

			}
		}
	};

}
