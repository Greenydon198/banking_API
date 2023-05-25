package com.driver;

public class CurrentAccount extends BankAccount{
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    private String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception\
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String s = tradeLicenseId;
        int len = s.length();
        int ch[] = new int[26];

        //check if every char is Uppercase
        for(int i=0;i<len;i++){
//            if(s.charAt(i)>='A' && s.charAt(i)<='Z')
                ch[s.charAt(i)-'A']++;
//            else
//                throw new RuntimeException("Valid License can not be generated");
        }

        boolean flag = true;

        for(int i=1;i<len;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                flag = false;
                break;
            }
        }
        //if(no consecutive characters are present) return
        if(flag)return;
        int max = 0;
        for(int i=0;i<26;i++){
            if(ch[i]>ch[max])
                max = i;
        }
        if(ch[max]>Math.ceil(len/2))
            throw new RuntimeException("Valid License can not be generated");

        char val[] = new char[len];

        int ind = 0;
        for(int i=0;i<26;i++){
            while(ch[i]>0){
                val[ind] = (char)('A'+i);
                ind +=2;
                ch[i]--;
                if(ind>=len)ind = 1;
            }
        }
        tradeLicenseId = new String(val);
//        System.out.println(tradeLicenseId);
    }

}
