
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.alobebe.root.myapplication.R.id.action_context_bar;
import static com.alobebe.root.myapplication.R.id.my_awesome_toolbar;

/**
 * Created by root on 05/08/16.
 */
public class ToolbarUI extends AppCompatActivity {

    public Toolbar toolbar;
    private String title;
    private String subTitle;
    private String subTitlecolor;
    private int elevationToolbar;
    private String titleColor;
    private String backgroundColor;
    private Boolean navigationIcon;
    private Context context;
    private Boolean menu;
    private Boolean inflate;
    private TextView titulo;

    public ToolbarUI(String title, String subTitle,int elevationToolbar,Toolbar toolbar, String subTitleColor, String titleColor, String backgroundColor, Context context, Boolean menu, Boolean navigationIcon,Boolean inflate) {

        this.title = title;
        this.subTitle = subTitle;
        this.elevationToolbar = elevationToolbar;
        this.toolbar = toolbar;
        this.subTitlecolor = subTitleColor;
        this.titleColor = titleColor;
        this.backgroundColor = backgroundColor;
        this.navigationIcon = navigationIcon;
        this.context = context;
        this.menu = menu;
        this.inflate = inflate;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setToolbarUI(){
        if(inflate){
            LayoutInflater mInflater= LayoutInflater.from(context);
            View mCustomView = mInflater.inflate(R.layout.textview, null);
            mCustomView.setBackgroundColor(Color.parseColor(backgroundColor));
            titulo = (TextView) mCustomView.findViewById(R.id.custom_toolbar_title);
            titulo.setText(title);
            titulo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Titulo", Toast.LENGTH_LONG).show();
                }
            });
            toolbar.addView(mCustomView);
        }else{
            toolbar.setTitle(title);
            toolbar.setSubtitle(subTitle);
            toolbar.setTitleTextColor(Color.parseColor(titleColor));
            toolbar.setSubtitleTextColor(Color.parseColor(subTitlecolor));
        }
        toolbar.setBackgroundColor(Color.parseColor(backgroundColor));
        toolbar.setElevation(elevationToolbar);
        if(menu) {
            toolbar.inflateMenu(R.menu.main);
            toolbar.setOnMenuItemClickListener(
                    new Toolbar.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            int id = item.getItemId();
                            if (id == R.id.action_scan_qr) {
                                Toast.makeText(context, "Tese", Toast.LENGTH_LONG).show();
                                return true;
                            }
                            return true;
                        }
                    });
        }

        if (navigationIcon) {
            toolbar.setNavigationIcon(R.drawable.ic_face_black_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Navigation", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
