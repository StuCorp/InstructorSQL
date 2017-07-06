package example.codeclan.com.sqlfun;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 06/07/2017.
 */

public class InstructorListAdapter extends ArrayAdapter<Instructor> {
    public InstructorListAdapter(Context context, ArrayList<Instructor> instructors) {
        super(context, 0, instructors);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.instructor_item, parent, false);
        }

        Instructor currentInstructor = getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.instructor_name); //UPDATED
        name.setText(currentInstructor.getName());

        TextView fav_lang = (TextView) listItemView.findViewById(R.id.fav_lang); //UPDATED
        fav_lang.setText(currentInstructor.getFavourite_language());

        listItemView.setTag(currentInstructor);

        return listItemView;
    }

}
