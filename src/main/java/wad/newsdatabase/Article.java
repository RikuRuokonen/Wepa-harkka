/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.newsdatabase;

import com.gargoylesoftware.htmlunit.javascript.host.intl.DateTimeFormat;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author riku
 */
@Entity
public class Article extends AbstractPersistable<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "name", length = 1000)
    private String name;
    @Column (name = "ingress", length = 2000)
    private String ingress;
    @Column (name = "content", length = 24000)
    private String content;
    @Column (name = "url", length = 24000)
    private String url;
    @Column (name = "checked")
    private int checked;
    @Column (name = "author", length = 400)
    private String author;
    @Column(name = "date")
    private String paiva;
    
    
    

    public Article() {
    }

    public Article(String name, String ingress, String content, String url, String author) {
        this.name = name;
        this.ingress = ingress;
        this.content = content;
        this.url = url;
        this.checked= 0;
        this.author = author;      
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


    public void setName(String name) {
        this.name = name;
    }
    
    public void setChecked(int checked) {
        this.checked = checked;
    }
    
    public int getChecked() {
        return checked;
    }
    
    public void count(){
        this.checked++;
    }
    
    public String getIngress() {
        return ingress;
    }

    public void setIngress(String ingress) {
        this.ingress = ingress;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    } 

}
    
