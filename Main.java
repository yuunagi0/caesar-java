import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Receives a string of encrypted message
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an encrypted message: ");
        String cypherText = scanner.nextLine();

        /*
        1. Convert input to upper case
        2. Convert to ASCII bytes
        */
        byte[] convertedByte = cypherText.toUpperCase().getBytes();

        // Brute-force every single possibility
        System.out.println("[Possible results]");
        for (int i = 1; i < 26; i++) {
            byte[] decryptedByte = new byte[convertedByte.length];
            for (int j = 0; j < convertedByte.length; j++) {

                // Only convert alphabets
                if (convertedByte[j] >= 65 && convertedByte[j] <= 90) {
                    /*
                    1. Convert each character to how far from A (by subtracting 65)
                    2. Shift by the number of i (which is the decryption key)
                    3. Convert that to how far away from A (by calculating the remainder when divided by 26)
                    4. Add 65 back so it would become ASCII bytecode
                    */
                    decryptedByte[j] = (byte) ((((convertedByte[j] - 65) + i) % 26) + 65);
                }
            }
            //Output the result
            System.out.println(new String(decryptedByte));
        }
    }
}