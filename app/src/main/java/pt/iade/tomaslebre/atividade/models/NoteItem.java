package pt.iade.tomaslebre.atividade.models;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import pt.iade.tomaslebre.atividade.utilities.WebRequest;

public class NoteItem implements Serializable {
    private int id;
    private String title;
    private String content;
    //private Calendar creationDate;
    private Calendar modificationDate;

    public NoteItem(){

        this(0,"","", new GregorianCalendar());
    }
    public NoteItem(int id, String title, String content, Calendar modificationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modificationDate = modificationDate;
    }

    public boolean isSameAs(NoteItem otherNote) {
        return this.title.equals(otherNote.title) && this.content.equals(otherNote.content);
    }

    public static void List(ListResponse response){
        ArrayList<NoteItem> items = new ArrayList<NoteItem>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/atividade/list"));
                        String resp = req.performGetRequest();

                        // Get the array from the response.
                        JsonObject json = new Gson().fromJson(resp, JsonObject.class);
                        JsonArray arr = json.getAsJsonArray("items");
                        ArrayList<NoteItem> items = new ArrayList<NoteItem>();
                        for (JsonElement elem : arr) {
                            items.add(new Gson().fromJson(elem, NoteItem.class));
                        }

                        response.response(items);
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("NoteItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

    public static void GetById(int id, GetByIdResponse response){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/atividade/" + id));
                        String resp = req.performGetRequest();

                        response.response(new Gson().fromJson(resp, NoteItem.class));
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("NoteItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void save(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        if (id == 0) {
                            // This is a brand new object and must be a INSERT in the database.
                            WebRequest req = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/atividade/new"));
                            String response = req.performPostRequest(NoteItem.this);

                            // Get the new ID from the server's response.
                            NoteItem respItem = new Gson().fromJson(response, NoteItem.class);
                            id = respItem.getId();
                        } else {
                            // This is an update to an existing object and must use UPDATE in the database.
                            WebRequest req = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/atividade/" + id));
                            req.performPostRequest(NoteItem.this);
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("NoteItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Calendar modificationDate) {
        this.modificationDate = modificationDate;
    }
    public interface ListResponse{
        public void response(ArrayList<NoteItem> items);
    }
    public interface GetByIdResponse{
        public void response(NoteItem item);
    }

}


