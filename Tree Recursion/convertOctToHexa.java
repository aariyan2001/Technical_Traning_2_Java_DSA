public class convertOctToHexa {
    public static String octalTobinary(int oct_num,String bin_num) {
        //Termination case
        if(oct_num==0){
            //System.out.println("Binary value of octal number is: "+ bin_num);
            return bin_num;
        }
        //Business logic
        switch(oct_num%10){
            case 0: bin_num = "000"+bin_num;
                    break;
            case 1: bin_num = "001"+bin_num;
                    break;
            case 2: bin_num = "010"+bin_num;
                    break;
            case 3: bin_num = "011"+bin_num;
                    break;
            case 4: bin_num = "100"+bin_num;
                    break;
            case 5: bin_num = "101"+bin_num;
                    break;
            case 6: bin_num = "110"+bin_num;
                    break;
            case 7: bin_num = "111"+bin_num;
                    break;
            case 8: bin_num = "001"+bin_num;
                    break;
            default:System.out.println("Not working!!");
        }
        //Recursive call
        return octalTobinary(oct_num/10, bin_num);
    }

      
    public static String binaryTohexa(String bin_num,String hexa_num) {
        if(bin_num.length()%4!=0){
            bin_num = "0"+bin_num;
            return binaryTohexa(bin_num, hexa_num);
        }
        else{
            if(bin_num.length()==0){
                //System.out.println(hexa_num);
                return hexa_num;
            }
            String substr = bin_num.substring(0,4);
            switch(substr){
                case "0000": hexa_num = hexa_num + "0";
                             break;  
                case "0001":hexa_num = hexa_num + "1";
                             break;
                case "0010":hexa_num = hexa_num + "2";
                             break;
                case "0011":hexa_num = hexa_num + "3";
                             break;
                case "0100":hexa_num = hexa_num + "4";
                             break;
                case "0101":hexa_num = hexa_num + "5";
                             break;
                case "0110":hexa_num = hexa_num + "6";
                             break;
                case "0111":hexa_num = hexa_num + "7";
                             break;
                case "1000":hexa_num = hexa_num + "8";
                             break;
                case "1001":hexa_num = hexa_num + "9";
                             break;
                case "1010":hexa_num = hexa_num + "A";
                             break;
                case "1011":hexa_num = hexa_num + "B";
                             break;
                case "1100":hexa_num = hexa_num + "C";
                             break;
                case "1101":hexa_num = hexa_num + "D";
                             break;
                case "1110":hexa_num = hexa_num + "E";
                             break;
                case "1111":hexa_num = hexa_num + "F";
                             break;
                default: System.out.println("Wrong choice!!");

            }
             return binaryTohexa(bin_num.substring(4), hexa_num);
        }
                
    }

    public static String convert(int n) {
        // your solutions goes here..
        String bin_num = "",hexa_num="";        
        hexa_num = binaryTohexa(octalTobinary(n,bin_num),hexa_num);
        return hexa_num;
    }
    
    public static void main(String[] args) {
        System.out.println(convert(56));
    }
}
