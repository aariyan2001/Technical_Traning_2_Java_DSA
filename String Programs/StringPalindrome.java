class StringPalindrome{
    public static void main(String[] args) {
        String s = "abba";
        //First Approach - making string revrese and check (N loop run)
        String r = "";
        for(int i=s.length()-1;i>=0;i--){
            r = r+""+s.charAt(i);
        }
        //System.out.println(r);
        if(r.compareTo(s)==0){
            System.out.println("String is palindrome");
        }
        else{
            System.out.println("Not a Palindrome");
        }

        //Second Approach - Using two pointer approch (N/2 loop run)
        if(s.length()%2==0){
            int ptr1 = (s.length()-1)/2;
            int ptr2 = (s.length()/2);
            int flag=1;
            while(ptr1>=0 && ptr2<s.length()){
                if(s.charAt(ptr1)==s.charAt(ptr2)){
                    ptr2++;
                    ptr1--;
                }
                else{
                    flag=0;
                    System.out.println("Not a palindrome");
                    break;
                }
            }
            if(flag==1){
                System.out.println("Is a palindrome");
            }
            
        }else{
            int flag =1;
            int ptr1 = s.length()/2;
            int ptr2 = s.length()/2;
            while(ptr1>0 && ptr2<s.length()){
                if(s.charAt(ptr1)==s.charAt(ptr2)){
                    ptr2++;
                    ptr1--;
                }
                else{
                    flag=0;
                    System.out.println("Not a palindrome");
                    break;
                }
            }
            if(flag==1){
                System.out.println("Is a palindrome");
            }
        }

        //Third Approach same as second aprroach just implement pointer from ends not from mid
    }

}