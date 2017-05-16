package com.example.fulishe;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    FragmentManager fm;
    FragmentTransaction ft;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.nav_newgood)
    Button navNewgood;
    @BindView(R.id.newgood)
    TextView newgood;
    @BindView(R.id.nav_boutique)
    Button navBoutique;
    @BindView(R.id.boutique)
    TextView boutique;
    @BindView(R.id.nav_category)
    Button navCategory;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.nav_cart)
    Button navCart;
    @BindView(R.id.cart)
    TextView cart;
    @BindView(R.id.nav_me)
    Button navMe;
    @BindView(R.id.me)
    TextView me;

    NewGoodFragment newGoodFragment;
    BoutiqueFragment boutiqueFragment;
    CategoryFragment categoryFragment;
    CartFragment cartFragment;
    MeFragment meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(newGoodFragment == null) newGoodFragment = new NewGoodFragment();
        if(boutiqueFragment == null) boutiqueFragment = new BoutiqueFragment();
        if(cartFragment == null) cartFragment = new CartFragment();
        if(categoryFragment == null) categoryFragment = new CategoryFragment();
        if(meFragment == null) meFragment = new MeFragment();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        addAll();
        hideAll();
        ft.commit();
        navNewgood.performClick();
    }

    @OnClick(R.id.nav_newgood)
    public void clickNewgood(){
        ft = fm.beginTransaction();
        ft.hide(boutiqueFragment);
        ft.hide(categoryFragment);
        ft.hide(cartFragment);
        ft.hide(meFragment);
        ft.show(newGoodFragment);
        ft.commit();
        selectnewgoodBackground();
    }

    @OnClick(R.id.nav_boutique)
    public void clickBoutique(){
        ft = fm.beginTransaction();
        ft.hide(newGoodFragment);
        ft.hide(categoryFragment);
        ft.hide(cartFragment);
        ft.hide(meFragment);
        ft.show(boutiqueFragment);
        ft.commit();
        selectBoutiqueBackground();
    }

    @OnClick(R.id.nav_category)
    public void clickCategory(){
        ft = fm.beginTransaction();
        ft.hide(newGoodFragment);
        ft.hide(boutiqueFragment);
        ft.hide(cartFragment);
        ft.hide(meFragment);
        ft.show(categoryFragment);
        ft.commit();
        selectCategoryBackground();
    }

    @OnClick(R.id.nav_cart)
    public void clickCart(){
        ft = fm.beginTransaction();
        ft.hide(newGoodFragment);
        ft.hide(categoryFragment);
        ft.hide(boutiqueFragment);
        ft.hide(meFragment);
        ft.show(cartFragment);
        ft.commit();
        selectCartBackground();
    }

    @OnClick(R.id.nav_me)
    public void clickMe(){
        ft = fm.beginTransaction();
        ft.hide(newGoodFragment);
        ft.hide(categoryFragment);
        ft.hide(cartFragment);
        ft.hide(boutiqueFragment);
        ft.show(meFragment);
        ft.commit();
        selectMeBackground();
    }

    private void addAll(){
        ft.add(R.id.container,newGoodFragment);
        ft.add(R.id.container,boutiqueFragment);
        ft.add(R.id.container,categoryFragment);
        ft.add(R.id.container,cartFragment);
        ft.add(R.id.container,meFragment);
    }

    private void hideAll(){
        ft.hide(newGoodFragment);
        ft.hide(boutiqueFragment);
        ft.hide(categoryFragment);
        ft.hide(cartFragment);
        ft.hide(meFragment);
    }

    private void selectnewgoodBackground(){
        /*navBoutique.setBackgroundResource(R.drawable.home_tab_home_pressed);
        tab_me.setBackgroundResource(R.drawable.home_tab_mine);*/

        newgood.setTextColor(getColors(android.R.color.holo_red_light));
        boutique.setTextColor(getColors(android.R.color.black));
        category.setTextColor(getColors(android.R.color.black));
        cart.setTextColor(getColors(android.R.color.black));
        me.setTextColor(getColors(android.R.color.black));

    }

    private void selectBoutiqueBackground(){
        /*navBoutique.setBackgroundResource(R.drawable.home_tab_home_pressed);
        tab_me.setBackgroundResource(R.drawable.home_tab_mine);*/

        boutique.setTextColor(getColors(android.R.color.holo_red_light));
        newgood.setTextColor(getColors(android.R.color.black));
        category.setTextColor(getColors(android.R.color.black));
        cart.setTextColor(getColors(android.R.color.black));
        me.setTextColor(getColors(android.R.color.black));

    }

    private void selectCategoryBackground(){
        /*navBoutique.setBackgroundResource(R.drawable.home_tab_home_pressed);
        tab_me.setBackgroundResource(R.drawable.home_tab_mine);*/

        category.setTextColor(getColors(android.R.color.holo_red_light));
        boutique.setTextColor(getColors(android.R.color.black));
        newgood.setTextColor(getColors(android.R.color.black));
        cart.setTextColor(getColors(android.R.color.black));
        me.setTextColor(getColors(android.R.color.black));

    }

    private void selectCartBackground(){
        /*navBoutique.setBackgroundResource(R.drawable.home_tab_home_pressed);
        tab_me.setBackgroundResource(R.drawable.home_tab_mine);*/

        cart.setTextColor(getColors(android.R.color.holo_red_light));
        boutique.setTextColor(getColors(android.R.color.black));
        category.setTextColor(getColors(android.R.color.black));
        newgood.setTextColor(getColors(android.R.color.black));
        me.setTextColor(getColors(android.R.color.black));

    }

    private void selectMeBackground(){
        /*navBoutique.setBackgroundResource(R.drawable.home_tab_home_pressed);
        tab_me.setBackgroundResource(R.drawable.home_tab_mine);*/

        me.setTextColor(getColors(android.R.color.holo_red_light));
        boutique.setTextColor(getColors(android.R.color.black));
        category.setTextColor(getColors(android.R.color.black));
        cart.setTextColor(getColors(android.R.color.black));
        newgood.setTextColor(getColors(android.R.color.black));

    }

    public int getColors(int id) {
        return getResources().getColor(id);
    }
}
