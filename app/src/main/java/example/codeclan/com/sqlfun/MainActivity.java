package example.codeclan.com.sqlfun;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        //Clear DB table before inserting again
        db.deleteAllInstructors();


        InstructorList instructors = new InstructorList();
        for (Instructor instructor : instructors.getInstructors()){
            db.addInstructor(instructor);
        }
        ArrayList<Instructor> list = db.getAllInstructors();

        InstructorListAdapter instructorAdapter = new InstructorListAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(instructorAdapter);



        Log.d("READING: ", "Reading all instructors...");
        ArrayList<Instructor> instructorList = db.getAllInstructors();

        for (Instructor instructor : instructorList){
            Log.d("INSTRUCTOR :", "Id: " + instructor.get_id() + ", Name: " + instructor.getName() + ", Fav Language: " + instructor.getFavourite_language());
        }
    }

    public void getInstructor(View listItem) {
        Instructor instructor = (Instructor) listItem.getTag();
        Log.d("Instructor Name: ", instructor.getName());
        Intent intent = new Intent(this, InstructorActivity.class);
        intent.putExtra("instructor", instructor);
        startActivity(intent);
    }
}











