import java.util.Arrays;
import java.util.Scanner;

class ArrayOperation{
    int array[];
    int currentsize;

    ArrayOperation(int size){
        array = new int[size];
        currentsize = 0; 
    }

    void add(int index, int element){
        //to add an element at a particular index
        if(currentsize==array.length){
            throw new RuntimeException("\nThe array is full!!");
        }
        else if(index<=currentsize){
            for(int i=currentsize-1;i>=index;i--){
                array[i+1]=array[i];
            }
            array[index] = element;
            currentsize++;
            System.out.println("The elements are added");
        }
        else if(index>currentsize){
            throw new RuntimeException("Insertion of element at location greater than index is not allowed");
        }
        
    }

    void print(){
        //To print the element of an array
        for(int ele: array){
            System.out.print(ele+" ");
        }
    }

    int linearSearch(int searchvalue){
        //Linear search
        for(int i=0; i<currentsize;i++){
            if(searchvalue==array[i]){
                return i;
            }
        }
        return -1;
    }

    void update(int searchvalue, int updatevalue){
        //To update an value
        if(linearSearch(searchvalue)<0){
            throw new RuntimeException("Search value not found!!");
        }else{
            array[linearSearch(searchvalue)]=updatevalue;
            System.out.println("\nThe value is updated");
        }        
    }

    void delete(int delvalue){
        //to delete an element
        if(linearSearch(delvalue)<0){
            throw new RuntimeException("The value not found!!");
        }else{
            for(int i=linearSearch(delvalue);i<currentsize-1;i++){
                array[i]=array[i+1];
            }
            array[currentsize-1]=0;
            currentsize--;
            System.out.println("The value is deleted");
        }
    }

    void sort(){
        //To sort an element
        Arrays.sort(array);
        System.out.println("The array is sorted using sort function(uses dual pivot Quick sort)");
    }

    int Maxele(){
        //To find maximum element
        int max=0;
        for(int i=0;i<currentsize;i++){
            if(array[i]>max){

                max=array[i];
            }
        }
        return max;
    }

    int Minele(){
        //To find minimum element
        int min=array[0];
        for(int i=1;i<currentsize;i++){
            if(array[i]<min){

                min=array[i];
            }
        }
        return min;
    }
}


class ArrayCRUDoperation{
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            ArrayOperation obj = new ArrayOperation(10);

            while(true){
                System.out.println("\n****Operations****\n");
                System.out.println("1. Add an new element");
                System.out.println("2. Update an element");
                System.out.println("3. Delete an element");
                System.out.println("4. Print");
                System.out.println("5. Sort");
                System.out.println("6. Search");
                System.out.println("7. Max Element");
                System.out.println("8. Min Element");
                System.out.println("9. Exit");

                System.out.print("\n Choice: ");
                int choice  = in.nextInt();




                switch(choice){
                    case 1: obj.add(0,100);
                            obj.add(1,200);
                            obj.add(0, 300);
                            obj.add(2, 400);

                            //obj.add(5, 300);
                            break;
                    case 2: obj.update(100,1000);
                            break;

                    case 3: obj.delete(300);
                            break;

                    case 4: obj.print();
                            break;

                    case 5: obj.sort();
                            break;

                    case 6: int val = obj.linearSearch(100);
                            if(val<0){
                                throw new RuntimeException("Search value not found!!");
                            }
                            else{
                                System.out.println("Value found at index: "+ obj.linearSearch(100));
                            }
                            break;

                    case 7: System.out.println("The maximum element : "+ obj.Maxele());
                            break;

                    case 8: System.out.println("The minimum element : "+ obj.Minele());
                            break;
            
                    case 9: System.out.println("Thankyou!!");
                            return;

                    default: System.out.println("\nWrong choice!");
                             break;
                }

            }
        }
        
    }
}