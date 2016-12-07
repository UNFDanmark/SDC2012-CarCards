package dk.unf.sdc.grupped;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BattleActivity extends Activity {

	private ImageView userCard;
	private TextView userBrand;
	private TextView userCatagory;
	private TextView userSpecs;
	private TextView userWinLose;
	private ImageView opponentCard;
	private TextView opponentBrand;
	private TextView opponentCatagory;
	private TextView opponentSpecs;
	private TextView opponentWinLoose;
	private int result;
	private Intent resultIntent;
	private int player1Card;
	private int player2Card;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battle);

		userCard = (ImageView) findViewById(R.id.userCarPic);
		userBrand = (TextView) findViewById(R.id.userBrandBattleText);
		userCatagory = (TextView) findViewById(R.id.userCategoryText);
		userSpecs = (TextView) findViewById(R.id.userSpecsText);
		userWinLose = (TextView) findViewById(R.id.userWinnerLoserText);
		opponentCard = (ImageView) findViewById(R.id.opponentCarPic);
		opponentBrand = (TextView) findViewById(R.id.opponentBrandBattleText);
		opponentCatagory = (TextView) findViewById(R.id.opponentCategoryText);
		opponentSpecs = (TextView) findViewById(R.id.opponentSpecstext);
		opponentWinLoose = (TextView) findViewById(R.id.opponentWinnerLoserText);

		Intent intent = getIntent();
		int data = intent.getExtras().getInt("knap");
		player1Card = intent.getIntExtra("Player 1", -1);
		player2Card = intent.getIntExtra("Player 2", -1);

		userBrand.setText("" + Cardlibrary.cards.get(player1Card).getBrand());
		userCard.setImageResource(Cardlibrary.cards.get(player1Card).getPicture());
		opponentBrand.setText("" + Cardlibrary.cards.get(player2Card).getBrand());
		opponentCard.setImageResource(Cardlibrary.cards.get(player2Card).getPicture());

		if (data == 1) {
			userSpecs.setText("" + Cardlibrary.cards.get(player1Card).getSpeed());
			opponentSpecs.setText("" + Cardlibrary.cards.get(player2Card).getSpeed());
			userCatagory.setText("Max Speed");
			opponentCatagory.setText("Max Speed");
			if (Cardlibrary.cards.get(player1Card).getSpeed() > Cardlibrary.cards.get(player2Card).getSpeed()) {
				userWinLose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getSpeed() == Cardlibrary.cards.get(player2Card).getSpeed()) {
				userWinLose.setText("Tie");

			} else {
				userWinLose.setText("Lost");
			}
			if (Cardlibrary.cards.get(player1Card).getSpeed() < Cardlibrary.cards.get(player2Card).getSpeed()) {
				opponentWinLoose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getSpeed() == Cardlibrary.cards.get(player2Card).getSpeed()) {
				opponentWinLoose.setText("Tie");

			} else
				opponentWinLoose.setText("Lost");
		} else if (data == 2) {
			userSpecs.setText("" + Cardlibrary.cards.get(player1Card).getEngineSize());
			opponentSpecs.setText("" + Cardlibrary.cards.get(player2Card).getEngineSize());
			userCatagory.setText("Engine Size");
			opponentCatagory.setText("Engine Size");
			if (Cardlibrary.cards.get(player1Card).getEngineSize() > Cardlibrary.cards.get(player2Card).getEngineSize()) {
				userWinLose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getEngineSize() == Cardlibrary.cards.get(player2Card).getEngineSize()) {
				userWinLose.setText("Tie");

			} else
				userWinLose.setText("Lost");
			if (Cardlibrary.cards.get(player1Card).getEngineSize() < Cardlibrary.cards.get(player2Card).getEngineSize()) {
				opponentWinLoose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getEngineSize() == Cardlibrary.cards.get(player2Card).getEngineSize()) {
				opponentWinLoose.setText("Tie");

			} else
				opponentWinLoose.setText("Lost");
		} else if (data == 3) {
			userSpecs.setText("" + Cardlibrary.cards.get(player1Card).getNullToHundred());
			opponentSpecs.setText("" + Cardlibrary.cards.get(player2Card).getNullToHundred());
			userCatagory.setText("0-100km/t");
			opponentCatagory.setText("0-100km/t");
			if (Cardlibrary.cards.get(player1Card).getNullToHundred() < Cardlibrary.cards.get(player2Card).getNullToHundred()) {
				userWinLose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getNullToHundred() == Cardlibrary.cards.get(player2Card).getNullToHundred()) {
				userWinLose.setText("Tie");

			} else
				userWinLose.setText("Lost");
			if (Cardlibrary.cards.get(player1Card).getNullToHundred() > Cardlibrary.cards.get(player2Card).getNullToHundred()) {
				opponentWinLoose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getNullToHundred() == Cardlibrary.cards.get(player2Card).getNullToHundred()) {
				opponentWinLoose.setText("Tie");

			} else
				opponentWinLoose.setText("Lost");
		} else if (data == 4) {
			userSpecs.setText("" + Cardlibrary.cards.get(player1Card).getHorsePower());
			opponentSpecs.setText("" + Cardlibrary.cards.get(player2Card).getHorsePower());
			userCatagory.setText("BHP");
			opponentCatagory.setText("BHP");
			if (Cardlibrary.cards.get(player1Card).getHorsePower() > Cardlibrary.cards.get(player2Card).getHorsePower()) {
				userWinLose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getHorsePower() == Cardlibrary.cards.get(player2Card).getHorsePower()) {
				userWinLose.setText("Tie");

			} else
				userWinLose.setText("Lost");
			if (Cardlibrary.cards.get(player1Card).getHorsePower() < Cardlibrary.cards.get(player2Card).getHorsePower()) {
				opponentWinLoose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getHorsePower() == Cardlibrary.cards.get(player2Card).getHorsePower()) {
				opponentWinLoose.setText("Tie");

			} else
				opponentWinLoose.setText("Lost");
		} else if (data == 5) {
			userSpecs.setText("" + Cardlibrary.cards.get(player1Card).getUsePerKm());
			opponentSpecs.setText("" + Cardlibrary.cards.get(player2Card).getUsePerKm());
			userCatagory.setText("km/l");
			opponentCatagory.setText("km/l");
			if (Cardlibrary.cards.get(player1Card).getUsePerKm() > Cardlibrary.cards.get(player2Card).getUsePerKm()) {
				userWinLose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getUsePerKm() == Cardlibrary.cards.get(player2Card).getUsePerKm()) {
				userWinLose.setText("Tie");

			} else
				userWinLose.setText("Lost");
			if (Cardlibrary.cards.get(player1Card).getUsePerKm() < Cardlibrary.cards.get(player2Card).getUsePerKm()) {
				opponentWinLoose.setText("Win!");
			} else if (Cardlibrary.cards.get(player1Card).getUsePerKm() == Cardlibrary.cards.get(player2Card).getUsePerKm()) {
				opponentWinLoose.setText("Tie");

			} else
				opponentWinLoose.setText("Lost");
		}
		LinearLayout backLayout = (LinearLayout) findViewById(R.id.backButton);
		backLayout.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				
				if (userWinLose.getText().equals("Win!")) {
					result = 1;
				} else if(userWinLose.getText().equals("Lost")) {
					result = 2;
				}else {
					result = 3;
				
				}
				
				resultIntent = new Intent();
				resultIntent.putExtra("win", result);

				setResult(RESULT_OK, resultIntent);

				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_battle, menu);
		return true;
	}

}
