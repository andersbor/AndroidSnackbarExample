package dk.easj.anbo.snackbarexample;
// adapted https://www.androidhive.info/2015/09/android-material-design-snackbar-example/

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.mainLinearLayour);
    }

    public void mainButtonSimpleSnackbarButton(View view) {
        Snackbar snackbar = Snackbar
                .make(layout, "Welcome to my app", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void mainButtonSnackbarAction(View view) {
        Snackbar snackbar = Snackbar
                .make(layout, "Message is deleted", Snackbar.LENGTH_LONG)

                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(layout, "Message is restored!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
        snackbar.show();
    }

    public void mainButtonCustomSnackbar(View view) {
        Snackbar snackbar = Snackbar
                .make(layout, "No internet connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

// Changing message text color
        snackbar.setActionTextColor(Color.RED);

// Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }
}
