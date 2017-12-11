package wad.newsdatabase;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewsDatabaseController {
    
    @Autowired
    private NewsRepository todoRepository;
   
    
    @PostConstruct
    public void createData(){
        Article article = new Article(
            "Riku pääsi wepasta läpi!",
             "Vastoin kaikkia odotuksia, Riku suoritti Web-palvelinojelmistot- kurssin. Tilastot ennustivat syksyllä vielä aivan toista", 
             "Riku Helsingin Yliopistosta, suoritti juuri hyväksytysti wepan. Tutkijat ovat ihmeissään, ja salaliittoteoriat vellovat. Huhutaan, että armolisäpisteitä olisi herunut kurssin vetäjältä, Artolta.Tämä olisi poikkeuksellista, sillä kurssityö oli hätäisesti kasaan raavittu, ja tehtävätkin jäivät kurssin keskiarvosta hälyttävästi. Kukaan ei tiedä varmasti mikä on syy läpipääsyyn, mutta varmaa on se, että Ruokonen juhlii.",
        "http://blogs.staffs.ac.uk/student-blogs/files/2016/08/iStock_28423686_MEDIUM.jpg",
         "Riku Ruokonen");
        todoRepository.save(article);
        Article a2 = new Article(
        "Matti Nykänen söi kilon mansikoita",
             "Matti nykänen on syönyt kilon mansikoita.", 
             "Entinen mäkikotka Matti Nykänen ei taivu mansikoidenkaan edessä. 'Kilo niitä meni! Hehkuttaa Matti'. Mahakipu kuulemma kuuluu asiaan. Mansikat ovat Matin lemppareita. Ehkä ensi kesänä mustikoita, tuumii Matti!",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Matti_Nyk%C3%A4nen_2014-01-30_001.jpg/1200px-Matti_Nyk%C3%A4nen_2014-01-30_001.jpg",
         "Cheek");
        todoRepository.save(a2);    }
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute
        ("items", this.todoRepository.findAll());
        return "index";
    }
    
    
    @PostMapping("/")
    public String post(@RequestParam String name, @RequestParam String ingress, @RequestParam String content, @RequestParam String url, @RequestParam String author) {
        Article item = new Article(name, ingress, content, url, author);
        todoRepository.save(item);
       

        return "redirect:/";
    }
    
    @GetMapping("/{itemId}")
    public String findOne(Model model, @PathVariable Long itemId) {
        Article t1 = todoRepository.getOne(itemId);
        t1.count();
        t1 = this.todoRepository.saveAndFlush(t1);
        model.addAttribute("item", t1);
        return "item"; 
    }
    
    
  
    @DeleteMapping("/{itemId}")
    public String remove(@PathVariable Long itemId) {
        todoRepository.deleteById(itemId);
        
        return "redirect:/";
    }
      

}
