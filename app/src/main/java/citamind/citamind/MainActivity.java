package citamind.citamind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected EditText user;
    protected EditText mdp;
    protected TextView error_combi;
    protected int error_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.identifiant);
        mdp = (EditText) findViewById(R.id.motdepasse);
        error_combi = (TextView) findViewById(R.id.mauvaisecombinaison);
        error_count = 0;

        error_combi.setVisibility(View.GONE);
    }

    public void identification(View view){
        if(user.getText().toString().equals("admin") && mdp.getText().toString().equals("projet"))
        {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            MainActivity.this.finish();
        }else{
            error_count++;
            user.getText().clear();
            mdp.getText().clear();
            error_combi.setText("Mauvaise combinaisons utilisateur/mot de passe !"+"("+error_count+")");
            error_combi.setVisibility(View.VISIBLE);
        }
    }

    public void inscription(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
