package pt.iade.tomaslebre.atividade.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class NoteItem implements Serializable {
    private int id;
    private String title;
    private String content;
    private Calendar creationDate;
    private Calendar modificationDate;

    public NoteItem(){

        this(1,"","", Calendar.getInstance() );
    }
    public NoteItem(int id, String title, String content, Calendar modificationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modificationDate = modificationDate;
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


