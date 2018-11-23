package tasks.programowanieObiektowe.kataBankTask;

import tasks.programowanieObiektowe.kataBankTask.exceptions.IllegalNumberException;
import tasks.programowanieObiektowe.kataBankTask.exceptions.BankException;
import tasks.programowanieObiektowe.kataBankTask.models.AccountNumber;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Bank {
    List<String> content;
    List<AccountNumber> accountNumbers = new LinkedList<AccountNumber>();
    AccountParser accountParser = new AccountParser();
    int currentLineCount;

    public static void main(String... args) {
        Bank bank = new Bank();
        bank.parseAccounts(args);
    }

    public void parseAccounts(String... strings) {
        if (strings.length == 0) {
            throw new BankException();
        }

        try {
            content = Files.readAllLines(Paths.get(strings[0]), Charset.defaultCharset());
        } catch (IOException e) {
            throw new BankException();
        }

        int line = 1;
        for (String lineContent : content) {
            if (lineContent.length() < 27 && lineContent.trim().length() > 0) {
                throw new BankException("The line number " + line + " is not 27 characters long, but " + lineContent.length() + " characters!");
            }
            line++;
        }

        currentLineCount = content.size() / 4;

        for (int entry = 0; entry < currentLineCount; entry+=4) {
            StringBuilder stringBuilder = new StringBuilder();
            String currentLine = content.get(entry);
            for (int column = 0; column < currentLine.length(); column += 3) {
                char[][] singleAccountNumber = getAccountNumberBy(content, entry, column);
                try {
                    stringBuilder.append(accountParser.accountParse(singleAccountNumber));
                } catch (IllegalNumberException e) {
                    stringBuilder.append("?");
                }
            }
            accountNumbers.add(new AccountNumber(stringBuilder.toString()));
        }

        Path outputFilePath = Paths.get(System.getProperty("user.dir") + File.separator + "src/test/VerifiedAccountNumberOutput.txt");

        List<String> accountNumbersAsString = new ArrayList<String>();
        for(AccountNumber account: accountNumbers) {
            accountNumbersAsString.add(account.toString());
        }

        try {
            Files.write(outputFilePath, accountNumbersAsString, Charset.defaultCharset());
        } catch (IOException e) {
            throw new BankException(e);
        }
    }

    private static char[][] getAccountNumberBy(List<String> content, int entry, int column) {
        char[][] lines = new char[3][3];
        for (int i = 0; i < 3; i++) {
            lines[i] = content.get(entry + i).substring(column, column + 3).toCharArray();
        }
        return lines;
    }
}
