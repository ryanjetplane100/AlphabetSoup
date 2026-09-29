//Name: Ryan R
//Date: 09/29/26
//Description: This program will help influence the letters in alphabet soup to create words.


public class Soup {
    //these are instance variables 
    private String letters;
    private String company;

    //this is a constructor it sets the instance variables (more on this later in the year)
    //precondition: none
    //postcondition: letters is set to empty and company is set to none
    public Soup(){
        letters ="";
        company = "none";
    }


    //sets the name of the company to the provided name
    //precondition: company is a real string
    //postcondition: the variable company is set to the given string
    public void setCompany(String company){
        this.company = company;
    }

    //precondition: none
    //postcondition: returns the current value of the company variable
    public String getCompany(){
        return company;
    }

    //returns letters
    //precondition: none
    //postcondition: returns the current value of the letters variable
    public String getLetters(){
        return letters;
    }

//below are the functions you'll be writing.

    //adds a word to the pool of letters known as "letters"
    //precondition: word is a non-null string
    //postcondition: word is added to the end of letters
    public void add(String word){
    
        letters += word;

    }


    //Use Math.random() to get a random character from the letters string and return it.
    //precondition: Letters is not null
    //postcondition: returns a random character from letters, or a space if letters is empty
    public char randomLetter(){
        //Precondition makes sure inputting nothing cant break it
        if (letters.length() == 0) {
            return ' ';
        }
        int index = (int)(Math.random() * letters.length());
        return letters.charAt(index);
    }


    //returns the letters currently stored with the company name placed directly in the center of all
    //the letters
    //precondition: none
    //postcondition: returns a string with the company name inserted into the middle of letters
    public String companyCentered(){
        int mid = letters.length() / 2;
        String leftSide = letters.substring(0, mid);
        String rightSide =letters.substring(mid);
        return leftSide + company + rightSide;
    }


    //should remove the first available vowel from letters. If there are no vowels this method has no effect.
    //precondition: none
    //postcondition: the first vowel (a, e, i, o, or u) is removed from letters, or letters is unchanged if there are no vowels
    public void removeFirstVowel(){

        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            if ("AEIOUaeiou".indexOf(c) != -1) {
                letters = letters.substring(0, i) + letters.substring(i + 1);
                break;
            }
        }
    }

    //should remove "num" letters from a random spot in the string letters. You may assume num never exceeds the length of the string.
    //precondition: num is a non-negative integer that does not exceed the length of letters
    //postcondition: num characters are removed from a random spot in letters
    public void removeSome(int num){
        int index = (int)(Math.random() * (letters.length() - num + 1));
        letters = letters.substring(0, index) + letters.substring(index + num);

    }

    //should remove the word "word" from the string letters. If the word is not found in letters then it does nothing.
    //precondition: word is a non-null string
    //postcondition: the first occurrence of word is removed from letters, or letters is unchanged if word is not found
    public void removeWord(String word){
        int index = letters.indexOf(word);
        if (index != -1) {
            letters = letters.substring(0, index) + letters.substring(index + word.length());
        }
    }
}
