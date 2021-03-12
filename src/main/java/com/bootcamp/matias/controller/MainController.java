package com.bootcamp.matias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MainController {

    @GetMapping("/roman/{number}")
    public String getRomanNumerals(@PathVariable int number){
       String romanNumber = null;
       
        switch (number){
            case 1:
                romanNumber = "I";
                break;
            case 2:
                romanNumber = "II";
                break;
            case 3:
                romanNumber = "III";
                break;
            case 4:
                romanNumber = "IV";
                break;
            case 5:
                romanNumber = "V";
                break;
            case 6:
                romanNumber = "VI";
                break;
            case 7:
                romanNumber = "VII";
                break;
            case 8:
                romanNumber = "IIX";
                break;
            case 9:
                romanNumber = "IX";
                break;
            case 10:
                romanNumber = "X";
                break;


        }
        return romanNumber;
    }

    @GetMapping(path = "/romanTranslator/{number}")
    public String TranslateToRoman(@PathVariable int number) {

        String romanNumbers[] = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number > 0 || arab.length == (i - 1)) {
            while ((number - arab[i]) >= 0) {
                number -= arab[i];
                result.append(romanNumbers[i]);
            }
            i++;
        }
        return result.toString();

    }

    @GetMapping("/morse/{morseCode}")
    public String getMorseCode(@PathVariable String morseCode){
        String letras = "abcdefghijklmnopqrstuvwxyz 0123456789.,?!()[]&:;=+-_$@";
        String codigo[] = new String[60];
        String morse = " ";

        codigo[0] = ".-"; //a
        codigo[1] = "-...";//b
        codigo[2] = "-.-.";//c
        codigo[3] = "-..";//d
        codigo[4] = ".";//e
        codigo[5] = "..-.";//f
        codigo[6] = "--.";//g
        codigo[7] = "....";//h
        codigo[8] = "..";//i
        codigo[9] = ".---";//j
        codigo[10] = "-.-";//k
        codigo[11] = ".-..";//l
        codigo[12] = "--";//m
        codigo[13] = "-.";//n
        codigo[14] = "---";//o
        codigo[15] = ".--.";//p
        codigo[16] = "--.-";//q
        codigo[17] = ".-.";//r
        codigo[18] = "...";//s
        codigo[19] = "-";//t
        codigo[20] = "..-";//u
        codigo[21] = "...-";//v
        codigo[22] = ".--";//w
        codigo[23] = "-..-";//x
        codigo[24] = "-.--";//y
        codigo[25] = "--..";//z
        codigo[26] = "/";//espacio
        codigo[27] = "-----";//0
        codigo[28] = ".----";//1
        codigo[29] = "..---";//2
        codigo[30] = "...--";//3
        codigo[31] = "....-";//4
        codigo[32] = ".....";//5
        codigo[33] = "-....";//6
        codigo[34] = "--...";//7
        codigo[35] = "---..";//8
        codigo[36] = "----.";//9
        codigo[37] = ".-.-.-";//.
        codigo[38] = "--..--";//,
        codigo[39] = "..--..";//?
        codigo[40] = ".-.-..";//!
        codigo[41] = "-.--.";//(
        codigo[42] = "-.--.-";//)
        codigo[43] = "-.--.";//[
        codigo[44] = "-.--.-";//]
        codigo[45] = ".-...";//&
        codigo[46] = "---...";//:
        codigo[47] = "-.-.-.";//;
        codigo[48] = "-...-";//=
        codigo[49] = ".-.-.";//+
        codigo[50] = "-....-";//-
        codigo[51] = "..--.-";//_
        codigo[52] = "...-..-";//$
        codigo[53] = ".--.-.";//@

        String oracion[] = morseCode.split(" ");
        int max = oracion.length;

        for  (int i = 0; i < max; i++){
            for (int j = 0; j < 60; j++)
                if (oracion[i].equals(codigo[j])) {
                    morse = morse+letras.charAt(j);
                    break;
                }
        }
        return morse = morse.substring(1,morse.length()); //quita el espacio que se genera de mas
    }
}
