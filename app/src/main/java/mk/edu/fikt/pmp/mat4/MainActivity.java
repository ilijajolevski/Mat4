package mk.edu.fikt.pmp.mat4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int koeKopce = -1;
    private int poeni =0;

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



    public void DefinirajZadaca(){

        int br1=0;
        int br2=0;

        int rezultat = 0;
        int gresen1 = 0;
        int gresen2 = 0;
        int deltagresen = 0;

        Random rand = new Random();
        br1 = rand.nextInt(100);
        br2 = rand.nextInt(100);
        gresen1 = rand.nextInt(200);


        deltagresen = 1+ rand.nextInt(10);

        koeKopce = rand.nextInt(3);
        rezultat = br1+br2;
        gresen2 = rezultat + deltagresen;


                TextView txtZadacata = (TextView) findViewById(R.id.txtZadaca);
        txtZadacata.setText(String.valueOf(br1) + " + " + String.valueOf(br2));

        TextView score = (TextView) findViewById(R.id.txtScore);
        score.setText(String.valueOf("Поени: " + poeni));


        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);




        if (koeKopce==0){
            btn1.setText(String.valueOf(rezultat));
            btn2.setText(String.valueOf(gresen1));
            btn3.setText(String.valueOf(gresen2));

        }else
            if(koeKopce==1){
                btn2.setText(String.valueOf(rezultat));
                btn1.setText(String.valueOf(gresen1));
                btn3.setText(String.valueOf(gresen2));
            }else
            {
                btn3.setText(String.valueOf(rezultat));
                btn2.setText(String.valueOf(gresen1));
                btn1.setText(String.valueOf(gresen2));
            }

    }

    public void klik1(View view) {

        if(koeKopce==0){
            poeni++;
                    Toast t = Toast.makeText(this,"ТОЧНО", Toast.LENGTH_SHORT);
                     t.show();
        }else
        {
            poeni--;
            Toast t = Toast.makeText(this,"ГРЕШКА", Toast.LENGTH_SHORT);
            t.show();
        }

        DefinirajZadaca();


    }

    public void klik2(View view) {
        if (koeKopce == 1) {
            poeni++;
            Toast t = Toast.makeText(this, "ТОЧНО", Toast.LENGTH_SHORT);
            t.show();
        } else {
            poeni--;
            Toast t = Toast.makeText(this, "ГРЕШКА", Toast.LENGTH_SHORT);
            t.show();
        }

        DefinirajZadaca();
    }

    public void klik3(View view) {

        if(koeKopce==2){
            poeni++;
            Toast t = Toast.makeText(this,"ТОЧНО", Toast.LENGTH_SHORT);
            t.show();
        }else
        {
            poeni--;
            Toast t = Toast.makeText(this,"ГРЕШКА", Toast.LENGTH_SHORT);
            t.show();
        }

        DefinirajZadaca();

    }
}
