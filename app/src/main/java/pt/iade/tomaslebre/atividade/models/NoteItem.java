package pt.iade.tomaslebre.atividade.models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class NoteItem {
    private String title;
    private String content;
    private String modificationDate;

    public NoteItem(){
        this("","", " ");
    }
    public NoteItem(String title, String content, String modificationDate) {
        this.title = title;
        this.content = content;
        this.modificationDate = modificationDate;
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

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }
}


