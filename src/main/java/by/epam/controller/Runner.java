package by.epam.controller;

import by.epam.bean.Candy;
import by.epam.controller.builder.BuilderFactory;
import by.epam.controller.builder.BuilderKey;
import by.epam.controller.builder.impl.Director;
import by.epam.controller.builder.impl.DomBuilder;
import by.epam.controller.builder.impl.SaxBuilder;
import by.epam.controller.builder.impl.StaxBuilder;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        DomBuilder domBuilder = (DomBuilder) BuilderFactory.getInstance().getBuilder(BuilderKey.DOM);
        SaxBuilder saxBuilder = (SaxBuilder) BuilderFactory.getInstance().getBuilder(BuilderKey.SAX);
        StaxBuilder staxBuilder = (StaxBuilder) BuilderFactory.getInstance().getBuilder(BuilderKey.STAX);

        List<Candy> candiesDom = null;
        List<Candy> candiesSax = null;
        List<Candy> candiesStax = null;
        try {
            candiesDom = Director.build("candy.xml", domBuilder);
            candiesSax = Director.build("candy.xml", saxBuilder);
            candiesStax = Director.build("candy.xml", staxBuilder);
        } catch (IOException | XMLStreamException | SAXException e) {
            e.printStackTrace();
        }

        System.out.println(candiesDom);
        System.out.println(candiesSax);
        System.out.println(candiesStax);
    }
}
