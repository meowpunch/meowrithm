package company.amazon;

// Write a function that generates a password. Focus on maintainability and re-usability of code.
/*
    requirements
        - minimum length
        - combination of type of char (number 0 - 9, Capital case, Lower case, special character !@#$%)
        -




    generatePassword()


    new PasswordManger

    Password.



 */


import java.util.Random;


class PasswordManger {


    private static String NUMBERS = "0123456789";
    private static String LOWER_CASES = "abcdefghijklmnopqrstuvwxyz";
    private static String UPPER_CASES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String SPECIAL_CASES = "!@#$%^&*()";

    // set


    /*
        8 length of password
     */
    public String generatePassword(int length, boolean includeNumber, boolean includeLowerCase, boolean includeUpperCase, boolean includeSpecialCase) {
        String candidates = getCandidates(includeNumber, includeLowerCase, includeSpecialCase, includeUpperCase);
        StringBuilder sb = new StringBuilder();

        var random = new Random();
        for (int i = 0; i<length; i++) {
            sb.append(candidates.charAt(random.nextInt(candidates.length())));
        }

        return sb.toString();
    }

    private String getCandidates(boolean includeNumber, boolean includeLowerCase, boolean includeSpecialCase, boolean includeUpperCase) {
        StringBuilder candidates = new StringBuilder();
        if (includeNumber) candidates.append(NUMBERS);
        if (includeLowerCase) candidates.append(LOWER_CASES);
        if (includeUpperCase) candidates.append(UPPER_CASES);
        if (includeSpecialCase) candidates.append(SPECIAL_CASES);

        return candidates.toString();
    }

    public static void main(String[] args){
        var pwdm = new PasswordManger();
        System.out.println(pwdm.generatePassword(21, true, true, true, true));
    }
}

