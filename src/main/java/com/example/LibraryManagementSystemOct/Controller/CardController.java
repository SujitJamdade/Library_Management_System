package com.example.LibraryManagementSystemOct.Controller;


import com.example.LibraryManagementSystemOct.Entities.LibraryCard;
import com.example.LibraryManagementSystemOct.Services.CardService;
import jakarta.persistence.Access;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CardController {

    @Autowired
    CardService cardService;

    // Generate the plain Library card for students

    @PostMapping("generatePlainCard")
    public ResponseEntity generatePlainCard(){

        LibraryCard newCard = cardService.generatePlainCard();

        String response = "New card is generated and having card no is " + newCard.getCardNo();

        return new ResponseEntity(response, HttpStatus.OK);
    }


    // We generated the plain card with card numbers
    // now we need to associate the card with student

    @PutMapping("/associateWithStudent")
    public ResponseEntity associateWithStudent(@RequestParam("studentId") Integer studentId, @RequestParam("cardNo") Integer cardNo){

        String response = cardService.associateWithStudent(studentId,cardNo);

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
