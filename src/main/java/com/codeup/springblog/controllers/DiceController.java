package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice/roll-dice";
    }

    @GetMapping("/roll-dice/{roll}")
    public String rollDice(@PathVariable int roll, Model model) {

        int rn = (int) (Math.random() * 6 + 1);
        int rn2 = (int) (Math.random() * 6 + 1);
        int rn3 = (int) (Math.random() * 6 + 1);

        ArrayList<Integer> randomNums = new ArrayList<>();
        randomNums.add(rn);
        randomNums.add(rn2);
        randomNums.add(rn3);



        int resultNum = 0;


        if (rn == roll) {
            resultNum += 1;
        }
        if (rn2 == roll) {
            resultNum += 1;
        }
        if (rn3 == roll) {
            resultNum += 1;
        }




        model.addAttribute("randomNumbers", randomNums);
//        model.addAttribute("result", result);
        model.addAttribute("roll", roll);
        model.addAttribute("resultNum", resultNum);


        return "roll-dice/roll-dice";
    }


}
