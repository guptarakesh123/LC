import java.util.HashSet;
import java.util.Set;

public class LC005 {
    public static void main(String[] args) {
        String s = "babaddtattarrattatddetartrateedredividerb";
        //s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        //s = "anugnxshgonmqydttcvmtsoaprxnhpmpovdolbidqiyqubirkvhwppcdyeouvgedccipsvnobrccbndzjdbgxkzdbcjsjjovnhpnbkurxqfupiprpbiwqdnwaqvjbqoaqzkqgdxkfczdkznqxvupdmnyiidqpnbvgjraszbvvztpapxmomnghfaywkzlrupvjpcvascgvstqmvuveiiixjmdofdwyvhgkydrnfuojhzulhobyhtsxmcovwmamjwljioevhafdlpjpmqstguqhrhvsdvinphejfbdvrvabthpyyphyqharjvzriosrdnwmaxtgriivdqlmugtagvsoylqfwhjpmjxcysfujdvcqovxabjdbvyvembfpahvyoybdhweikcgnzrdqlzusgoobysfmlzifwjzlazuepimhbgkrfimmemhayxeqxynewcnynmgyjcwrpqnayvxoebgyjusppfpsfeonfwnbsdonucaipoafavmlrrlplnnbsaghbawooabsjndqnvruuwvllpvvhuepmqtprgktnwxmflmmbifbbsfthbeafseqrgwnwjxkkcqgbucwusjdipxuekanzwimuizqynaxrvicyzjhulqjshtsqswehnozehmbsdmacciflcgsrlyhjukpvosptmsjfteoimtewkrivdllqiotvtrubgkfcacvgqzxjmhmmqlikrtfrurltgtcreafcgisjpvasiwmhcofqkcteudgjoqqmtucnwcocsoiqtfuoazxdayricnmwcg";
        //s = "jhgtrclvzumufurdemsogfkpzcwgyepdwucnxrsubrxadnenhvjyglxnhowncsubvdtftccomjufwhjupcuuvelblcdnuchuppqpcujernplvmombpdttfjowcujvxknzbwmdedjydxvwykbbamfnsyzcozlixdgoliddoejurusnrcdbqkfdxsoxxzlhgyiprujvvwgqlzredkwahexewlnvqcwfyahjpeiucnhsdhnxtgizgpqphunlgikogmsffexaeftzhblpdxrxgsmeascmqngmwbotycbjmwrngemxpfakrwcdndanouyhnnrygvntrhcuxgvpgjafijlrewfhqrguwhdepwlxvrakyqgstoyruyzohlvvdhvqmzdsnbtlwctetwyrhhktkhhobsojiyuydknvtxmjewvssegrtmshxuvzcbrabntjqulxkjazrsgbpqnrsxqflvbvzywzetrmoydodrrhnhdzlajzvnkrcylkfmsdode";
        //s = "a";
        String op = new LC005().longestPalindrome(s);
        
        System.out.println(op);
    }
    
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int maxi = 0, maxj = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j >= maxj; j--){
                //String r = s.substring(i,j);
                
                if(isPalendrome(s, i, j)){
                    if(maxj - maxi < j - i){
                        maxj = j;
                        maxi = i;
                        break;
                    }
                }
                if(maxj - maxi > j - i){
                    break;
                }
            }
            if( s.length() - i -1 <= maxj - maxi){
                break;
            }
        }
        return s.substring(maxi, maxj + 1);
    }
    private boolean isPalendrome(String s, int i, int j) {
        if (s == null) {
            return false;
        }
        //int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    
    public String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        Set<String> considered = new HashSet<>();
        return longestPalindromeHelper(s, considered);
    }
    
    private String longestPalindromeHelper(String s, Set<String> considered) {
        if (s == null) {
            return s;
        }
        if (considered.contains(s)) {
            return "";
        }
        considered.add(s);
        if (isPalendrome2(s)) {
            return s;
        }
        String left = longestPalindromeHelper(s.substring(1, s.length()), considered);
        String right = longestPalindromeHelper(s.substring(0, s.length() - 1), considered);
        
        if (left.length() >= right.length()) {
            return left;
        }
        return right;
    }
    
    private boolean isPalendrome2(String s) {
        if (s == null) {
            return false;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
