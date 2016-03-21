package mk.edu.fikt.pmp.mat4;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private int koeKopce = -1;
    private int poeni = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DefinirajZadaca();
        citajRecnik();

//        ImageButton imgbtn = (ImageButton) findViewById(R.id.imageButton);
//        imgbtn.setImageDrawable(drawable.fict_logo);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

void citajRecnik(){

    Scanner scan = new Scanner(getResources().openRawResource(R.raw.recnik));
    String sve = "";
    while (scan.hasNextLine()){
        String linija = scan.nextLine();

       // String[] zborcinja = linija.split("\t");

        sve += linija;
    }

    TextView txt = (TextView) findViewById(R.id.myTextView);
    txt.setText(sve);

    scan.close();

}



    void NajdiZbor(String zborot){

        Scanner scan = new Scanner(getResources().openRawResource(R.raw.recnik));
        String sve = "";
        while (scan.hasNextLine()){
            String linija = scan.nextLine();

            String[] zborcinja = linija.split("\t");
            if (zborcinja[0]==zborot)
                 sve = zborcinja[1];
            else
                sve = "nemat takov";
        }

        TextView txt = (TextView) findViewById(R.id.myTextView);
        txt.setText(sve);

        scan.close();

    }




    public void DefinirajZadaca() {

        int br1 = 0;
        int br2 = 0;

        int rezultat = 0;
        int gresen1 = 0;
        int gresen2 = 0;
        int deltagresen = 0;

        Random rand = new Random();
        br1 = rand.nextInt(100);
        br2 = rand.nextInt(100);
        gresen1 = rand.nextInt(200);


        deltagresen = 1 + rand.nextInt(10);

        koeKopce = rand.nextInt(3);
        rezultat = br1 + br2;
        gresen2 = rezultat + deltagresen;


        TextView txtZadacata = (TextView) findViewById(R.id.txtZadaca);
        txtZadacata.setText(String.valueOf(br1) + " + " + String.valueOf(br2));

        TextView score = (TextView) findViewById(R.id.txtScore);
        score.setText(String.valueOf("Поени: " + poeni));


        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);


        if (koeKopce == 0) {
            btn1.setText(String.valueOf(rezultat));
            btn2.setText(String.valueOf(gresen1));
            btn3.setText(String.valueOf(gresen2));

        } else if (koeKopce == 1) {
            btn2.setText(String.valueOf(rezultat));
            btn1.setText(String.valueOf(gresen1));
            btn3.setText(String.valueOf(gresen2));
        } else {
            btn3.setText(String.valueOf(rezultat));
            btn2.setText(String.valueOf(gresen1));
            btn1.setText(String.valueOf(gresen2));
        }

    }

    public void klik1(View view) {

        if (koeKopce == 0) {
            poeni++;
            Toast t = Toast.makeText(this, "ТОЧНО", Toast.LENGTH_SHORT);
            playTocno();
            t.show();
        } else {
            poeni--;
            Toast t = Toast.makeText(this, "ГРЕШКА", Toast.LENGTH_SHORT);
            playGresno();
            t.show();
        }

        DefinirajZadaca();


    }

    public void klik2(View view) {
        if (koeKopce == 1) {
            poeni++;
            Toast t = Toast.makeText(this, "ТОЧНО", Toast.LENGTH_SHORT);
            playTocno();
            t.show();
        } else {
            poeni--;
            Toast t = Toast.makeText(this, "ГРЕШКА", Toast.LENGTH_SHORT);
            playGresno();
            t.show();
        }

        DefinirajZadaca();
    }

    public void playTocno(){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.applause);
        mp.start();
    }

    public void playGresno(){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.buzzer);
        mp.start();
    }

    public void klik3(View view) {

        if (koeKopce == 2) {
            poeni++;
            Toast t = Toast.makeText(this, "ТОЧНО", Toast.LENGTH_SHORT);
            playTocno();
            t.show();
        } else {
            poeni--;
            Toast t = Toast.makeText(this, "ГРЕШКА", Toast.LENGTH_SHORT);
            playGresno();
            t.show();
        }

        DefinirajZadaca();

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://mk.edu.fikt.pmp.mat4/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://mk.edu.fikt.pmp.mat4/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }



    public void BarajBe(View view){

        EditText editt = (EditText) findViewById(R.id.searchTerm);
        String shoDaBaram = editt.getText().toString();

        NajdiZbor(shoDaBaram);


    }
}
