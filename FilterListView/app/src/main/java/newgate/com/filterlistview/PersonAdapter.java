package newgate.com.filterlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by apple on 3/25/18.
 */

public class PersonAdapter extends BaseAdapter implements Filterable {

    private Context context;

    private ArrayList<Person> arrayPerson;

    private CustomFilter filter;

    private ArrayList<Person> filterArray;

    public PersonAdapter(Context context, ArrayList<Person> arrayPerson) {
        this.context = context;
        this.arrayPerson = arrayPerson;
        this.filterArray = arrayPerson;
    }

    @Override
    public int getCount() {
        return arrayPerson.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayPerson.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_person, viewGroup, false);
        }

        TextView nameText = (TextView)view.findViewById(R.id.name_text);
        ImageView avatar = (ImageView)view.findViewById(R.id.avatar);

        nameText.setText(arrayPerson.get(i).getName());
        avatar.setImageResource(arrayPerson.get(i).getImg());

        return view;
    }

    @Override
    public Filter getFilter() {
        if(filter == null) {
            filter = new CustomFilter();
        }
        return filter;
    }

    class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if(charSequence != null && charSequence.length() > 0) {
                charSequence = charSequence.toString().toLowerCase();
                ArrayList<Person> filters = new ArrayList<>();
                for(int i = 0; i < filterArray.size(); i++) {
                    if(VNCharacterUtils.removeAccent(filterArray.get(i).getName().toLowerCase()).contains(charSequence)) {
                        filters.add(filterArray.get(i));
                    }
                }
                results.count = filters.size();
                results.values = filters;
            } else {
                results.count = filterArray.size();
                results.values = filterArray;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            arrayPerson = (ArrayList<Person>)results.values;
            notifyDataSetChanged();
        }
    }
}
