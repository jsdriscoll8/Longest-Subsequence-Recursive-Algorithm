public class Main {
    public static void main(String[] args) {
        String s1 = "ABAZDCZWYY", s2 = "BACBADXYXWY";
        String s3 = "AWBC", s4 = "XYZAAACCIJBKC";
        Analyzer a = new Analyzer();
        Analyzer b = new Analyzer();

        System.out.println(a.LCS(s1, s2));
        System.out.println(b.LCS(s3, s4));
    }
}
