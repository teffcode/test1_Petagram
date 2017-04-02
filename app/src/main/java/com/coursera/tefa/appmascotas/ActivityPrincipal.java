package com.coursera.tefa.appmascotas;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ActivityPrincipal extends AppCompatActivity {

    /*ArrayList<Contacto> contactos;
  private RecyclerView listaContactos;
  public ContactoAdapter adapter;*/
    private Toolbar toolbar;
   // private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

       // setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("  "+"Petagram");
            getSupportActionBar().setIcon(R.drawable.cat_footprint_52);
        }

    }



}
