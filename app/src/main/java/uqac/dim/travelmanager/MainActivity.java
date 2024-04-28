package uqac.dim.travelmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import uqac.dim.travelmanager.R;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation de BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Ajoutez un écouteur de navigation pour gérer les sélections de menu
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            // Utilisez une déclaration if-else if-else pour gérer les sélections de menu
            if (itemId == R.id.navigation_home) {
                // Appellez votre méthode pour charger le fragment de carte
                loadMapFragment();
                return true;
            } else if (itemId == R.id.navigation_travel) {
                Intent intentTravel = new Intent(MainActivity.this, TravelActivity.class);
                startActivity(intentTravel);
                return true;
            } else if (itemId == R.id.navigation_add) {
                // Redirige le bouton "Ajouter" vers l'activité CreerVoyageActivity
                Intent intent = new Intent(MainActivity.this, CreerVoyageActivity.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.navigation_favorites) {
                //Intent intentFavorites = new Intent(MainActivity.this, FavoritesActivity.class);
                //startActivity(intentFavorites);
                return true;
            } else if (itemId == R.id.navigation_options) {
                //Intent intentOptions = new Intent(MainActivity.this, OptionsActivity.class);
                //startActivity(intentOptions);
                return true;
            }

            // Si aucun des éléments ne correspond, renvoyez false
            return false;
        });

        // Chargez le fragment de carte au démarrage s'il n'y en a pas déjà un
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null) {
            loadMapFragment();
        }
    }


        // Vous avez déjà une écoute d'événement pour le bouton "Ajouter"
        // Vous pouvez le laisser tel quel ou supprimer le code ci-dessous
        // si vous utilisez `setOnItemSelectedListener` pour gérer le bouton "Ajouter"
        // dans le menu de navigation.

        // ImageButton imageButtonCreerVoyage = findViewById(R.id.btn_plus);
        // imageButtonCreerVoyage.setOnClickListener(v -> {
        //     Intent intent = new Intent(MainActivity.this, CreerVoyageActivity.class);
        //     startActivity(intent);
        // });


    // Méthode pour charger le fragment de carte
    private void loadMapFragment() {
        MapFragment mapFragment = new MapFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, mapFragment);

        transaction.commit();
    }

    // Ajoutez d'autres méthodes comme loadVoyagesFragment(), loadFavoritesFragment(), loadOptionsFragment()
    // pour gérer le remplacement des fragments en fonction des éléments sélectionnés dans BottomNavigationView
}
