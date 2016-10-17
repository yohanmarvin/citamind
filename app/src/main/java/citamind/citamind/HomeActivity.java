package citamind.citamind;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Afficher la appbar en haut de l'activité
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //bottombar init
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        //bottom creation item
        AHBottomNavigationItem home_item = new AHBottomNavigationItem("Home", R.drawable.ic_action_home);
        AHBottomNavigationItem follow_item = new AHBottomNavigationItem("Suivi", R.drawable.ic_action_account_child);
        AHBottomNavigationItem publish_item = new AHBottomNavigationItem("Publier", R.drawable.ic_communication_forum);
        AHBottomNavigationItem notif_item = new AHBottomNavigationItem("Notif", R.drawable.ic_social_whatshot);
        AHBottomNavigationItem myprofil_item = new AHBottomNavigationItem("Profil", R.drawable.ic_social_person);

        //ajout des items
        bottomNavigation.addItem(home_item);
        bottomNavigation.addItem(follow_item);
        bottomNavigation.addItem(publish_item);
        bottomNavigation.addItem(notif_item);
        bottomNavigation.addItem(myprofil_item);

        //couleur de fond
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#3F51B5"));

        //notif
        AHNotification notification = new AHNotification.Builder()
                .setText("9")
                .setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.colorAccent))
                .setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.colorBottomNavigationPrimary))
                .build();
        bottomNavigation.setNotification(notification, 3);

        //couleur item actif/inactif
        bottomNavigation.setAccentColor(Color.parseColor("#FFFFFF"));
        bottomNavigation.setInactiveColor(Color.parseColor("#FFFFFF"));

        //listener
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                return true;
            }
        });
        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                // Manage the new y position
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                //Log.i("BITCH","BETTER HAVE MY MONEY");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
