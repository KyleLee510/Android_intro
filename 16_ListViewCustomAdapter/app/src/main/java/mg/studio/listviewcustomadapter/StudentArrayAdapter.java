package mg.studio.listviewcustomadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import java.util.List;

/**
 * This is a custom ArrayAdapter that extends ArrayAdapter
 */

class StudentArrayAdapter extends ArrayAdapter<Student> {
    private int resourceId;

    public StudentArrayAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.studentName = view.findViewById(R.id.tv_student_name);
            viewHolder.studentId = view.findViewById(R.id.tv_student_id);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.studentName.setText(student.getName());
        Log.d(getContext().getPackageName().toString(), student.getName());
        viewHolder.studentId.setText(String.valueOf(student.getStudentId()));
        Log.d(getContext().getPackageName().toString(), String.valueOf(student.getStudentId()));
        return view;

    }


}
