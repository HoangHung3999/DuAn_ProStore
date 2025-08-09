package fpoly.sonhaph40315_20_6.duan_prostore.useractivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.sonhaph40315_20_6.duan_prostore.R;

public class ProductReview_Activity extends AppCompatActivity {

    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_review);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ImageView[] stars = {
                findViewById(R.id.star1),
                findViewById(R.id.star2),
                findViewById(R.id.star3),
                findViewById(R.id.star4),
                findViewById(R.id.star5)
        };

        int yellow = ContextCompat.getColor(this, R.color.colorPrimary);
        int gray = ContextCompat.getColor(this, R.color.gray);

        for (int i = 0; i < stars.length; i++) {
            final int index = i;
            stars[i].setOnClickListener(v -> {
                for (int j = 0; j < stars.length; j++) {
                    if (j <= index) {
                        stars[j].setColorFilter(yellow, PorterDuff.Mode.SRC_IN);
                    } else {
                        stars[j].setColorFilter(gray, PorterDuff.Mode.SRC_IN);
                    }
                }
            });

        }
    }
}