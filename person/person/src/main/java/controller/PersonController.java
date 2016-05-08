package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import model.Person;
import dao.PersonDAOImpl;
import dao.PersonServiceImpl;
 
@Controller
public class PersonController 
{
     @Autowired
     private PersonServiceImpl personService1;
    
    
    /*public void setPersonService(PersonService ps){
        this.personService = ps;
    }*/
   @RequestMapping("/")
    public String abc() 
    {
    return "index";
    }
    
    
    
    
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService1.listPersons());
        return "person";
    }
     
    //For add and update person both
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){
         
        if(p.getId() == 0)
        {
            //new person, add it
            this.personService1.addPerson(p);
        }
        else
        {
            //existing person, call update
            this.personService1.updatePerson(p);
        }
         
        return "redirect:/persons";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
         
        this.personService1.removePerson(id);
        return "redirect:/persons";
    }
  
    //@RequestMapping("/edit/{id}")
  /*  public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }*/
}