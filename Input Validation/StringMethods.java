import java.util.Scanner;

public class StringMethods
{
    public void unusualHello(String name)
    {
        System.out.println("unusualHello("+name+") >>> Hello "+name+", you dummy!");
    }
    public String stringRipper(String str)
    {
        String x=str.substring(str.length() - 1);
        String y=str.substring(0,1);
        return "stringRipper("+str+") >>> "+y+x;
    }
    public boolean evenFooBar(String s) {
        int c1 = 0;
        int c2 = 0;
        for (int d = 3; d <= s.length(); d++) {
            if (s.substring(d-3,d).equals("foo")) {
                c1++;
            }
            if (s.substring(d-3,d).equals("bar")) {
                c2++;
            }
        }
        return c1 == c2;
    } 
    public int sumString(String str)
    {
        Scanner input = new Scanner(str);
        int c=0;
        while(input.hasNext())
        {
            if(input.hasNextInt())
            {
                c+=(input.nextInt());
            }
            else
            {
                input.next();
            }
        }
        return c;
    }
        public String decode(String key, String code)
    {
        Scanner input = new Scanner(code);
        int[] intArray = new int[(code.length() - 1) / 2];
        for(int i=0;i<intArray.length;i++){
            if(input.hasNext()){
                if(input.hasNextInt()){
                    intArray[i]=(input.nextInt());
                }
                else{
                    input.next();
                }
            }
        }
        String out = "";
        String keyNoSpaces = "";
        for(int d = 0; d < key.length(); d++){
            if(d % 2 != 0){
                keyNoSpaces += key.charAt(d);
            }
        }
        for(int t = 0; t < intArray.length; t++){
            out += keyNoSpaces.charAt(intArray[t]);
        }
        return out;
    }
}