package fi.ptm.contextmenuexample;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;


public class MainActivity extends ListActivity {
    private String [] items= {"John Koch","Peter Michell","Ina Kudson"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items
        ));
        // register contextMenu for this ListActivity
        registerForContextMenu(getListView());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // context menu item
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        // text view in the ListView
        TextView textView = (TextView) info.targetView;
        // name in the TextView
        String name = textView.getText().toString();
        // action
        switch (item.getItemId()) {
            case R.id.action_call:
                Toast.makeText(getBaseContext(), "Call to " + name, Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_SMS:
                Toast.makeText(getBaseContext(), "SMS to "+name, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_email:
                Toast.makeText(getBaseContext(), "Email to "+name, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
