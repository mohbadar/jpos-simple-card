package home.edu.util;

import java.util.List;

import home.edu.R;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class AppUtil{
	public static ListAdapter createListAdapter(Activity activity, List<String> items){
		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(activity,R.layout.task_row,R.id.rowItem,items);
		return adapter;
	}
}
