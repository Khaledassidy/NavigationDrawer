package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

/*

hala2 badna net3alam keef na3mel navigation drawer how 3ebara 3an tool bar fe icon 3 sha7tat fo2 ba3d btekbous 3lyha btbyen ka2eme 3al shemmel feha button kel ma tekbes wa7de mn l button byet8ayar l me7tawa le bel nous ya3ne kel ma tekbous button bt8yaer l fragemnt
badna na3ml navigation drawer feha 3 button ya3ne feha 3 fragemnt kel button btkbousa bten2lak 3ala 8eer fragemnt ya3ne 3ana gallary,news,home hawde l 3 kel wa7de 3anda fragment w bas tekbous 3ala wa7de byetla3lk l fragemnt ta3ela ma3 esm l screen 3al toolbar
w heda navigation drawer byen3amal using navigation commponenet

1-2awl she badna nro7 3ala l build gradle w ndeef 3 dependency le houne l navigation fragemnt ,navigation ui,w l material
2-ba3d ma na3mel l dependency la7 nkoun jehzen la na3mel menue layout mna3mel mnue feha 3 items home,gallary,news fa mna3mel menue feha 3 items 2wal 5etwe
3-ba3d ma na3mel l menu mnrou7 mna3mel create lal fragements 3 fragemnt home,gallary,news
4-ba3d ma 5alsna mn l fragemnt mna3mel l navgraph w mn5ale l ids taba3 l fragemnt nafs l ids taba3 l items le bel menu
5-ba3d ma na3mel setup lal nav graph badna nrou7 3al mainactivity xml houn bade est3mel 2 commponent first commponent are for main container le howe navhost le howe fragmnet containerview w second commponenet are for navigation drawer le howe heda l icon le bas nekbous 3lee byefta7 w bebyen 3ana l navigation items le howe heda l view esmo navigation view l width mn7oto wrapcontent l height matchparent w mna3te l menue le ana 3mlto 3ashen y7ot l items ka navigation le mawjouden bel menue kamen l navigation drawer 3atoul mnle2e ela closed w open la7ata ta3mel heek lezm nest5dem drawerlayout badel l constraint layout l drawer layout hold 2 commponent l main content le heye l fragment w l navigation view l howe sliding pannel hold navigation item(The DrawerLayout provides the built-in sliding mechanism that allows the navigation drawer to slide in and out from the side of the screen.)
6-mnrou7 mna3mel setup lal mainactivity code:
-mnjeeb l navhost ba3den nav controller mn navhost
-w mnjeeb l navigation view
-ba3den badna method tenye la na3mel kamen syncronization toolbar ma3 navcontroller fragment eno kel ma tekbous 3la wa7de yseer title taba3 tool bar nafs l esm bas hay l method bte5od drawerlayout parameter fa howe badel ma nest3mel constraint layout mnest3mel drawer layout kamen hay l method bta3mel ya3ne a n2ol ne7na kabsna 3ala l navigation button tenye hay l button la7ala byet8ayar shakla la arrow back iza kabsta bterja3 3ala l fist destination ya3ne hay resposible la la t8ayer l up button bas ma tkoun 3ala l fist destination w hayde l function connect the icon l heye bteshbah l himberger ma3 l drawerlayout hay l method bt5ale l actionabar le 3lyha up button intearct ma3 l drawerlayout ya3ne heye sa7 bt7ot l hamberger icon bas iza jena la nokbous 3lyha mesh 7a ne2dar fa sho mna3mel ya3ne hay l function be25tesar bt5le l hamberger icon ybyen w l arrow icon ybyen w bta3mel intearct ma3 l drawer layout bshakl eno iza keen open ybyen l arrow iza keen closed ybyen l hamberger icon (iza kona 3ala l fist destination) bas hawde l icon ma fena na3mel ma3oun intearct bas bebyno la heek jena 3mlna ActionbarDrawerTogle bas bala l function l NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout); w jena 3mlna object mn actionbartogle ma btbyen l kabse ya3ne feek te3tebr l function l setupactionbarwithnavcontroller heye enable l ahmberger icon w l arrow icon baleha ma fena
-variable mn l ActionbarTogle hayde la ta3mele toogle 3al icon le mawjoud bel tool bar le byefta7 l navigation drawer ya3ne howe l navigation view l2no ne7na ma frna na3ml interact ma3 l hamberger icon w l arrow icon ta3et l navigationUI ne7na badna na3mel kabse mn 5elel hayde w ba3den nest3mel method mawjoude bel drawerlayout  metl listner esma addrawer listner bte5od draweractiontoggle le howe kabset l 3 sha7tat fo2 ba3da hay bta3teha l icon heda w btseer ma bta3mel l drawer layout slide 2aw btsaker ela iza kabsneha ya3ne btkoun 3am t2olo lal drawerlayout ma ta3mel slide ela iza nkabas 3ala hayde l button l heye l icon w hayde l icon bte8ayar iza kena open btabyen arrow w iza closed btabyen hamberger icon
-la ta3mel obejct mn actionbartogle w ta3teha lal drawerlayout.addrawerlistner bte5od l actionbar drawer toggle 2awl parameter l activity le heye this tene parameter drawerlayout 3 parameter w rabe3 parameter mn7otoun 0 houne 3ebra 3an content discription lal accesbility settings in case if someone blind can be string resources hawde l 2 parameter bas na3mel actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close); hay l method bta3mel attach lal hamberger icon 3ala l drawerlayout lesh 3mlna heek ma3 2no iza shelneha 7a ydal fe hamberger icon l2no hedek l icon ma fena nosala sa7 betbyen bas ma fena ned8at 3lyha drawerLayout.addDrawerListener(actionBarDrawerToggle); w hay l method ensure that toggle button listen lal drawer evnet like open and cloese
-ba3den 3ashen na3mel sencronize l navigation drawer ma3 l fragment ya3ne l navcontroller w na3mel lisner 3lyhoun yseer bas tekbous 3a wa7de tente2l 3al fragment le l id taba3o naf id l navigation item NavigationUI.setupnavigationcontroller
-ba3den ba3mel object mn l actionbartogle w ba3teha lal drawerlayout.draerlayoutlistner()
-w e5er she b2olo lal actionbartoggle.syncstate 3ashen ya3mel l toglebutton syncronize ma3 l navigationdrawer ya3ne bas ya3ne enta bas tekbous 3ala 3 wa7de bel navigation badel l humberger icon bseer arrow 3ashn ta3mel syncronization ma3a ya3ne ydal iza ma kenet 3ala 2awl ditation yehar l arrow w iza kenet 3ala 2awl destination tezhar l hamberger icon bat3mel sync been l open w l closed


note:
 actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

                                            vs

NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);

hawde le tnen function 3andoun 5asa2es moshtarke eno tnynetoun be7oto 3ala l tool bar l hamberger icon bas tkoun layout msakra w arrow bas tkoun maftou7a bas l e5telef eno
method l setupnavigationactionbar bta3mel syncronize lal title ta3el l appbar btseer t8ayro kel ma t8ayar l fragemnt w kamen ne7na mne2dar nest3mel bas hay w ma nest3mel l togleactionbar bas bseet badna nesta3mel configuration method
ama l actionbar toggle heye bt7ot l hamberger sandwich 3ala l toool bar bas tkoun closed w bt7ot l arrow bas tkoun closed w ba3den 3ashn t byane lezm nest3mel method bel supportactipnbar esma getSupportActionBar().setDisplayHomeAsUpEnabled(true); w byemshe l 7al w fena sa3eta neshte8l bala l setupactionbar bas l title sa3eta ma 7a yet8ayr hay l2ossa kola
ya3ne ne7na jebna mn kel wa7de l benfit ta3ela jebna l benfit mn l setup 3ashen title w l benfit mn togleactionbar 3ashen tbyen l sandwich icon ma3 l arrow icon w na3mel lisner




ba3den mna3mel onoptionitemselected()
hay l method bas nekbous 3ala l hamberger icon btrj3lk yeh
enta bta3mel check iza kenet hay l item reje3t heye actionbartoggle raje3 true iza la2 raje3 false
actionBarDrawerToggle.onOptionsItemSelected(item)
mn 5elel l id heye bta3mel check bte5od l item le rej3 mn l menue btshofo iza l id equll l id taba3 l home le howe name l icon l hamberger le 3ala e5er le shmeel bt2olak togglw ya3ne open 2aw close w return true




3mlna back press costume eno iza keeen 7ada fete7 l drawer layout w 3mel back ysakera 2ama else yetla3 mn l app
best3mel l OnBackPressedDispatcher l2no l onbackpressed is deprecated mna3mela inflate mnerja3 mnest3mel method esma add call back bte5od view 2aw activity ela life cycle 3atyneha l activity bte5od parameter tene esmo new OnBackPressedCallback(true) badna n7ot true l2no hay l call back ma byen3aml call la ela ela isa keen true iza badna nerja3 nwa2efa mn 2ola setenable(false) w 3mlna check iza heye open sakera 8eer heek finish l activity

*/





public class MainActivity extends AppCompatActivity {
    NavHostFragment navHostFragment;
    NavController navController;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    OnBackPressedDispatcher onbackbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navHostFragment=(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if(navHostFragment!=null){
            navController=navHostFragment.getNavController();
        }
        navigationView=findViewById(R.id.nav_drawer);
        drawerLayout=findViewById(R.id.drawer_layout);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);


        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        onbackbutton = this.getOnBackPressedDispatcher();

        onbackbutton.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);

                }else{
                    finish();
                }
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            //or
            //item.getItemId()==android.R.id.home return true
            return true;
        }
        return super.onOptionsItemSelected(item);
    }







}