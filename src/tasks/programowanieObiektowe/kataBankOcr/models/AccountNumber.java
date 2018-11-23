package tasks.programowanieObiektowe.kataBankOcr.models;

public class AccountNumber {
    private final String accountNumberToVerify;

    public AccountNumber(String accountNumber) {
        this.accountNumberToVerify = accountNumber;
    }


    public boolean isAccountNumberValid() {
        if(isIllegal()) {
            return false;
        }
        return accountChecksum() == 0;
    }

    public int accountChecksum() {
        int checksumToVerify = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Integer.parseInt(accountNumberToVerify.substring(i,i+1));
            checksumToVerify = checksumToVerify + digit * (9-i) ;
        }
        return checksumToVerify % 11;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountNumber that = (AccountNumber) o;

        if (!accountNumberToVerify.equals(that.accountNumberToVerify)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return accountNumberToVerify.hashCode();
    }

    public boolean isIllegal() {
        return accountNumberToVerify.contains("?");
    }

    @Override
    public String toString() {
        String suffix = "";

        if(isIllegal()) {
            suffix = "_ILLEGAL";
        }
        if(!isAccountNumberValid()) {
            suffix = "_ERROR";
        }
        return accountNumberToVerify + suffix;
    }
}