package perm.com.particleanim;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.plattysoft.leonids.ParticleSystem;
import com.transitionseverywhere.AutoTransition;
import com.transitionseverywhere.Crossfade;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;

/**
 * https://blog.csdn.net/mymolit/article/details/79578693
 */
public class MainActivity extends AppCompatActivity {

    Button btnTest;
    ViewGroup root;
    ImageView ivBack;
    View ivFl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTest = findViewById(R.id.btnTest);
        root = findViewById(R.id.root);
        ivBack = findViewById(R.id.ivBack);
        ivFl = findViewById(R.id.ivFl);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
                ivFl.animate().alpha(1).setDuration(6000).start();

                new ParticleSystem((Activity) v.getContext(), 1000, R.mipmap.flower, 12000)
                        .setSpeedModuleAndAngleRange(0.05f, 0.2f, 0, 360)
                        .setRotationSpeed(130)
                        .setAcceleration(0, 90)
                        .oneShot(v, 600, new AccelerateInterpolator());

            }

        });

    }

}
