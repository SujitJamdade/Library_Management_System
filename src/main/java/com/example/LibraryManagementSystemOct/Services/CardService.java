package com.example.LibraryManagementSystemOct.Services;

import com.example.LibraryManagementSystemOct.Entities.LibraryCard;
import com.example.LibraryManagementSystemOct.Entities.Student;
import com.example.LibraryManagementSystemOct.Enums.CardStatus;
import com.example.LibraryManagementSystemOct.Repository.CardRepository;
import com.example.LibraryManagementSystemOct.Repository.StudentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class CardService {


    @Autowired
    CardRepository cardRepository;

    @Autowired
    StudentRepository studentRepository;

    public LibraryCard generatePlainCard() {

        LibraryCard card = new LibraryCard();

        card.setCardStatus(CardStatus.NEW);

        cardRepository.save(card);

        return card;
    }

    public String associateWithStudent(Integer studentId, Integer cardNo) {

        // we have PK of Student and Library card
        //But I need the Entities to set attributes and save

        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student = optionalStudent.get();

        Optional<LibraryCard> optionalCard = cardRepository.findById(cardNo);
        LibraryCard card = optionalCard.get();

        // Setting the required attribute of Library Card Entity
        card.setCardStatus(CardStatus.ACTIVE);
        card.setNameOnCard(student.getName());
        card.setStudent(student);

        // Setting the attribute of Student Entity
        // while adding student we set all attribute except library card
        student.setLibraryCard(card);

        studentRepository.save(student);  // saving student bz it is parent it will cascade

        return "Card No " + cardNo + " has been associated to student " + student.getName();
    }
}
