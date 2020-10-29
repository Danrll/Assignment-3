class CryptoManager {
  static int LOWER_BOUND = 32;

  static int UPPER_BOUND = 95;

  public static boolean stringInBounds(String plainText) {
    boolean flag = true;
    for (int i = 0; i < plainText.length(); i++) {
      if (
        !(
          (int) plainText.charAt(i) >= LOWER_BOUND &&
          (int) plainText.charAt(i) <= UPPER_BOUND
        )
      ) { //false if any character is outside the bounds
        flag = false;

        break;
      }
    }

    //returns true if all characters are within the allowable bounds

    return flag;
  }

  public static String encryptCaesar(String plainText, int key) {
    //Wrap around the key, if it is greater than the UPPER_BOUND

    key = Wrap_around(key);

    //encrypted text

    String res = "";

    //encryption

    for (int i = 0; i < plainText.length(); i++) {
      res += Character.toString((char) ((int) plainText.charAt(i) + key));
    }

    //return result

    return res;
  }

  public static String decryptCaesar(String encryptedText, int key) {
    //Wrap around the key, if it is greater than the UPPER_BOUND

    key = Wrap_around(key);

    //decrypted text

    String org = "";

    //encryption

    for (int i = 0; i < encryptedText.length(); i++) {
      org += Character.toString((char) ((int) encryptedText.charAt(i) - key));
    }

    //return result

    return org;
  }

  public static int Wrap_around(int key) {
    while (key > UPPER_BOUND) {
      key -= (UPPER_BOUND - LOWER_BOUND);
    }

    return key;
  }

  public static String encryptBellaso(String plainText, String bellasoStr) {
    //encrypted text

    String res = "";

    //Adjust length of bellasoStr to plainText

    while (bellasoStr.length() < plainText.length()) {
      bellasoStr +=
        bellasoStr.substring(0, (plainText.length() - bellasoStr.length()));
    }

    //encryption

    for (int i = 0; i < plainText.length(); i++) {
      char c = (char) Wrap_around(
        (int) plainText.charAt(i) + (int) bellasoStr.charAt(i)
      );

      res += Character.toString(c);
    }

    //return result

    return res;
  }

  public static String decryptBellaso(String encryptedText, String bellasoStr) {
    //decrypted text

    String res = "";

    //Adjust length of bellasoStr to plainText

    while (bellasoStr.length() < encryptedText.length()) {
      bellasoStr +=
        bellasoStr.substring(0, (encryptedText.length() - bellasoStr.length()));
    }

    //decryption

    for (int i = 0; i < encryptedText.length(); i++) {
      char c = (char) Wrap_around(
        (int) encryptedText.charAt(i) - (int) bellasoStr.charAt(i)
      );

      res += Character.toString(c);
    }

    //return result

    return res;
  }
}
