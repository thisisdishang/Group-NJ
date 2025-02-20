package Java;

/* Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would
 become a2b1c5a3. If the compressed string would not become smaller than the original string, your method should return the original string.
 You can assume the string has only uppercase and lowercase letters (a-z). */

class E1 {
    public static String myCompressed(String s){
        if(s==null || s.length()<=1){
            return s;
        }

        StringBuffer sb = new StringBuffer();
        int count = 1;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                sb.append(s.charAt(i-1));
                sb.append(count);
                count = 1;
            }
        }

        // append the last character and its count
        sb.append(s.charAt(s.length()-1));
        sb.append(count);

        return sb.length()<s.length()?sb.toString():s;
    }

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(myCompressed(s));
    }

}