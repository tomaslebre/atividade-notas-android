package pt.iade.tomaslebre.atividade.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class NoteItem implements Serializable {
    private int id;
    private String title;
    private String content;
    private Calendar creationDate;
    private Calendar modificationDate;

    public NoteItem(){

        this(0,"","", Calendar.getInstance() );
    }
    public NoteItem(int id, String title, String content, Calendar modificationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modificationDate = modificationDate;
    }

    public static ArrayList<NoteItem> List(){
        ArrayList<NoteItem> items = new ArrayList<NoteItem>();

        items.add(new NoteItem(1, "Note 1", "Content 1",
                new GregorianCalendar(2020, Calendar.APRIL, 1)));
        items.add(new NoteItem(2, "Note 2", "Content 2",
                new GregorianCalendar(2020, Calendar.APRIL, 2)));
        items.add(new NoteItem(3, "Note 3", "Content 3",
                new GregorianCalendar(2020, Calendar.APRIL, 3)));
        items.add(new NoteItem(4, "Note 4", "Content 4",
                new GregorianCalendar(2020, Calendar.APRIL, 4)));

        return items;
    }

    public static NoteItem GetById(int id){
        return new NoteItem(id, "Note ", "Content ",
                new GregorianCalendar(2020, Calendar.APRIL, 1));
    }

    public void save(){
        if(id == 0){
            id = new Random().nextInt(1000) + 1;
        }else{

        }
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

}


