package example.codeclan.com.sqlfun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InstructorActivity extends AppCompatActivity {

    TextView name;
    TextView fav_lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);

        name = (TextView) findViewById(R.id.instructor_name);
        fav_lang = (TextView) findViewById(R.id.fav_lang);

        Bundle bundle = getIntent().getExtras();
        Instructor instructor = (Instructor) bundle.get("instructor");

        name.setText(instructor.getName());
        fav_lang.setText(instructor.getFavourite_language());
    }
}
