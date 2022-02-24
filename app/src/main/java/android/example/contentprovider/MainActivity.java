package android.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView cpListView = findViewById(R.id.contentProviderView);

        ContentResolver contentResolver = getContentResolver();

        Uri uriSms = Uri.parse("content://sms/inbox");

        Cursor dataCursor = contentResolver.query(uriSms, null, null, null, null); //  ||
                                                                                                                        //  V
        // similar to select * from table name in sql

        String[] fromCol = new String[]{"body"};
        int[] toTextView = new int[]{android.R.id.text1};

        CursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, dataCursor, fromCol, toTextView);

        cpListView.setAdapter(adapter);
    }
}