package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.io;

import by.it_academy.controller.parsers.ParseJson;
import by.it_academy.entity.School;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Паттерн адаптер. Делает из json'овского файла xml'евский.
 */

public class Adapter {



    public static void adapterJsonToXml() {
        ParseJson parseJson = new ParseJson();
        School school = parseJson.parse();
        createXML(school);

    }

    public static void createXML(School school) {

        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("school");
            doc.appendChild(rootElement);
            Element schoolName = doc.createElement("schoolName");
            schoolName.appendChild(doc.createTextNode(school.getSchoolName()));
            rootElement.appendChild(schoolName);
            for (int i = 0; i < school.getGroups().size(); i++) {
                Element group = doc.createElement("group");
                rootElement.appendChild(group);
                Element groupName = doc.createElement("groupName");
                groupName.appendChild(doc.createTextNode(school.getGroups().get(i).getGroupName()));
                group.appendChild(groupName);
                Element teacher = doc.createElement("teacher");
                group.appendChild(teacher);
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(school.getGroups().get(i).getTeacher().getName()));
                Element surname = doc.createElement("surname");
                surname.appendChild(doc.createTextNode(school.getGroups().get(i).getTeacher().getSurname()));
                Element lastname = doc.createElement("lastname");
                lastname.appendChild(doc.createTextNode(school.getGroups().get(i).getTeacher().getLastname()));
                teacher.appendChild(name);
                teacher.appendChild(surname);
                teacher.appendChild(lastname);
                for (int n = 0; n < school.getGroups().get(i).getStudents().size(); n++) {
                    Element student = doc.createElement("student");
                    group.appendChild(student);
                    Element studentname = doc.createElement("name");
                    studentname.appendChild(doc.createTextNode(school.getGroups().get(i).getStudents().get(n).getName()));
                    Element studentsurname = doc.createElement("surname");
                    studentsurname.appendChild(doc.createTextNode(school.getGroups().get(i).getStudents().get(n).getSurname()));
                    Element studentlastname = doc.createElement("lastname");
                    studentlastname.appendChild(doc.createTextNode(school.getGroups().get(i).getStudents().get(n).getLastname()));
                    student.appendChild(studentname);
                    student.appendChild(studentsurname);
                    student.appendChild(studentlastname);
                }
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("school.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
