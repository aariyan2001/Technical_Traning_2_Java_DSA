public class PlaindromeInBits {
    public static void main(String[] args) {
        int num=2,i=1;
        while(num>0){
            if(i==1 && num==1){
                System.out.println(i);
                return;
            }else if(i==1){
                num--;
                i++;
            }else{
                int value = 0;
                int tmp=i;
                while(tmp>0){
                    if((tmp&1)==0 && value==0){
                        break;
                    }else{
                        value = value<<1;
                        value = value|(tmp&1);
                        tmp = tmp>>1;
                        
                    }
                }
                if(value==i){
                    num--;
                    i++;
                }else{
                    i++;
                }
                
            }
        } 
        System.out.println(i-1);       
    }
}
