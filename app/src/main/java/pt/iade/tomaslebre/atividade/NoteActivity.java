package pt.iade.tomaslebre.atividade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import pt.iade.tomaslebre.atividade.models.NoteItem;
public class NoteActivity extends AppCompatActivity {
    protected EditText titleEdit;
    protected EditText contentEdit;
    protected TextView dateEdit;
    protected NoteItem item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Intent intent = getIntent();
        item = (NoteItem) intent.getSerializableExtra("item");

        setupComponents();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.save_note){
            finish();

            return true;
        }else if(item.getItemId() == R.id.note_delete){
            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupComponents() {

        setSupportActionBar(findViewById(R.id.toolbar));

        titleEdit = (EditText) findViewById(R.id.note_title);
        contentEdit = (EditText) findViewById(R.id.notes_edit);
        dateEdit = (TextView) findViewById(R.id.note_date);


        populateView();
    }
    protected void populateView(){
        titleEdit.setText(item.getTitle());
        contentEdit.setText(item.getContent());
        dateEdit.setText(new SimpleDateFormat("dd-MM-yyyy").format(item.getModificationDate().getTime()));
    }
}