package cz.java_webapp.godfather_quotes;

import java.io.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.core.io.*;
import org.springframework.core.io.support.*;
import org.springframework.stereotype.*;

@Controller
public class MainController {

    List<Statement> listOfStatements = new ArrayList<>();

    public MainController() throws IOException {
        listOfStatements.add(new Statement(0, "It's not personal. It's strictly bussiness.", true));
        listOfStatements.add(new Statement(1, "Keep your friends close, but your enemies closer.", true));
        listOfStatements.add(new Statement(2, "In this country, you gotta make the money first. Then when you get the money, you get the power. Then when you get the power, then you get the women.", false));
        listOfStatements.add(new Statement(3, "I'm gonna make him an offer he can't refuse.", true));
        listOfStatements.add(new Statement(4, "Some day, and that day may never come, I will call upon you to do a service for me.", true));
        listOfStatements.add(new Statement(5, "I always tell the truth even when I lie", false));
        listOfStatements.add(new Statement(6, "All I have in this world is my balls and my word and I don't break them for no one!", false));
        listOfStatements.add(new Statement(7, "Revenge is a dish best served cold.", true));
        listOfStatements.add(new Statement(8, "Don't tell me that you're innocent. Because it insults my intelligence and it makes me very angry.", true));
        listOfStatements.add(new Statement(9, "Don’t mistake my kindness for weakness. I am kind to everyone, but when someone is unkind to me, weak is not what you are going to remember about me.", false));

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView dataHolder = new ModelAndView("index");
        dataHolder.addObject("statements", listOfStatements);
        return dataHolder;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView showResult(IndexForm entryData) {
        int score = 0;

        for (int i = 0; i < listOfStatements.size(); i++) {
            Statement state = listOfStatements.get(i);
            Statement.TypeOfStatement answer = entryData.getAnswers().get(i);
            if (state.getType().equals(answer)) {
                score++;
            }
        }

        ModelAndView dataHolder = new ModelAndView("result");
        dataHolder.addObject("totalScore", score);
        dataHolder.addObject("totalNumberOfStatements", listOfStatements.size());

        return dataHolder;

    }

    @RequestMapping(value = "/correct_answer.html")
    public ModelAndView showCorrectAnswers() {
        ModelAndView dataHolder = new ModelAndView("correct_answer");
        dataHolder.addObject("statements", listOfStatements);
        return dataHolder;
    }
}
