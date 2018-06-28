package newgate.com.filterlistview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by apple on 3/25/18.
 */

public class MainActivity extends AppCompatActivity {

    private EditText filterEditText;

    private ListView personListView;

    private PersonAdapter adapter;

    private ArrayList<Person> arrayPerson;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filterEditText = (EditText) findViewById(R.id.edit_text_search);

        personListView = (ListView) findViewById(R.id.list_person);

        arrayPerson = new ArrayList<>();

        arrayPerson.add(new Person("Nguyễn Duy Khiêm", R.drawable.steve));
        arrayPerson.add(new Person("Steve Jobs", R.drawable.billgate));
        arrayPerson.add(new Person("Hắc Long - Thiên", R.drawable.rocker));

        adapter = new PersonAdapter(this, arrayPerson);

        personListView.setAdapter(adapter);

        filterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
