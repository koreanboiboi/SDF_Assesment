package task01;

public class MailMerge {

    public void read(String data) {

        if ((null == data) || (data.trim().length() <= 0))
            return;

        String[] fields = data.split(",");

        String f1 = removeN(fields[0]);
        String f2 = removeN(fields[1]);
        String f3 = removeN(fields[2]);
        String f4 = removeN(fields[3]);

        // System.out.printf("%s %s %s %s\n", f1, f2, f3, f4);

        System.out.println(f3);
        System.out.printf("Dear %s,\n", f1);
        System.out.printf("Thank you for staying with us over these %s years.\n", f4);


    }
/*
    public void scan(String line) {

        if ((null == line) || (line.trim().length() <= 0))
            return;

        String[] fields = line.split(",");

        String s1 = removeN(fields[0]);
        String s2 = removeN(fields[1]);
        String s3 = removeN(fields[2]);
        String s4 = removeN(fields[3]);

        System.out.printf("Dear %s, %s", s1, s2);
        System.out.printf("Thank you for your interest in our new %s package!\n", s4);
        System.out.printf("For the 2022 Spring promotion, you can sign up for the low low price of $%s!\n\n", s3);
        System.out.println("Safe travels!");

    } */

    private String removeN(String string) {
        return string.replace("\\n", " ");
    }

}
