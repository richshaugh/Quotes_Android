package safquote.richie.ie.siralexfergusonrandomquotegenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView quotetv;
    TextView detailstv;
    ImageView fergieimage;
    Button btn;
    private Random random;
    private String[] quotearray;
    private String[] detailsarray;
    private int[] mPhotoIds = new int [] { R.drawable.fergie1,
            R.drawable.fergie2, R.drawable.fergie3, R.drawable.fergie4,R.drawable.fergie5,R.drawable.fergie6,R.drawable.fergie7,R.drawable.fergie8,R.drawable.fergie9,R.drawable.fergie10,R.drawable.fergie11,R.drawable.fergie12,R.drawable.fergie13,R.drawable.fergie14,R.drawable.fergie15,R.drawable.fergie16,R.drawable.fergie17,R.drawable.fergie18,R.drawable.fergie19,R.drawable.fergie20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quotetv = (TextView)findViewById(R.id.textView);
        detailstv = (TextView)findViewById(R.id.textView2);
        btn = (Button)findViewById(R.id.quotebtn);
        random = new Random();
        btn.setOnClickListener(this);
        fergieimage = (ImageView)findViewById(R.id.FergieIV);
        quotearray= getResources().getStringArray(R.array.Quotes);
        detailsarray = getResources().getStringArray(R.array.Details);
        initTv();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void initTv(){
        int rand = random.nextInt(quotearray.length);
        int rand2 = random.nextInt(mPhotoIds.length);
        quotetv.setText(quotearray[rand]);
        detailstv.setText(detailsarray[rand]);

        fergieimage.setImageResource(mPhotoIds[rand2]);
    }

    public void onClick(View v){
        if (v.getId() == R.id.quotebtn)
        {
            initTv();
        }
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
}
